package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

/**
 * Created by 0x6k7 on 11/12/2021.
 */
public class Guesser extends ListenerAdapter {
    public String bot_prefix = "/";

    private static String getRandomWords(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "guess")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "guess [text]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                String argss = "";
                for (String arg : args) {
                    argss += arg + " ";
                }

                if(argss.contains("?") || argss.contains("/")) {
                    if(args[1].toLowerCase().contains("guess") || args[1].toLowerCase().contains("who")) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Guess Error");
                        error.setDescription("That does not sound like a question");
                        e.getChannel().sendMessage(error.build()).queue();
                    }

                    else {
                        String[] guesser = {"Да.", "Нет.", "Не может быть.", "Возможно.", "Невозможно.", "Маловероятно.", "Очень сомневаюсь.", "Скорее да, чем нет.", "Скорее нет, чем да.", "Несомненно."};
                        e.getChannel().sendMessage(getRandomWords(guesser)).queue();
                    }
                }

                else {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Format Error");
                    error.setDescription("Invalid command usage, to get command usage type /guess");
                    e.getChannel().sendMessage(error.build()).queue();
                }
            }
        }
    }
}
