package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.MiscUtil;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by 0x6k7 on 11/1/2021.
 */
public class Uptime extends ListenerAdapter {
    public String bot_prefix = "/";

    private static String formatTime(long seconds) {
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24L);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

        String dayStr = day > 1 ? "d " : "d ";
        String hourStr = hours > 1 ? "h " : "h ";
        String minStr = minute > 1 ? "m " : "m ";
        String secStr = minute > 1 ? "s " : "s ";

        String str = "";

        if (day > 0)
            str += day + dayStr;
        if (hours > 0)
            str += hours + hourStr;
        if (minute > 0)
            str += minute + minStr;
        if (second > 0)
            str += second + secStr;

        return str;
    }

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "uptime")) {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            long uptime = runtime.getUptime();
            long uptimeSeconds = uptime / 1000;
            final String uptimeToString = formatTime(uptimeSeconds);

            e.getChannel().sendMessage("Uptime: " + uptimeToString).queue();
            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
        }
    }
}
