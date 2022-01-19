package me.d0x6k7.Bot;

import me.d0x6k7.Bot.commands.fun.*;
import me.d0x6k7.Bot.commands.moderation.*;
import me.d0x6k7.Bot.commands.owner.*;
import me.d0x6k7.Bot.commands.user.*;
import me.d0x6k7.Bot.events.*;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        String Bot_Version = "2.6.4";

        JDABuilder jdaBuilder = JDABuilder.createDefault("");
        jdaBuilder.setActivity(Activity.playing("/help " + " | " + "Version: " + Bot_Version));
        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_PRESENCES);
        jdaBuilder.setChunkingFilter(ChunkingFilter.ALL);
        jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL);
        jdaBuilder.enableCache(CacheFlag.ACTIVITY);

        // Commands
        jdaBuilder.addEventListeners(new Clear());
        jdaBuilder.addEventListeners(new Help());
        jdaBuilder.addEventListeners(new Say());
        jdaBuilder.addEventListeners(new Encoder());
        jdaBuilder.addEventListeners(new Decoder());
        jdaBuilder.addEventListeners(new ReverseString());
        jdaBuilder.addEventListeners(new Date());
        jdaBuilder.addEventListeners(new ServerInfo());
        jdaBuilder.addEventListeners(new Shutdown());
        jdaBuilder.addEventListeners(new UserInfo());
        jdaBuilder.addEventListeners(new Ping());
        jdaBuilder.addEventListeners(new IsUp());
        jdaBuilder.addEventListeners(new Uptime());
        jdaBuilder.addEventListeners(new Meme());
        jdaBuilder.addEventListeners(new Guesser());
        jdaBuilder.addEventListeners(new Kick());
        jdaBuilder.addEventListeners(new Mute());
        jdaBuilder.addEventListeners(new Ban());
        jdaBuilder.addEventListeners(new Roles());
        jdaBuilder.addEventListeners(new GitHubInfo());
        jdaBuilder.addEventListeners(new Joke());
        jdaBuilder.addEventListeners(new ImageFilter());
        jdaBuilder.addEventListeners(new Overlays());
        jdaBuilder.addEventListeners(new ChangeUserName());
        jdaBuilder.addEventListeners(new Screen());

        // Events
        jdaBuilder.addEventListeners(new MemberJoin());
        jdaBuilder.addEventListeners(new MemberLeave());

        jdaBuilder.build();
    }
}
