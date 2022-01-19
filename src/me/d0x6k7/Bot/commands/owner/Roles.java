package me.d0x6k7.Bot.commands.owner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 11/15/2021.
 */
public class Roles extends ListenerAdapter {
    public String bot_prefix = "/";


    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "addrole")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "addrole [role] [username]");
                e.getChannel().sendMessage(usage.build()).queue();
            }
            else {
                try {
                    Member member = e.getMessage().getMentionedMembers().get(0);
                    Member usermember = e.getMember();
                    Role role = e.getMessage().getMentionedRoles().get(0);
                    if(member.hasPermission(Permission.MANAGE_ROLES)) {
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You cannot add role to the owner of the server");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }

                    else {
                        if (usermember.hasPermission(Permission.MANAGE_ROLES)) {
                            if (e.getMessage().getMentionedRoles().toArray().length == 1) {
                                if (e.getMessage().getMentionedUsers().toArray().length == 1) {
                                    e.getGuild().addRoleToMember(member, role).queue();
                                    e.getChannel().sendMessage("Added the role " + role.getAsMention() + " to " + member.getAsMention()).queue();
                                } else {
                                    EmbedBuilder user = new EmbedBuilder();
                                    user.setColor(Color.RED);
                                    user.setTitle("User Error");
                                    user.setDescription("Mention only 1 user");
                                    e.getChannel().sendMessage(user.build()).queue();
                                }
                            }
                            else {
                                EmbedBuilder embedBuilder = new EmbedBuilder();
                                embedBuilder.setColor(Color.RED);
                                embedBuilder.setTitle("Role Error");
                                embedBuilder.setDescription("Mention only 1 role");
                                e.getChannel().sendMessage(embedBuilder.build()).queue();
                            }
                        }

                        else {
                            EmbedBuilder noperms = new EmbedBuilder();
                            noperms.setColor(Color.RED);
                            noperms.setTitle("Permission Error");
                            noperms.setDescription("You have no permissions to add role to this member");
                            e.getChannel().sendMessage(noperms.build()).queue();
                        }
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder invalidusage = new EmbedBuilder();
                    invalidusage.setColor(Color.RED);
                    invalidusage.setTitle("Format Error");
                    invalidusage.setDescription("Invalid command usage, to get command usage type /addrole");
                    e.getChannel().sendMessage(invalidusage.build()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "removerole")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "removerole [role] [username]");
                e.getChannel().sendMessage(usage.build()).queue();
            }
            else {
                try {
                    Member member = e.getMessage().getMentionedMembers().get(0);
                    Member usermember = e.getMember();
                    Role role = e.getMessage().getMentionedRoles().get(0);
                    if(member.isOwner()) {
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You cannot remove role from the owner of the server");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }

                    else {
                        if (usermember.hasPermission(Permission.MANAGE_ROLES)) {
                            if (e.getMessage().getMentionedRoles().toArray().length == 1) {
                                if (e.getMessage().getMentionedUsers().toArray().length == 1) {
                                    e.getGuild().removeRoleFromMember(member, role).queue();
                                    e.getChannel().sendMessage("Removed the role " + role.getAsMention() + " from " + member.getAsMention()).queue();
                                } else {
                                    EmbedBuilder user = new EmbedBuilder();
                                    user.setColor(Color.RED);
                                    user.setTitle("User Error");
                                    user.setDescription("Mention only 1 user");
                                    e.getChannel().sendMessage(user.build()).queue();
                                }
                            }
                            else {
                                EmbedBuilder embedBuilder = new EmbedBuilder();
                                embedBuilder.setColor(Color.RED);
                                embedBuilder.setTitle("Role Error");
                                embedBuilder.setDescription("Mention only 1 role");
                                e.getChannel().sendMessage(embedBuilder.build()).queue();
                            }
                        }

                        else {
                            EmbedBuilder noperms = new EmbedBuilder();
                            noperms.setColor(Color.RED);
                            noperms.setTitle("Permission Error");
                            noperms.setDescription("You have no permissions to remove role from this member");
                            e.getChannel().sendMessage(noperms.build()).queue();
                        }
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder noperms = new EmbedBuilder();
                    noperms.setColor(Color.RED);
                    noperms.setTitle("Format Error");
                    noperms.setDescription("Invalid command usage, to get command usage type /removerole");
                    e.getChannel().sendMessage(noperms.build()).queue();
                }
            }
        }
    }
}
