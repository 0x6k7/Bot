package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class ReverseString extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "rev")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "rev [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                String argss = "";
                for (String arg : args) {
                    argss += arg + " ";
                }

                if(!args[1].contains("/rev")) {
                    StringBuilder sb = new StringBuilder(argss.replace("/rev", ""));
                    e.getChannel().sendMessage("Reversing...").complete().editMessage("Reversed:" + sb.reverse()).queue();
                }
            }
        }
    }
}
