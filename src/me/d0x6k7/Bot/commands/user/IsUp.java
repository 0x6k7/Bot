package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.net.ssl.SSLHandshakeException;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.UnknownHostException;
import java.security.cert.CertificateException;

/**
 * Created by 0x6k7 on 10/30/2021.
 */
public class IsUp extends ListenerAdapter {
    public String bot_prefix = "/";
    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "isup")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "isup [url]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                if(!args[1].contains("htt")) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Invalid URL Format");
                    error.setDescription("This is not a URL");
                    e.getChannel().sendMessage(error.build()).queue();
                }

                else {
                    try {
                        URL url = new URL(args[1]);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        int statusCode = connection.getResponseCode();

                        if (statusCode == 200 || statusCode == 403) {
                            EmbedBuilder success = new EmbedBuilder();
                            success.setColor(Color.GREEN);
                            success.setTitle("Site Status");
                            success.setDescription(args[1] + " is up");
                            e.getChannel().sendMessage(success.build()).queue();
                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Site Status");
                            error.setDescription(args[1] + " is down");
                            e.getChannel().sendMessage(error.build()).queue();
                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }
                    } catch (IOException e2) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Host Error");
                        error.setDescription("Either site does not exist or the site was blocked");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }
    }
}
