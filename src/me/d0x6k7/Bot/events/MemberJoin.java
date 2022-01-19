package me.d0x6k7.Bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

/**
 * Created by 0x6k7 on 10/23/2021.
 */
public class MemberJoin extends ListenerAdapter {
    private String[] joinmessages = {
            "[member] joined. You must construct additional pylons.",
            "Never gonna give [member] up. Never let [member] down!",
            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!",
            "We've been expecting you, [member].",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "Brace yourselves. [member] just joined the server.",
            "A wild [member] appeared.",
            "[memeber] has joined. We hope you brought pizza"
    };

    public void onGuildMemberJoin (GuildMemberJoinEvent e) {
        Random rand = new Random();
        int num = rand.nextInt(joinmessages.length);

        EmbedBuilder joined = new EmbedBuilder();
        joined.setColor(Color.CYAN);
        joined.setDescription(joinmessages[num].replace("[member]", e.getMember().getAsMention()));

        e.getGuild().getDefaultChannel().sendMessage(joined.build()).queue();
    }
}
