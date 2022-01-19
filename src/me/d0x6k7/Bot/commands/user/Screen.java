package me.d0x6k7.Bot.commands.user;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

/**
 * Created by 0x6k7 on 1/6/2022.
 */
public class Screen extends ListenerAdapter {
    public String bot_prefix = "/";

    public static String getRandomWords(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(bot_prefix + "screen")) {
//            String[] randomWords = {"qqlla", "ghadx", "kaslo", "qyazx", "leljf", "lolas", "ktwer", "nzmhq", "kekhc", "blyad", "sfare", "jkalx", "llkqw", "hjhjx", "cykaa", "dfdfx", "warde"};
            String[] randomWords = {"qqwsq", "eerxw", "rrtze", "ttyxr", "jjaat", "uuiiy", "ggkku", "ppdai", "ssdqo", "ffdxp", "gghha", "hhjss", "jjkld", "kkllf", "zzgg", "mxcxh", "vvbbj"};

            String[] randomWords2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "f", "g", "h", "i", "j", "l", "y", "p", "r", "m", "v", "z", "x"};

            e.getChannel().sendMessage("https://prnt.sc/" + getRandomWords(randomWords) + getRandomWords(randomWords2)).queue();
        }
    }
}
