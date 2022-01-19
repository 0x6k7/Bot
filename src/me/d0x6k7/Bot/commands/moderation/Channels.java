package me.d0x6k7.Bot.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 11/23/2021.
 */
public class Channels extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "createchannel")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "createchannel [name]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                try {
                    Member member = e.getMember();
                    if(member.hasPermission(Permission.MANAGE_CHANNEL)) {
                        e.getGuild().createTextChannel(args[1]).queue();
                        e.getChannel().sendMessage("A channel " + args[1] + " has been created").queue();
                    }

                    else {
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("You have no permissions to create channel in this server");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }
                } catch (IndexOutOfBoundsException e2) {
                    EmbedBuilder noperms = new EmbedBuilder();
                    noperms.setColor(Color.RED);
                    noperms.setTitle("Format Error");
                    noperms.setDescription("Invalid command usage, to get command usage type /createchannel");
                    e.getChannel().sendMessage(noperms.build()).queue();
                }
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "removechannel")) {
            try {
                Member member = e.getMember();
                if(!member.hasPermission(Permission.MANAGE_CHANNEL)) {
                    e.getGuild().getTextChannelById(e.getChannel().getId()).delete().queue();
                }

                else {
                    EmbedBuilder noperms = new EmbedBuilder();
                    noperms.setColor(Color.RED);
                    noperms.setTitle("Permission Error");
                    noperms.setDescription("You have no permissions to remove channel in this server");
                    e.getChannel().sendMessage(noperms.build()).queue();
                }
            } catch (IndexOutOfBoundsException e2) {
                EmbedBuilder noperms = new EmbedBuilder();
                noperms.setColor(Color.RED);
                noperms.setTitle("Format Error");
                noperms.setDescription("Invalid command usage, to get command usage type /removechannel");
                e.getChannel().sendMessage(noperms.build()).queue();
            }
        }
    }
}
