package me.d0x6k7.Bot.commands.user;

import me.d0x6k7.Bot.utils.FindUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 0x6k7 on 10/23/2021.
 */
public class ServerInfo extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "serverinfo")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

            // Get a list of members
            String[] getMembers = new String[e.getGuild().getMembers().size()];
            for(int i = 0; i < e.getGuild().getMembers().size(); i++) {
                getMembers[i] = e.getGuild().getMembers().get(i).getEffectiveName();
            }

            EmbedBuilder server = new EmbedBuilder();
            server.setColor(Color.CYAN);
            server.setTitle("Information about: " + e.getGuild().getName());
            server.setThumbnail(e.getGuild().getIconUrl());
            server.addField("Owner: ", String.valueOf(e.getGuild().getOwner().getEffectiveName()), false);
            server.addField("Server Region: ", String.valueOf(e.getGuild().getRegion()), false);
            server.addField("ID: ", String.valueOf(e.getGuild().getId()), false);
            server.addField("Creation Date: ", dtf.format(e.getGuild().getTimeCreated()), false);
            server.addField("Total Members: ", String.valueOf(e.getGuild().getMemberCount()), false);
            server.addField("Members: ", Arrays.toString(getMembers), false);
            server.addField("Roles: ", FindUtils.serverGetRoles(e.getGuild().getRoles()), false);
            server.setFooter("Generated by " + e.getAuthor().getName(), e.getAuthor().getAvatarUrl());
            e.getChannel().sendMessage(server.build()).queue();
            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
        }
    }
}