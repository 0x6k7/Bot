package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Created by 0x6k7 on 10/24/2021.
 */
public class Ping extends ListenerAdapter {
    public String bot_prefix = "/";

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(bot_prefix + "ping")) {
            long ping = e.getJDA().getGatewayPing();
            e.getChannel().sendMessage("Pinging...").complete().editMessage("Pong: " + ping + " ms").queue();
            System.out.println("User " + e.getAuthor().getName() + ": " + e.getMessage().getContentRaw());
        }
    }
}
