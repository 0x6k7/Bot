package me.d0x6k7.Bot.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 0x6k7 on 11/14/2021.
 */
public class Ban extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "ban")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "ban [username] [days]");
                e.getChannel().sendMessage(usage.build()).queue();
            } else {
                // Check if member and bot has permissions to ban

                try {
                    Member member = e.getMessage().getMentionedMembers().get(0);
                    Member selfMember = e.getGuild().getSelfMember();
                    Member selfUser = e.getMember();

                    if (!selfUser.hasPermission(Permission.MANAGE_PERMISSIONS)) { // canInteract(member))
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You have no permissions to ban this member");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }

                    else {
                        if (!selfMember.canInteract(member)) {
                            EmbedBuilder noperms = new EmbedBuilder();
                            noperms.setColor(Color.RED);
                            noperms.setTitle("Permission Error");
                            noperms.setDescription("Bot has no permissions to ban this member");
                            e.getChannel().sendMessage(noperms.build()).queue();
                        } else {
                            List<Member> mentionedMembers = e.getMessage().getMentionedMembers();
                            if (!mentionedMembers.isEmpty()) {
                                for (Member mentionedMember : mentionedMembers) {
                                    e.getGuild().ban(mentionedMember, Integer.parseInt(args[2])).queue();
                                }
                                e.getChannel().sendMessage(args[1] + " has been banned for " + args[2] + " day(s)").queue();
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder invalid = new EmbedBuilder();
                    invalid.setColor(Color.RED);
                    invalid.setTitle("Format Error");
                    invalid.setDescription("Invalid command usage, to get command usage type /ban");
                    e.getChannel().sendMessage(invalid.build()).queue();
                }
            }
        }
    }
}
