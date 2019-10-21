import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static Map<Character,Integer>map=new HashMap<>();
    private static void setMap(){
        map.put('2',0);
        map.put('3',1);
        map.put('4',2);
        map.put('5',3);
        map.put('6',4);
        map.put('7',5);
        map.put('8',6);
        map.put('9',7);
        map.put('1',8);
        map.put('J',9);
        map.put('Q',10);
        map.put('K',11);
        map.put('A',12);
        map.put('$',13);
        map.put('&',14);
        map.put('*',15);
        map.put('#',16);
    }
    private static String[] sort(String[] str) {
        //for(int i=0;i<=12;i++){
        //    System.out.println(str[i]);
        //}
        for(int i=0;i<=11;i++)
        {
            //System.out.println(i);
            for(int j=i+1;j<=12;j++)
            {
                //System.out.println(str[i].charAt(0)+" "+str[j].charAt(0));
                //System.out.println(map.get(str[i].charAt(0))+" "+map.get
                // (str[j].charAt(0)));
                if(map.get(str[i].charAt(0))<map.get(str[j].charAt(0)))
                {
                    //System.out.println(i+" "+j);
                    String ss=str[i];
                    str[i]=str[j];
                    str[j]=ss;
                }
            }
        }
        for(int i=0;i<=12;i++)
        {
            for(int j=i+1;j<=12;j++)
            {
                if(map.get(str[i].charAt(0))==map.get(str[j].charAt(0)))
                    if(map.get(str[i].charAt(1))>map.get(str[j].charAt(1)))
                    {
                        String ss=str[i];
                        str[i]=str[j];
                        str[j]=ss;
                    }
            }
        }
        return str;
    }
    public static void main(String[] args)throws IOException {
        String str=null;
        setMap();
        str=getapi.getCard();
        String[] card=str.split(",");
        String outputPath="D:\\IDEA2019\\IdeaProject\\13water\\src\\output.txt";
        File file=new File(outputPath);
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
        for(String ch:card)
        {

            if(ch.length()<10)continue;
            String[] s=ch.split(" ");
            String[] st=sort(s);
            result.getResult(st,map);
            /*bufferedWriter.write(ch+"\n");
            if(judge.isSpecial(st,bufferedWriter,map))
            {
                bufferedWriter.write("是特殊牌型\n");
            }
            else
            {
                bufferedWriter.write("不是特殊牌型\n");
            }*/
        }
        //bufferedWriter.flush();
        //bufferedWriter.close();
    }
}
