package me.d0x6k7.Bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

/**
 * Created by 0x6k7 on 10/23/2021.
 */
public class MemberLeave extends ListenerAdapter {
    private String[] leavemessage = {
            "[member] left, the party's over",
            "We're sorry to see you go, [member]"
    };

    public void onGuildMemberLeave (GuildMemberLeaveEvent e) {
        Random rand = new Random();
        int num = rand.nextInt(leavemessage.length);

        EmbedBuilder joined = new EmbedBuilder();
        joined.setColor(Color.RED);
        joined.setDescription(leavemessage[num].replace("[member]", e.getMember().getAsMention()));

        e.getGuild().getDefaultChannel().sendMessage(joined.build()).queue();
    }
}
