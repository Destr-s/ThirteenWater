import java.io.*;
public class getapi {
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
