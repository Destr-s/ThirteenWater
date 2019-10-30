import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Solve {
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
        for(int i=0;i<=11;i++)
        {
            for(int j=i+1;j<=12;j++)
            {
                if(map.get(str[i].charAt(0))<map.get(str[j].charAt(0)))
                {
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
    public static String[] solve(String str)throws IOException {
        setMap();
        if(str.charAt(0)==' '){
            str=str.substring(1,str.length());
        }
        if(str.charAt(str.length()-1)==' '){
            str=str.substring(0,str.length()-1);
        }
        String[] card=str.split(" ");
        for(int i=0;i<=12;i++){
            card[i]=card[i].substring(0,2);
        }
        card=sort(card);
        String[] ans= Result.getResult(card,map);

        return ans;
    }
}
