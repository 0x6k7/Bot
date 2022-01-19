package me.d0x6k7.Bot.commands.user;

import me.d0x6k7.Bot.utils.FindUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.awt.*;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Decoder extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        // Decoding base64 string

        if(args[0].equalsIgnoreCase(bot_prefix + "b64d")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "b64d [text]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                try {
                    if(FindUtils.isBase64String(args[1])) {
                        byte[] decoded = Base64.getDecoder().decode(args[1]);
                        String encodedBytes = new String(decoded);
                        e.getChannel().sendMessage("Decoding...").complete().editMessage("Decoded:" + encodedBytes).queue();
                        System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                    }

                    else {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException i) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Decode Error");
                    error.setDescription("An error occurred while decoding base64 string");
                    e.getChannel().sendMessage(error.build()).queue();
                }
            }
        }
    }
}
