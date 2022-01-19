package me.d0x6k7.Bot.commands.owner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 10/23/2021.
 */
public class Shutdown extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "shutdown")) {
            Member member = e.getMember();
            if(member != null) {
                if(member.hasPermission(Permission.ADMINISTRATOR)) {
                    EmbedBuilder turnoff = new EmbedBuilder();
                    turnoff.setColor(Color.GREEN);
                    turnoff.setDescription("The bot was turned off");
                    e.getChannel().sendMessage(turnoff.build()).queue();
                    System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                    e.getJDA().shutdown();
                }

                else {
                    EmbedBuilder noperms = new EmbedBuilder();
                    noperms.setColor(Color.RED);
                    noperms.setTitle("Permission Error");
                    noperms.setDescription("This is a developer-only feature");
                    e.getChannel().sendMessage(noperms.build()).queue();
                }
            }
        }
    }
}
