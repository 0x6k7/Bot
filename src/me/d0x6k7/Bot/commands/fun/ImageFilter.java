package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * Created by 0x6k7 on 12/1/2021.
 */
public class ImageFilter extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "filter")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "filter [grey/invert/brightness/threshold/sepia/burple/blur] [url]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                try {
                    if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("grey")) {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/greyscale?avatar=" + args[2];
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
                    }
                } catch (IndexOutOfBoundsException i) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Format Error");
                    error.setDescription("Invalid command usage, to get command usage type /filter");
                    e.getChannel().sendMessage(error.build()).queue();
                }

                try {
                    if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("invert")) {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/invert?avatar=" + args[2];
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
                    }
                } catch (IndexOutOfBoundsException i) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Format Error");
                    error.setDescription("Invalid command usage, to get command usage type /filter");
                    e.getChannel().sendMessage(error.build()).queue();
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("invertgrey")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/invertgreyscale?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("brightness")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/brightness?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("threshold")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/threshold?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("sepia")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/sepia?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("blurple")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/blurple?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("pixelate")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/pixelate?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }

                if (args[0].equalsIgnoreCase(bot_prefix + "filter") && args[1].equalsIgnoreCase("blur")) {
                    try {
                        if(!args[2].contains("mp4")) {
                            String imageURL = "https://some-random-api.ml/canvas/blur?avatar=" + args[2];
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
                        error.setDescription("Invalid command usage, to get command usage type /filter");
                        e.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }
    }
}
