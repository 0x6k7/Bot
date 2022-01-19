package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Say extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "say")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "say [text]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                try {
                    String argss = "";
                    for (String arg : args) {
                        argss += arg + " ";
                    }
                    if(!args[1].contains("/")) {
                        e.getChannel().sendMessage(argss.replace("/say", "")).queue();
                    }
                    System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                } catch (IllegalStateException e2) {

                }
            }
        }
    }
}
