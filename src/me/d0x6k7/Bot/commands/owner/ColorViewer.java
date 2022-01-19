package me.d0x6k7.Bot.commands.owner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 12/4/2021.
 */
public class ColorViewer extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "colorviewer")) {
            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "colorviewer [hex]");
                e.getChannel().sendMessage(usage.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            }

            else {
                try {
                    Member member = e.getMember();
                    if(member != null) {
                        if(member.hasPermission(Permission.ADMINISTRATOR)) {
                            if(args[1].contains("0") || (args[1].contains("1") || (args[1].contains("2") || (args[1].contains("3") || (args[1].contains("4") || (args[1].contains("5") || (args[1].contains("6") || (args[1].contains("7") || (args[1].contains("8") || (args[1].contains("9") || (args[1].contains("10")))))))))))) {
                                String imageURL = "https://some-random-api.ml/canvas/colorviewer?hex=" + args[1];
                                EmbedBuilder image = new EmbedBuilder();

                                image.setColor(Color.GREEN);
                                image.setImage(imageURL);

                                e.getChannel().sendMessage(image.build()).queue();
                                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                            }

                            else if(!member.isOwner()) {
                                EmbedBuilder error = new EmbedBuilder();
                                error.setColor(Color.RED);
                                error.setTitle("Permission Error");
                                error.setDescription("This is a developer-only feature");
                                e.getChannel().sendMessage(error.build()).queue();
                                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                            }

                            else {
                                EmbedBuilder error = new EmbedBuilder();
                                error.setColor(Color.RED);
                                error.setTitle("Format Error");
                                error.setDescription("Enter hex value");
                                e.getChannel().sendMessage(error.build()).queue();
                                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                            }
                        }
                    }
                } catch (NullPointerException n) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Username Error");
                    error.setDescription("Could not get username");
                    e.getChannel().sendMessage(error.build()).queue();
                    System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                }
            }
        }
    }
}
