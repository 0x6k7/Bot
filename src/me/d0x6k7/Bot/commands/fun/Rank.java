package me.d0x6k7.Bot.commands.fun;

import me.d0x6k7.Bot.utils.FileUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.*;

/**
 * Created by 0x6k7 on 12/5/2021.
 */
public class Rank extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "purge") && args[1].equalsIgnoreCase("list")) {
            File f = new File("Rank.txt");
            if(f.exists()) {
                if(f.delete()) {
                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("List");
                    embedBuilder.setColor(Color.GREEN);
                    embedBuilder.setTitle("List has been cleared");
                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                }

                else {
                    System.out.println("Failed");
                }
            }
        }

        else if (args[0].equalsIgnoreCase(bot_prefix + "rank") && args[1].equalsIgnoreCase("list")) {
            try {
                File f = new File("Rank.txt");
                if(f.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(f);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

                    String newLine;
                    while ((newLine = br.readLine()) != null) {
                        e.getChannel().sendMessage(newLine).queue();
                    }
                    fileInputStream.close();
                }

                else {
                    EmbedBuilder notfound = new EmbedBuilder();
                    notfound.setColor(Color.RED);
                    notfound.setTitle("List");
                    notfound.setDescription("List not found");
                    e.getChannel().sendMessage(notfound.build()).queue();
                }
            } catch (IOException f2) {
                System.out.println("Could not read file");
            }
        }

        else if (args[0].equalsIgnoreCase(bot_prefix + "add") && args[1].equalsIgnoreCase("rank")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "add rank [username] [text]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                File f = new File("Rank.txt");
                if(!f.exists()) {
                    FileUtils.writeFile("Rank.txt", "User " + args[2] + " has " + args[3] + " rank");

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("List");
                    embedBuilder.setColor(Color.GREEN);
                    embedBuilder.setTitle("List has been created");
                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                }

                else {
                    FileUtils.writeFileNextLine("Rank.txt", "User " + args[2] + " has " + args[3] + " rank");

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("List");
                    embedBuilder.setColor(Color.GREEN);
                    embedBuilder.setTitle("List has been updated");
                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                }
            }
        }
    }
}
