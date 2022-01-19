package me.d0x6k7.Bot.utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x6k7 on 12/5/2021.
 */
public class FindUtils {
    private static final Pattern HexPattern = Pattern.compile("\\p{XDigit}+");

    public static boolean isBase64String(String string) {
        String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        Pattern r = Pattern.compile(pattern);
        Matcher matched = r.matcher(string);

        if(matched.find()) {
            return true;
        }

        else {
            return false;
        }
    }

    public static boolean isHex(String str) {
        final Matcher matcher = HexPattern.matcher(str);
        return matcher.matches();
    }

    public static String userGetRoles(List roleList) {
        String roles;
        if(!roleList.isEmpty()) {
            Role role = (Role) roleList.get(0);
            roles = role.getName();
            for(int i = 1; i < roleList.size(); i++) {
                role = (Role) roleList.get(i);
                roles = roles + ", " + role.getName();
            }
        }

        else {
            roles = "User has no roles";
        }
        return roles;
    }

    public static String serverGetRoles(List roleList) {
        String roles;
        if(!roleList.isEmpty()) {
            Role role = (Role) roleList.get(0);
            roles = role.getName();
            for(int i = 1; i < roleList.size(); i++) {
                role = (Role) roleList.get(i);
                roles = roles + ", " + role.getName();
            }
        }

        else {
            roles = "Server has no roles";
        }
        return roles;
    }

    public static Role findMemberRole(Member member, String role) {
        List<Role> rolesList = member.getRoles();
        return rolesList.stream().filter(roleList -> roleList.getName().equals(role)).findFirst().orElse(null);
    }
}
