package src;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class SaveSession {

    private boolean isSessionWrote = false;

    private HashMap<String, Integer> usersBestValues;


    public static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    public void showBestPlayers(Graphics g){
        ArrayList<String> data = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./bestTable.txt"));
            String line = reader.readLine();
            int counter = 0;
            g.drawString("Последние игры: ", 235, 40);
            while (line != null) {
                g.drawString(line, 235, 50 + ((counter + 1)* 20));
                line = reader.readLine();
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getBestPlayers(){
        String filePath = "./bestTable.txt";

        String content = null;
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }






    public void saveSession(String username, int score) {
        if(!isSessionWrote){


            ArrayList<String> data = new ArrayList<String>();
            int counter = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("./bestTable.txt"));
                String line = reader.readLine();

                while (line != null) {
                    counter++;
                    if(!line.startsWith(username)){
                        data.add(line);
                    }

                    line = reader.readLine();
                }
                data.add(username + ": " + score);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            try{
                FileWriter out = new FileWriter("./bestTable.txt");
                System.out.println(data);
                for(int i = data.size() - 1; i >= data.size() - 3; i--){
                    out.write(data.get(i) + "\n");
                    System.out.println(data.get(i));
                }
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }








    public void setSessionWrote(boolean sessionFlag){
        isSessionWrote = sessionFlag;
    }

}
