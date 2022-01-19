package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Clear extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "clear")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "clear [amount of messages]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                try {
                    Member member = e.getMember();
                    if(member.hasPermission(Permission.MANAGE_WEBHOOKS)) {
                        List<Message> msgs = e.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                        e.getChannel().deleteMessages(msgs).queue();
                        System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());

                        EmbedBuilder success = new EmbedBuilder();
                        success.setColor(Color.GREEN);
                        success.setTitle("Successfully deleted " + args[1] + " messages");
                        e.getChannel().sendMessage(success.build()).queue();
                        System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                    }

                    else {
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You have no permissions to clear messages in this channel");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }
                } catch (IllegalArgumentException l) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Message Error");
                    error.setDescription("Message limit must be between 1 and 100");
                    e.getChannel().sendMessage(error.build()).queue();
                }
            }
        }
    }
}
