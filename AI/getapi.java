import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.*;
import java.io.*;
public class getapi {
    public static JsonObject startGame(String token) throws IOException {
        String urlPath="https://api.shisanshui.rtxux.xyz/game/open";
        URL url=new URL(urlPath);
        HttpURLConnection httpURLConnection=
                (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("X-Auth-Token",token);
        httpURLConnection.setDoOutput(true);
        BufferedReader bufferedReader=
                new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String str="";
        String line;
        while((line=bufferedReader.readLine())!=null)
        {
            str+=line;
        }
        JsonObject jsonObject=new JsonParser().parse(str).getAsJsonObject();
        return jsonObject;
    }
    public static void postCard(String token,JsonObject jsonObject) throws IOException {
        String urlPath="https://api.shisanshui.rtxux.xyz/game/submit";
        URL url=new URL(urlPath);
        HttpURLConnection httpURLConnection=
                (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type","application/json");
        httpURLConnection.setRequestProperty("X-Auth-Token",token);
        httpURLConnection.setDoOutput(true);

        PrintStream printStream=
                new PrintStream(httpURLConnection.getOutputStream());
        printStream.print(jsonObject);
        printStream.close();
        BufferedReader bufferedReader=
                new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String str="";
        String line;
        while((line=bufferedReader.readLine())!=null) {
            str += line;
        }
    }
    public static String getCard() throws IOException {
        String inputPath="D:\\IDEA2019\\IdeaProject\\13water\\src\\input.txt";
        File file=new File(inputPath);
        if(!file.exists())
            file.createNewFile();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String s,str="";
        while((s=bufferedReader.readLine())!=null)
        {
            str+=",";
            str+=s;
        }
        bufferedReader.close();
        return str;
    }

}
