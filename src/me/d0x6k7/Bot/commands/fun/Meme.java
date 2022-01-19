package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

/**
 * Created by 0x6k7 on 11/7/2021.
 */
public class Meme extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "meme")) {
            String url;
            String title;
            String postLink;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://meme-api.herokuapp.com/gimme/funny").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                url = (String) jsonObject.get("url");
                title = (String) jsonObject.get("title");
                postLink = (String) jsonObject.get("postLink");

                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setTitle(title, postLink);
                embedBuilder.setColor(Color.GREEN);
                embedBuilder.setImage(url);

                e.getChannel().sendMessage(embedBuilder.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("Site is down at the moment").queue();
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "discord")) {
            String url;
            String title;
            String postLink;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://meme-api.herokuapp.com/gimme/discordapp").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                title = (String) jsonObject.get("title");
                url = (String) jsonObject.get("url");
                postLink = (String) jsonObject.get("postLink");

                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setTitle(title, postLink);
                embedBuilder.setColor(Color.GREEN);
                embedBuilder.setImage(url);

                e.getChannel().sendMessage(embedBuilder.build()).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("Site is down at the moment").queue();
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "cat")) {
            String url;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://aws.random.cat/meow").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                url = (String) jsonObject.get("file");
                e.getChannel().sendMessage(url).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("Site is down at the moment").queue();
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "dog")) {
            String url;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://dog.ceo/api/breeds/image/random").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                url = (String) jsonObject.get("message");
                e.getChannel().sendMessage(url).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("Site is down at the moment").queue();
            }
        }

        if (args[0].equalsIgnoreCase(bot_prefix + "birb")) {
            String url;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://some-random-api.ml/animal/birb").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                url = (String) jsonObject.get("image");
                e.getChannel().sendMessage(url).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("Site is down at the moment").queue();
            }
        }
    }
}
