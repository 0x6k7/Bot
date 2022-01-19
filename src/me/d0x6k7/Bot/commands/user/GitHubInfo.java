package me.d0x6k7.Bot.commands.user;

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
 * Created by 0x6k7 on 11/20/2021.
 */
public class GitHubInfo extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "github")) {
            if(args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.BLACK);
                usage.setTitle("Command usage: ");
                usage.setDescription("Usage: " + bot_prefix + "github [username]");
                e.getChannel().sendMessage(usage.build()).queue();
            }

            else {
                OkHttpClient fetchRequest = new OkHttpClient();
                Request request = new Request.Builder().url("https://api.github.com/users/" + args[1]).build();
                EmbedBuilder github = new EmbedBuilder();

                try {
                    Response response = fetchRequest.newCall(request).execute();
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    String getUserName = jsonObject.getString("name");
                    String getBio = "None";
                    String getLocation = "Unknown";
                    String getWebsite = "None";

                    try {
                        getBio = jsonObject.getString("bio");
                        getLocation = jsonObject.getString("location");
                    } catch (JSONException j) {

                    }

                    if(!jsonObject.getString("blog").equals(""))
                        getWebsite = jsonObject.getString("blog");

                    String title = "https://github.com/" + args[1];
                    github.setColor(Color.CYAN);
                    github.setTitle(getUserName + "'s info", title);
                    github.setThumbnail(jsonObject.getString("avatar_url"));

                    github.addField("Bio: ", getBio, false);
                    github.addField("Location: ", getLocation, false);
                    github.addField("Website: ", getWebsite, false);
                    github.addField("Public repositories: ", String.valueOf(jsonObject.getInt("public_repos")), false);
                    github.addField("Public gists: ", String.valueOf(jsonObject.getInt("public_gists")), false);

                    github.addField("Followers: ", String.valueOf(jsonObject.getInt("followers")), false);
                    github.addField("Following: ", String.valueOf(jsonObject.getInt("following")), false);

                    e.getChannel().sendMessage(github.build()).queue();
                } catch (IOException | NullPointerException e2) {
                    e.getChannel().sendMessage("Site is down at the moment").queue();
                } catch (JSONException j3) {
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
