import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
        int n=100;//循环次数
        //JsonObject jsonObject3=new JsonObject();
        //jsonObject3.addProperty("username","username");
        //jsonObject3.addProperty("password","password");
        //System.out.println(jsonObject3.toString());
        //JsonObject jsonObject4=Getapi.login(jsonObject3);
        //System.out.println(jsonObject4.toString());
        //JsonObject jsonObject5=jsonObject4.getAsJsonObject("data");
        //String token =jsonObject5.get("token").getAsString();
        String token="f44ae3e5-1498-479c-bca4-05f227ff95eb";
		//可以在这里输入token直接运行或者在上面输入用户名和密码运行
        while(n>=0){
            n--;
            try{
                JsonObject jsonObject=Getapi.getCard(token);
                System.out.println(jsonObject.toString());
                JsonObject jsonObject1=jsonObject.getAsJsonObject("data");
                String id=jsonObject1.get("id").getAsString();
                String s=jsonObject1.get("card").getAsString();
                //System.out.println(id+" "+s);
                String[] ans=Solve.solve(s);
                JsonArray jsonArray=new JsonArray();
                jsonArray.add(ans[0]);
                jsonArray.add(ans[1]);
                jsonArray.add(ans[2]);
                JsonObject jsonObject2=new JsonObject();
                jsonObject2.addProperty("id",id);
                jsonObject2.add("card",jsonArray);
                System.out.println(jsonObject2.toString());
                Getapi.postCard(jsonObject2,token);
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("运行时间="+(end-start)+"ms");


    }
}
