package me.d0x6k7.Bot.utils;

import java.io.*;

/**
 * Created by 0x6k7 on 12/5/2021.
 */
public class FileUtils {
    public static void writeFile(String file, String text) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
            System.out.println(file + " has been created");
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
    }

    public static void writeFileNextLine(String file, String newText) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append('\n');
            bw.append(newText);
            bw.close();
            System.out.println(file + " has been created");
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
    }

    public static boolean readFile(String file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

            String newLine;
            while ((newLine = br.readLine()) != null) {
                System.out.println(newLine);
            }
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return false;
    }
}
