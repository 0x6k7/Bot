package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 12/2/2021.
 */
public class Overlays extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "overlay")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "overlay [wasted/passed/jail/triggered/comrade] [url]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                if (args[0].equalsIgnoreCase(bot_prefix + "overlay") && args[1].equalsIgnoreCase("wasted")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/wasted?avatar=" + args[2];
                            EmbedBuilder image = new EmbedBuilder();

                            image.setTitle("Image: ");
                            image.setColor(Color.GREEN);
                            image.setImage(imageURL);

                            e.getChannel().sendMessage(image.build()).queue();

                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Format Error");
                            error.setDescription("Please provide an image url");
                            e.getChannel().sendMessage(error.build()).queue();
                        }
                    } catch (IndexOutOfBoundsException i) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Format Error");
                        error.setDescription("Invalid command usage, to get command usage type /overlay");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "overlay") && args[1].equalsIgnoreCase("passed")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/passed?avatar=" + args[2];
                            EmbedBuilder image = new EmbedBuilder();

                            image.setTitle("Image: ");
                            image.setColor(Color.GREEN);
                            image.setImage(imageURL);

                            e.getChannel().sendMessage(image.build()).queue();

                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Format Error");
                            error.setDescription("Please provide an image url");
                            e.getChannel().sendMessage(error.build()).queue();
                        }
                    } catch (IndexOutOfBoundsException i) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Format Error");
                        error.setDescription("Invalid command usage, to get command usage type /overlay");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "overlay") && args[1].equalsIgnoreCase("jail")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/jail?avatar=" + args[2];
                            EmbedBuilder image = new EmbedBuilder();

                            image.setTitle("Image: ");
                            image.setColor(Color.GREEN);
                            image.setImage(imageURL);

                            e.getChannel().sendMessage(image.build()).queue();

                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Format Error");
                            error.setDescription("Invalid command usage, to get command usage type /overlay");
                            e.getChannel().sendMessage(error.build()).queue();
                        }
                    } catch (IndexOutOfBoundsException i) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Format Error");
                        error.setDescription("Invalid command usage, to get command usage type /overlay");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "overlay") && args[1].equalsIgnoreCase("triggered")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/triggered?avatar=" + args[2];
                            EmbedBuilder image = new EmbedBuilder();

                            image.setTitle("Image: ");
                            image.setColor(Color.GREEN);
                            image.setImage(imageURL);

                            e.getChannel().sendMessage(image.build()).queue();

                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Format Error");
                            error.setDescription("Invalid command usage, to get command usage type /overlay");
                            e.getChannel().sendMessage(error.build()).queue();
                        }
                    } catch (IndexOutOfBoundsException i) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Format Error");
                        error.setDescription("Invalid command usage, to get command usage type /overlay");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "overlay") && args[1].equalsIgnoreCase("comrade")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/comrade?avatar=" + args[2];
                            EmbedBuilder image = new EmbedBuilder();

                            image.setTitle("Image: ");
                            image.setColor(Color.GREEN);
                            image.setImage(imageURL);

                            e.getChannel().sendMessage(image.build()).queue();

                            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                        }

                        else {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(Color.RED);
                            error.setTitle("Format Error");
                            error.setDescription("Invalid command usage, to get command usage type /overlay");
                            e.getChannel().sendMessage(error.build()).queue();
                        }
                    } catch (IndexOutOfBoundsException i) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("Format Error");
                        error.setDescription("Invalid command usage, to get command usage type /overlay");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }
    }
}
