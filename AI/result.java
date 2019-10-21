import java.util.HashMap;
import java.util.Map;
public class result {
    public static String card1="&2 *3 $4",card2="&2 *3 $4 #5 *7",card3="&2 *3 $4 #5 *7";
    public static String[] s1=new String[3],s2=new String[5],s3=new String[5];
    public static int snum1,snum2,snum3;
    private static void init(){
        s1=card1.split(" ");
        s2=card2.split(" ");
        s3=card3.split(" ");
        snum1=1;
        snum2=1;
        snum3=1;
    }
    private static Map<Character,Integer>map=new HashMap<>();
    private static String[] sort(String[] str){
        for(int i=0;i<=11;i++) {
            for(int j=i+1;j<=12;j++){
                if(map.get(str[i].charAt(1))>map.get(str[j].charAt(1))) {
                    String ss=str[i];
                    str[i]=str[j];
                    str[j]=ss;
                }
            }
        }
        return str;
    }
    private static boolean isths(String[] str) {
        if(str.length<5)return false;
        char z=str[0].charAt(0);
        for(int i=1;i<str.length;i++)
        {
            if(str[i].charAt(0)!=z||map.get(str[i].charAt(1))-map.get(str[i-1].charAt(1))!=1) {
                return false;
            }
        }
        return true;
    }
    private static boolean iszd(String[] str){
        if(str.length<5)return false;
        int[] a=new int[13];
        for(int i=0;i<=4;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        for(int i=0;i<=12;i++)
        {
            if(a[i]==4){
                return true;
            }
        }
        return false;
    }
    private static boolean ishl(String[] str){
        if(str.length<5)return false;
        int[] a=new int[13];
        for(int i=0;i<=4;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++){
            if(a[i]==2)sum++;
            if(a[i]==3)sum++;
        }
        if(sum==2)return true;
        return false;
    }
    private static boolean isth(String[] str){
        if(str.length<5)return false;
        char z=str[0].charAt(0);
        for(int i=0;i<str.length;i++) {
            if(str[i].charAt(0)!=z){
                return false;
            }
        }
        return true;
    }
    private static boolean issz(String[] str){
        if(str.length<5)return false;
        for(int i=1;i<str.length;i++){
            if(map.get(str[i].charAt(1))-map.get(str[i].charAt(1))!=1){
                return false;
            }
        }
        return true;
    }
    private static boolean isst(String[] str){
        int[] a=new int[13];
        for(int i=0;i<str.length;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        for(int i=0;i<=12;i++){
            if(a[i]==3)return true;
        }
        return false;
    }
    private static boolean ised(String[] str){
        if(str.length<5)return false;
        int[] a=new int[13];
        for(int i=0;i<=4;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++){
            if(a[i]==2)sum++;
        }
        if(sum==2)return true;
        return false;
    }
    private static boolean isdz(String[] str){
        int[] a=new int[13];
        for(int i=0;i<str.length;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        for(int i=0;i<=12;i++){
            if(a[i]==2)return true;
        }
        return false;
    }
    private static int judgeLevel(String[] str){
        if(isths(str))return 9;
        else if(iszd(str))return 8;
        else if(ishl(str))return 7;
        else if(isth(str))return 6;
        else if(issz(str))return 5;
        else if(isst(str))return 4;
        else if(ised(str))return 3;
        else if(isdz(str))return 2;
        else return 1;
    }
    private static void replace(String[] str,int num,int no){
        if(no==1){
            for(int i=0;i<=2;i++) {
                s1[i]=str[i];
            }
            snum1=num;
        }
        else if(no==2){
            for(int i=0;i<=4;i++){
                s2[i]=str[i];
            }
            snum2=num;
        }
        else if(no==3){
            for(int i=0;i<=4;i++){
                s3[i]=str[i];
            }
            snum3=num;
        }
    }
    private static int calcuWater(String[] str1,String[] str2,int level1,
                                  int level2,int no){
        int ans=0;
        int max1=0,max2=0;
        int[] a=new int[13];
        int[] b=new int[13];
        if(level1<level2)
        {
            switch (level2){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    ans=1;
                    break;
                case 7:
                    if(no==2)
                        ans=2;
                    else ans=1;
                    break;
                case 8:
                    if(no==2)
                        ans=8;
                    else ans=4;
                    break;
                case 9:
                    if(no==2)
                        ans=10;
                    else ans=5;
                    break;
            }
        }
        else if(level1>level2){
            switch (level2){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    ans=-1;
                    break;
                case 7:
                    if(no==2)
                        ans=-2;
                    else ans=-1;
                    break;
                case 8:
                    if(no==2)
                        ans=-8;
                    else ans=-4;
                    break;
                case 9:
                    if(no==2)
                        ans=-10;
                    else ans=-5;
                    break;
            }
        }
        else if(level1==level2){
            switch (level1){
                case 5:
                case 6:
                case 1:
                    for(int i=0;i<str1.length;i++){
                        if(max1<map.get(str1[i].charAt(1))){
                            max1=map.get(str1[i].charAt(1));
                        }
                        if(max2<map.get(str2[i].charAt(1))){
                            max2=map.get(str2[i].charAt(1));
                        }
                    }
                    if(max1<max2)
                        ans=1;
                    else if(max1>max2)
                        ans=-1;
                    break;
                case 2:
                    for(int i=0;i< str1.length;i++){
                        a[map.get(str1[i].charAt(1))]++;
                        b[map.get(str2[i].charAt(1))]++;
                    }
                    for(int i=0;i<=12;i++){
                        if(a[i]==2)max1=i;
                        if(b[i]==2)max2=i;
                    }
                    if(max1<max2)ans=1;
                    else if(max1>max2)ans=-1;
                    break;
                case 3:
                    for(int i=0;i< str1.length;i++){
                        a[map.get(str1[i].charAt(1))]++;
                        b[map.get(str2[i].charAt(1))]++;
                    }
                    for(int i=0;i<=12;i++){
                        if(a[i]==2&&max1<i)max1=i;
                        if(b[i]==2&&max2<i)max2=i;
                    }
                    if(max1<max2)ans=1;
                    else if(max1>max2)ans=-1;
                    break;
                case 4:
                    for(int i=0;i< str1.length;i++){
                        a[map.get(str1[i].charAt(1))]++;
                        b[map.get(str2[i].charAt(1))]++;
                    }
                    for(int i=0;i<=12;i++){
                        if(a[i]==3)max1=i;
                        if(b[i]==3)max2=i;
                    }
                    if(max1<max2)ans=1;
                    else if(max1>max2)ans=-1;
                    break;
                case 7:
                    for(int i=0;i< str1.length;i++){
                        a[map.get(str1[i].charAt(1))]++;
                        b[map.get(str2[i].charAt(1))]++;
                    }
                    for(int i=0;i<=12;i++){
                        if(a[i]==3)max1=i;
                        if(b[i]==3)max2=i;
                    }
                    if(max1==max2)
                    {
                        for(int i=0;i<=12;i++){
                            if(a[i]==2)max1=i;
                            if(b[i]==2)max2=i;
                        }
                    }
                    if(max1<max2){
                        if(no==2)ans=2;
                        else ans=1;
                    }
                    else if(max1>max2) {
                        if (no==2)ans=-2;
                        else ans=-1;
                    }
                    break;
                case 8:
                    for(int i=0;i< str1.length;i++){
                        a[map.get(str1[i].charAt(1))]++;
                        b[map.get(str2[i].charAt(1))]++;
                    }
                    for(int i=0;i<=12;i++){
                        if(a[i]==4)max1=i;
                        if(b[i]==4)max2=i;
                    }
                    if(max1<max2){
                        if(no==2)ans=8;
                        else ans=4;
                    }
                    else if(max1>max2){
                        if(no==2)ans=-8;
                        else ans=-4;
                    }
                    break;
                case 9:
                    for(int i=0;i<str1.length;i++){
                        if(max1<map.get(str1[i].charAt(1))){
                            max1=map.get(str1[i].charAt(1));
                        }
                        if(max2<map.get(str2[i].charAt(1))){
                            max2=map.get(str2[i].charAt(1));
                        }
                    }
                    if(max1<max2){
                        if(no==2)ans=10;
                        else ans=5;
                    }
                    else if(max1>max2)
                        if(no==2)ans=-10;
                        else ans=-5;
                    break;
            }
        }
        return ans;
    }
    private static void compare(String c1,String c2,String c3){
        int level1,level2,level3;
        int point=0;
        c1=c1.substring(0,8);
        c2=c2.substring(0,14);
        c3=c3.substring(1,15);
        String[] str1=c1.split(" ");
        String[] str2=c2.split(" ");
        String[] str3=c3.split(" ");
        level1=judgeLevel(str1);
        level2=judgeLevel(str2);
        level3=judgeLevel(str3);
        if(calcuWater(str2,str3,level2,level3,1)<0)return;
        point+=calcuWater(s1,str1,snum1,level1,1);
        point+=calcuWater(s2,str2,snum2,level2,2);
        point+=calcuWater(s3,str3,snum3,level3,3);

        if(point>0){
            replace(str1,level1,1);
            replace(str2,level2,2);
            replace(str3,level3,3);
        }
        //System.out.println(level1);
        //System.out.println(level2);
        //System.out.println(level3);
    }
    private static void enumerate(String[] str){
        String s=" ";
        for(int i=0;i<=12;i++){
            s=s+str[i].substring(0,2);
            s+=" ";
        }
        int a1=0,a2=1,a3=2;
        int b1=0,b2=1,b3=2,b4=3,b5=4;
        while(a1<10){
            String ss=s;
            String c1=ss.substring(a1*3+1,(a1+1)*3+1)+ss.substring(a2*3+1,
                    (a2+1)*3+1)+ss.substring(a3*3+1,(a3+1)*3+1);
            while(b1<5){
                String sss=ss.substring(0,a1*3+1)
                        +ss.substring((a1+1)*3+1, a2*3+1)
                        +ss.substring((a2+1)*3+1,a3*3+1)
                        +ss.substring((a3+1)*3+1,40);
                String c2= sss.substring(b1*3+1,(b1+1)*3+1)
                                +sss.substring(b2*3+1,(b2+1)*3+1)
                                +sss.substring(b3*3+1,(b3+1)*3+1)
                                +sss.substring(b4*3+1,(b4+1)*3+1)
                                +sss.substring(b5*3+1,(b5+1)*3+1);
                String c3=sss.substring(0,b1*3+1)
                        +sss.substring((b1+1)*3+1,b2*3+1)
                        +sss.substring((b2+1)*3+1,b3*3+1)
                        +sss.substring((b3+1)*3+1,b4*3+1)
                        +sss.substring((b4+1)*3+1,b5*3+1)
                        +sss.substring((b5+1)*3+1,31);
                compare(c1,c2,c3);
                //if(b1>=5)break;
                if(b5==9){
                    if(b4!=8){
                        b4++;
                        b5=b4+1;
                    }
                    else{
                        if(b3!=7){
                            b3++;
                            b4=b3+1;
                            b5=b4+1;
                        }
                        else{
                            if(b2!=6){
                                b2++;
                                b3=b2+1;
                                b4=b3+1;
                                b5=b4+1;
                            }
                            else{
                                b1++;
                                b2=b1+1;
                                b3=b2+1;
                                b4=b3+1;
                                b5=b4+1;
                            }
                        }
                    }
                }
                else b5++;
            }
            //if(a1>=10)break;
            if(a3==12){
                if(a2!=11){
                    a2++;
                    a3=a2+1;
                }
                else{
                    a1++;
                    a2=a1+1;
                    a3=a2+1;
                }
            }
            else a3++;
        }
    }
    public static String getResult(String[] str,Map m){
        card1=str[0]+" "+str[1]+" "+str[2];
        card2=str[3]+" "+str[4]+" "+str[5]+" "+str[6]+" "+str[7];
        card3=str[8]+" "+str[9]+" "+str[10]+" "+str[11]+" "+str[12];
        init();
        map=m;
        str=sort(str);
        enumerate(str);
        card1="";
        card2="";
        card3="";
        for(int i=0;i<s1.length;i++)
        {
            card1+=s1[i];
            if(i!=s1.length-1)
                card1+=" ";
        }
        for(int i=0;i<s2.length;i++)
        {
            card2+=s2[i];
            if(i!=s2.length-1)
                card2+=" ";
        }
        for(int i=0;i<s3.length;i++)
        {
            card3+=s3[i];
            if(i!=s3.length-1)
                card3+=" ";
        }
        String ansstr=card1+" "+card2+" "+card3;
        //System.out.println(ansstr);
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        return ansstr;
    }
}
