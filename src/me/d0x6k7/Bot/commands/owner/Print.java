package me.d0x6k7.Bot.commands.owner;

import me.d0x6k7.Bot.utils.FindUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Print extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "print")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "print [text]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                try {
                    Member member = e.getMember();
                    if(member != null) {
                        if(member.hasPermission(Permission.ADMINISTRATOR)) {
                            String argss = "";
                            for (String arg : args) {
                                argss += arg + "";
                            }

                            EmbedBuilder granted = new EmbedBuilder();
                            granted.setColor(Color.GREEN);
                            granted.setTitle("Print");
                            granted.setDescription("Granted!");
                            e.getChannel().sendMessage(granted.build()).queue();
                            System.out.println(argss.replace("/print", ""));
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Permission Error");
                            error.setDescription("This is a developer-only feature");
                            e.getChannel().sendMessage(error.build()).queue();
                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }
                    }
                } catch (NullPointerException n) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Username Error");
                    error.setDescription("Could not get username");
                    e.getChannel().sendMessage(error.build()).queue();
                    System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                }
            }
        }
    }
}
