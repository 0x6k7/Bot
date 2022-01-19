package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.commons.codec.binary.Hex;

import java.awt.*;
import java.util.Base64;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Encoder extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "b64")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "b64 [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                // Encoding base64 string

                String text = "";
                for(String arg : args) {
                    text += arg + " ";
                }

                String encoded = Base64.getEncoder().encodeToString((text.replace("/b64", "")).getBytes());
                e.getChannel().sendMessage("Encoding...").complete().editMessage("Encoded: " + encoded).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }
        }
    }
}
