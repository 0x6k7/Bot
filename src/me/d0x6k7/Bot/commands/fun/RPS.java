package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

/**
 * Created by 0x6k7 on 12/14/2021.
 */
public class RPS extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "rps")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "rps [rock/paper/scissors]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                String botAction[] = {":rock:", ":page_facing_up:", ":scissors:"};

                if(args[0].equals(bot_prefix + "rps") && args[1].equals("rock")) {
                    EmbedBuilder result = new EmbedBuilder();
                    result.setColor(Color.WHITE);
                    result.setTitle("Game: ");
                    result.addField("You have chosen: ", ":rock:", false);
                    result.addField("Bot has chosen: ", getRandomAction(botAction), false);
                    e.getChannel().sendMessage(result.build()).queue();
                }

                if(args[0].equals(bot_prefix + "rps") && args[1].equals("paper")) {
                    EmbedBuilder result = new EmbedBuilder();
                    result.setColor(Color.WHITE);
                    result.setTitle("Game: ");
                    result.addField("You have chosen: ", ":page_facing_up:", false);
                    result.addField("Bot has chosen: ", getRandomAction(botAction), false);
                    e.getChannel().sendMessage(result.build()).queue();
                }

                if(args[0].equals(bot_prefix + "rps") && args[1].equals("scissors")) {
                    EmbedBuilder result = new EmbedBuilder();
                    result.setColor(Color.WHITE);
                    result.setTitle("Game: ");
                    result.addField("You have chosen: ", ":scissors:", false);
                    result.addField("Bot has chosen: ", getRandomAction(botAction), false);
                    e.getChannel().sendMessage(result.build()).queue();
                }
            }
        }
    }

    private static String getRandomAction(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}
