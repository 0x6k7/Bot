package me.d0x6k7.Bot.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 12/16/2021.
 */
public class ChangeUserName extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "username")) {
            try {
                Member member = e.getMessage().getMentionedMembers().get(0);
                Member selfMember = e.getGuild().getSelfMember();
                Member selfUser = e.getMember();

                if (!selfUser.hasPermission(Permission.NICKNAME_CHANGE)) {
                    EmbedBuilder noperms = new EmbedBuilder();
                    noperms.setColor(Color.RED);
                    noperms.setTitle("Permission Error");
                    noperms.setDescription("You have no permissions to change username");
                    e.getChannel().sendMessage(noperms.build()).queue();
                }

                else {
                    if (!selfMember.canInteract(member) || !selfMember.hasPermission(Permission.NICKNAME_CHANGE)) {
                        EmbedBuilder noperms = new EmbedBuilder();
                        noperms.setColor(Color.RED);
                        noperms.setTitle("Permission Error");
                        noperms.setDescription("Bot has no permissions to change username");
                        e.getChannel().sendMessage(noperms.build()).queue();
                    }

                    else {
                        if (!args[2].isEmpty()) {
                            e.getGuild().modifyNickname(member, args[2]).queue();
                            e.getChannel().sendMessage("Username has been changed to " + args[2]).queue();
                        }
                    }
                }
            } catch (IndexOutOfBoundsException i) {
                EmbedBuilder invalid = new EmbedBuilder();
                invalid.setColor(Color.RED);
                invalid.setTitle("Format Error");
                invalid.setDescription("Invalid command usage, to get command usage type /username");
                e.getChannel().sendMessage(invalid.build()).queue();
            }
        }
    }
}
