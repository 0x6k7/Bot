package me.d0x6k7.Bot.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

/**
 * Created by 0x6k7 on 11/14/2021.
 */
public class Mute extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "mute")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "mute [username] [reason]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                // Check if member and bot has permissions to mute

                try {
                    Member member = e.getMessage().getMentionedMembers().get(0);
                    Member selfMember = e.getGuild().getSelfMember();
                    Member selfUser = e.getMember();

                    if (!selfUser.hasPermission(Permission.MANAGE_PERMISSIONS)) { // canInteract(member))
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You have no permissions to mute this member");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    } else {
                        if (!selfMember.canInteract(member)) {
                            EmbedBuilder noperms = new EmbedBuilder();
                            noperms.setColor(Color.RED);
                            noperms.setTitle("Permission Error");
                            noperms.setDescription("Bot has no permissions to mute this member");
                            e.getChannel().sendMessage(noperms.build()).queue();
                        } else {
                            if (!args[2].isEmpty()) {
                                Role role = e.getGuild().getRolesByName("Muted", false).get(0);
                                List<Member> mentionedMembers = e.getMessage().getMentionedMembers();
                                for (Member mentionedMember : mentionedMembers) {
                                    e.getGuild().addRoleToMember(mentionedMember, role).queue();
                                }
                                e.getChannel().sendMessage(args[1] + " has been muted for " + args[2]).queue();
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder invalid = new EmbedBuilder();
                    invalid.setColor(Color.RED);
                    invalid.setTitle("Format Error");
                    invalid.setDescription("Invalid command usage, to get command usage type /mute");
                    e.getChannel().sendMessage(invalid.build()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "unmute")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "unmute [username] [reason]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                // Check if member and bot has permissions to unmute

                try {
                    Member member = e.getMessage().getMentionedMembers().get(0);
                    Member selfMember = e.getGuild().getSelfMember();
                    Member selfUser = e.getMember();

                    if (!selfUser.hasPermission(Permission.MANAGE_PERMISSIONS)) { // canInteract(member))
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You have no permissions to unmute this member");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }

                    else {
                        if(!selfMember.canInteract(member)) {
                            EmbedBuilder noperms = new EmbedBuilder();
                            noperms.setColor(Color.RED);
                            noperms.setTitle("Permission Error");
                            noperms.setDescription("Bot has no permissions to mute this member");
                            e.getChannel().sendMessage(noperms.build()).queue();
                        }

                        else {
                            if(!args[2].isEmpty()) {
                                Role role = e.getGuild().getRolesByName("Muted", false).get(0);
                                List<Member> mentionedMembers = e.getMessage().getMentionedMembers();
                                for (Member mentionedMember : mentionedMembers) {
                                    e.getGuild().removeRoleFromMember(mentionedMember, role).queue();
                                }
                                e.getChannel().sendMessage(args[1] + " has been unmuted for " + args[2]).queue();
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder invalid = new EmbedBuilder();
                    invalid.setColor(Color.RED);
                    invalid.setTitle("Format Error");
                    invalid.setDescription("Invalid command usage, to get command usage type /unmute");
                    e.getChannel().sendMessage(invalid.build()).queue();
                }
            }
        }
    }
}
