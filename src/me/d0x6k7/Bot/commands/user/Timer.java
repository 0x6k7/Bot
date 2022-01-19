package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by 0x6k7 on 11/29/2021.
 */
public class Timer extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "newyear")) {
            LocalDate newYear1 = LocalDate.parse("2021-12-31");
            LocalDate today = LocalDate.now();

            LocalDate newYear = newYear1.withYear(today.getYear());
            LocalDate nextNewYear = today.isAfter(newYear) ? today.withYear(today.getYear() + 1) : newYear;

            e.getChannel().sendMessage(":snowflake: New Year is in " + DAYS.between(today, nextNewYear) + " day(s) :snowflake:").queue();
        }
    }
}
