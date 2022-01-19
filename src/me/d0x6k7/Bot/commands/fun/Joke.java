package me.d0x6k7.Bot.commands.fun;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by 0x6k7 on 12/1/2021.
 */
public class Joke extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "dadjoke")) {
            String joke;
            OkHttpClient httpCaller = new OkHttpClient();
            Request request = new Request.Builder().url("https://some-random-api.ml/joke").build();
            try {
                Response response = httpCaller.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(response.body().string());
                joke = (String) jsonObject.get("joke");
                e.getChannel().sendMessage(joke).queue();
                System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
            } catch (IOException | NullPointerException | JSONException e2) {
                e.getChannel().sendMessage("An error occurred while fetching a joke").queue();
            }
        }
    }
}
