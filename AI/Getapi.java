import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.*;
import java.io.*;
public class Getapi {
    public static JsonObject login(JsonObject jsonObject)throws IOException{//登录
        JsonObject jsonObject1=new JsonObject();
        try{
            String urlPath="http://api.revth.com/auth/login";
            URL url=new URL(urlPath);
            HttpURLConnection httpURLConnection=
                    (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
            httpURLConnection.setDoOutput(true);
            PrintStream printStream=
                    new PrintStream(httpURLConnection.getOutputStream());
            printStream.print(jsonObject);
            printStream.close();
            if(httpURLConnection.getResponseCode()==200)
            {
                BufferedReader bufferedReader=
                        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String str="";
                String line;
                while((line=bufferedReader.readLine())!=null) {
                    str += line;
                }
                //System.out.println(str);
                jsonObject1=new JsonParser().parse(str).getAsJsonObject();
                return jsonObject1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject1;
    }
    public static JsonObject startGame(String token) throws IOException {//要牌
        JsonObject jsonObject=new JsonObject();
        try {
            String urlPath="http://api.revth.com/game/open";
            URL url=new URL(urlPath);
            //URL url=new URL(new URI(urlPath).toASCIIString());
            HttpURLConnection httpURLConnection=
                    (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("X-Auth-Token",token);
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
            httpURLConnection.setDoOutput(true);
            int responsecode=httpURLConnection.getResponseCode();
            if(responsecode==200)
            {
                BufferedReader bufferedReader=
                        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String str="";
                String line;
                while((line=bufferedReader.readLine())!=null)
                {
                    str+=line;
                }
                //System.out.println(str);
                jsonObject=new JsonParser().parse(str).getAsJsonObject();
                return jsonObject;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static void postCard(JsonObject jsonObject,String token) throws IOException {//出牌
        String urlPath="http://api.revth.com/game/submit";
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
        System.out.println(str);
    }
    public static JsonObject getCard(String token) throws IOException {
        /*String inputPath="D:\\IDEA2019\\IdeaProject\\13water\\src\\input.txt";
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
        bufferedReader.close();*/
        JsonObject jsonObject=startGame(token);
        return jsonObject;
    }

}
