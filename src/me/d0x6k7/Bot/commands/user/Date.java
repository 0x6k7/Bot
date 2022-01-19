package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Created by 0x6k7 on 10/21/2021.
 */
public class Date extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime New_York = LocalDateTime.now(TimeZone.getTimeZone("America/New_York").toZoneId());
        LocalDateTime Chicago = LocalDateTime.now(TimeZone.getTimeZone("America/Chicago").toZoneId());
        LocalDateTime Los_Angeles = LocalDateTime.now(TimeZone.getTimeZone("America/Los Angeles").toZoneId());
        LocalDateTime Kiev = LocalDateTime.now(TimeZone.getTimeZone("Europe/Kiev").toZoneId());
        LocalDateTime Warsaw = LocalDateTime.now(TimeZone.getTimeZone("Europe/Warsaw").toZoneId());
        LocalDateTime London = LocalDateTime.now(TimeZone.getTimeZone("Europe/London").toZoneId());
        LocalDateTime Moscow = LocalDateTime.now(TimeZone.getTimeZone("Europe/Moscow").toZoneId());
        LocalDateTime Berlin = LocalDateTime.now(TimeZone.getTimeZone("Europe/Berlin").toZoneId());
        LocalDateTime Athens = LocalDateTime.now(TimeZone.getTimeZone("Europe/Athens").toZoneId());
        LocalDateTime Tokyo = LocalDateTime.now(TimeZone.getTimeZone("Asia/Tokyo").toZoneId());
        LocalDateTime Shanghai = LocalDateTime.now(TimeZone.getTimeZone("Asia/Shanghai").toZoneId());
        LocalDateTime Canberra = LocalDateTime.now(TimeZone.getTimeZone("Australia/Canberra").toZoneId());
        LocalDateTime Cairo = LocalDateTime.now(TimeZone.getTimeZone("Africa/Cairo").toZoneId());

        if(args[0].equalsIgnoreCase(bot_prefix + "date")) {
            EmbedBuilder date = new EmbedBuilder();
            date.setColor(Color.CYAN);
            date.setTitle("Date and Time");
            date.addField("New York", String.valueOf(dtf.format(New_York)), true);
            date.addField("Chicago", String.valueOf(dtf.format(Chicago)), true);
            date.addField("Los Angeles", String.valueOf(dtf.format(Los_Angeles)), true);
            date.addField("Kyiv", String.valueOf(dtf.format(Kiev)), true);
            date.addField("Warsaw", String.valueOf(dtf.format(Warsaw)), true);
            date.addField("London", String.valueOf(dtf.format(London)), true);
            date.addField("Moscow", String.valueOf(dtf.format(Moscow)), true);
            date.addField("Athens", String.valueOf(dtf.format(Athens)), true);
            date.addField("Berlin", String.valueOf(dtf.format(Berlin)), true);
            date.addField("Tokyo", String.valueOf(dtf.format(Tokyo)), true);
            date.addField("Shanghai", String.valueOf(dtf.format(Shanghai)), true);
            date.addField("Canberra", String.valueOf(dtf.format(Canberra)), true);
            date.addField("Cairo", String.valueOf(dtf.format(Cairo)), true);
            e.getChannel().sendMessage(date.build()).queue();
            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
        }
    }
}
