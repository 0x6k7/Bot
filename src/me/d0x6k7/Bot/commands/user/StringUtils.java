package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 12/22/2021.
 */
public class StringUtils extends ListenerAdapter {
    public java.lang.String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        java.lang.String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "uppercase")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "uppercase [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                String argss = "";
                for(String arg : args) {
                    argss += arg + " ";
                }

                if(!args[1].contains("/uppercase")) {
                    String replace = argss.replace("/uppercase", "");
                    e.getChannel().sendMessage("Modifying...").complete().editMessage("Modified:" + replace.toUpperCase()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "lowercase")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "lowercase [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                String argss = "";
                for(java.lang.String arg : args) {
                    argss += arg + " ";
                }

                if(!args[1].contains("/lowercase")) {
                    String replace = argss.replace("/lowercase", "");
                    e.getChannel().sendMessage("Modifying...").complete().editMessage("Modified:" + replace.toLowerCase()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "length")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "length [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                String argss = "";
                for(String arg : args) {
                    argss += arg + " ";
                }

                if(!args[1].contains("/length")) {
                    String replace = argss.replace("/length", "");
                    e.getChannel().sendMessage("Getting the length...").complete().editMessage("Length of the string: " + replace.length()).queue();
                }
            }
        }
    }
}
