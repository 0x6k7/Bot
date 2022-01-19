package me.d0x6k7.Bot.commands.user;

import jdk.nashorn.internal.parser.JSONParser;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

/**
 * Created by 0x6k7 on 12/1/2021.
 */
public class MinecraftInfo extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "minecraftinfo")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "minecraftuser [username]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                String name;
                String uuid;
                OkHttpClient httpCaller = new OkHttpClient();
                Request request = new Request.Builder().url("https://some-random-api.ml/mc?username=" + args[1]).build();
                try {
                    Response response = httpCaller.newCall(request).execute();
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    name = (String) jsonObject.get("username");
                    uuid = (String) jsonObject.get("uuid");
                    e.getChannel().sendMessage("Fetching...").complete().editMessage("Fetched!").complete();

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle(name + "'s info");
                    embedBuilder.setColor(Color.GREEN);
                    embedBuilder.addField("Uuid: ", uuid, false);

                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                    System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
                } catch (IOException | NullPointerException e2) {
                    e.getChannel().sendMessage("Site is down at the moment").queue();
                } catch (JSONException j) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Username Error");
                    error.setDescription("Username not found");
                    e.getChannel().sendMessage(error.build()).queue();
                }
            }
        }
    }
}
