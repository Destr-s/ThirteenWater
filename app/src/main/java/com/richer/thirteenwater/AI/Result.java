package com.richer.thirteenwater.AI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class Result {
    public static String card1="&2 *3 $4",card2="&2 *3 $4 #5 *7",card3="&2 *3 $4 #5 *7";
    public static String[] s1=new String[3],s2=new String[5],s3=new String[5];
    public static int snum1,snum2,snum3;
    private static void init(){
        card1="&2 *3 $4";
        card2="&2 *3 $4 #5 *7";
        card3="&2 *3 $4 #5 *7";
        s1=card1.split(" ");
        s2=card2.split(" ");
        s3=card3.split(" ");
        snum1=judgeLevel(s1);
        snum2=judgeLevel(s2);
        snum3=judgeLevel(s3);
        //System.out.println(snum1+" "+snum2+" "+snum3);
    }
    private static Map<Character,Integer>map=new HashMap<>();
    private static String[] sort(String[] str){
        for(int i=0;i<=11;i++) {
            for(int j=i+1;j<=12;j++){
                if(map.get(str[i].charAt(1))<map.get(str[j].charAt(1))) {
                    String ss=str[i];
                    str[i]=str[j];
                    str[j]=ss;
                }
            }
        }
        return str;
    }
    private static boolean isths(String[] str) {
        //if(str.length<5)return false;
        char z=str[0].charAt(0);
        for(int i=1;i<str.length;i++)
        {
            if(str[i].charAt(0)!=z||map.get(str[i-1].charAt(1))-map.get(str[i].charAt(1))!=1) {
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
        int sum1=0,sum2=0;
        for(int i=0;i<=12;i++){
            if(a[i]==2)sum1++;
            if(a[i]==3)sum2++;
        }
        if(sum1==1&&sum2==1)return true;
        return false;
    }
    private static boolean isth(String[] str){
        //if(str.length<5)return false;
        char z=str[0].charAt(0);
        for(int i=0;i<str.length;i++) {
            if(str[i].charAt(0)!=z){
                return false;
            }
        }
        return true;
    }
    private static boolean issz(String[] str){
        //if(str.length<5)return false;
        for(int i=1;i<str.length;i++){
            if(map.get(str[i-1].charAt(1))-map.get(str[i].charAt(1))!=1){
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
    private static boolean islxed(String[] str){
        if(str.length<5)return false;
        int[] a=new int[13];
        for(int i=0;i<=4;i++){
            a[map.get(str[i].charAt(1))]++;
        }
        int[] x=new int[13];
        int xx=0;
        for(int i=0;i<=12;i++){
            if(a[i]==2)x[xx++]=i;
        }
        if(x[0]+1==x[1])return true;
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
        if(isths(str))return 10;
        else if(iszd(str))return 9;
        else if(ishl(str))return 8;
        else if(isth(str))return 7;
        else if(issz(str))return 6;
        else if(isst(str))return 5;
        else if(islxed(str))return 4;
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
    private static int compare(String[] str1,String[] str2,int level1,
                                  int level2,int no1,int no2){
        if(level1<level2)return 0;
        else if(level1>level2)return 1;
        if(no1==1&&no2==2){
            if(level1==10||level1==7||level1==6||level1==5){
                return 0;
            }
        }
        if(level1==1){
            //System.out.println(1);
            int i=0,j=0;
            while(i<str1.length&&j<str2.length){
                if(map.get(str1[i].charAt(1))>map.get(str2[j].charAt(1)))
                    return 1;
                if(map.get(str1[i].charAt(1))<map.get(str2[j].charAt(1)))
                    return 0;
                i++;
                j++;
            }
            return 1;
        }
        if(level1==2){
            //System.out.println(2);

            int[] a=new int[13];
            int[] b=new int[13];
            int g=0,h=0;
            for(int k=0;k<str1.length;k++){
                a[map.get(str1[k].charAt(1))]++;
            }
            for(int k=0;k<str2.length;k++){
                b[map.get(str2[k].charAt(1))]++;
            }
            for(int k=0;k<=12;k++)
            {
                if(a[k]==2){
                    g=k;
                    a[k]=0;
                }
                if(b[k]==2){
                    h=k;
                    b[k]=0;
                }
            }
            //System.out.println("aaa");
            if(g>h)return 1;
            if(g<h)return 0;
            int i=12,j=12;
            while(i>=0&&j>=0){
                while(i>=0){
                    if(a[i]>0)
                        break;
                    i--;
                }
                if(i<0)break;
                while(j>=0){
                    if(b[j]>0)
                        break;
                    j--;
                }
                if(j<0)break;
                if(i>j)return 1;
                if(i<j)return 0;
                i--;
                j--;
            }

            return 0;
        }
        if(level1==3||level1==4){
            //System.out.println(3);
            int[] a=new int[13];
            int[] b=new int[13];
            for(int i=0;i<str1.length;i++){
                a[map.get(str1[i].charAt(1))]++;
                b[map.get(str2[i].charAt(1))]++;
            }
            int[] a1=new int[13];
            int[] b1=new int[13];
            int x1=0,x2=0;
            int a2=0,b2=0;
            for(int i=0;i<=12;i++){
                if(a[i]==2){
                    a1[x1++]=i;
                    a[i]=0;
                }
                if(b[i]==2){
                    b1[x2++]=i;
                    b[i]=0;
                }
                if(a[i]==1)a2=i;
                if(b[i]==1)b2=i;
            }
            for(int i=1;i>=0;i--){
                if(a1[i]>b1[i])return 1;
                if(a1[i]<b1[i])return 0;
            }
            if(a2>b2)return 1;
            else if(a2<b2)return 0;
            else return 0;
        }
        if(level1==5||level1==8){
            //System.out.println(4);
            int[] a=new int[13];
            int[] b=new int[13];
            for(int k=0;k<str1.length;k++){
                a[map.get(str1[k].charAt(1))]++;
            }
            for(int k=0;k<str2.length;k++){
                b[map.get(str2[k].charAt(1))]++;
            }
            int g=0,h=0;
            for(int i=0;i<=12;i++){
                if(a[i]==3)g=i;
                if(b[i]==3)h=i;
            }
            if(g>h)return 1;
            else return 0;
        }
        if(level1==6||level1==7||level1==10){
            //System.out.println(5);
            for(int i=0;i<str1.length;i++){
                if(map.get(str1[i].charAt(1))>map.get(str2[i].charAt(1)))return 1;
                if(map.get(str1[i].charAt(1))<map.get(str2[i].charAt(1)))return 0;
            }
        }
        if(level1==9){
            //System.out.println(6);
            int[] a=new int[13];
            int[] b=new int[13];
            for(int i=0;i<str1.length;i++){
                a[map.get(str1[i].charAt(1))]++;
                b[map.get(str2[i].charAt(1))]++;
            }
            int g=0,h=0;
            for(int i=0;i<=12;i++){
                if(a[i]==4)g=i;
                if(b[i]==4)h=i;
            }
            if(g>h)return 1;
            else return 0;
        }
        return 1;
    }
    private static float balance(String[] str,int level){
        float x=0;
        int max=0;
        int[] a=new int[13];
        switch (level){
            case 1:
            case 6:
            case 7:
            case 10:
                for(int i=0;i<str.length;i++){
                    if(max<map.get(str[i].charAt(1))){
                        max=map.get(str[i].charAt(1));
                    }
                }
                x=(float)(max-1)/13;
                break;
            case 2:
            case 3:
            case 4:
                for(int i=0;i<str.length;i++){
                    a[map.get(str[i].charAt(1))]++;
                }
                for(int i=0;i<=12;i++){
                    if(a[i]==2){
                        if(max<i)max=i;
                    }
                }
                x=(float)(max-1)/13;
                break;
            case 5:
            case 8:
                for(int i=0;i<str.length;i++){
                    a[map.get(str[i].charAt(1))]++;
                }
                for(int i=0;i<=12;i++){
                    if(a[i]==3){
                        if(max<i)max=i;
                    }
                }
                x=(float)(max-1)/13;
                break;
            case 9:
                for(int i=0;i<str.length;i++){
                    a[map.get(str[i].charAt(1))]++;
                }
                for(int i=0;i<=12;i++){
                    if(a[i]==4){
                        if(max<i)max=i;
                    }
                }
                x=(float)(max-1)/13;
                break;
        }
        return x;
    }
    private static void calcuWater(String c1,String c2,String c3) throws IOException {
        int level1,level2,level3;
        //System.out.println(c1);
        //System.out.println(c2);
        //System.out.println(c3);
        c1=c1.substring(0,8);
        c2=c2.substring(0,14);
        c3=c3.substring(1,15);
        String[] str1=c1.split(" ");
        String[] str2=c2.split(" ");
        String[] str3=c3.split(" ");
        level1=judgeLevel(str1);
        level2=judgeLevel(str2);
        level3=judgeLevel(str3);

        //bufferedWriter.write(c1+" "+c2+" "+c3+" "+level1+" "+level2+"
        // "+level3+"\n");

        //System.out.println(c1+" "+c2+" "+c3+" "+level1+" "+level2+" "+level3);
        if(compare(str1,str2,level1,level2,1,2)==1)return;
        if(compare(str2,str3,level2,level3,2,3)==1)return;
        if(level1+level2+level3>snum1+snum2+snum3){
            replace(str1,level1,1);
            replace(str2,level2,2);
            replace(str3,level3,3);
        }
        else if(level1+level2+level3==snum1+snum2+snum3){
            float g=balance(str1,level1)+balance(str2,level2)+balance(str3,
                    level3)+(float)(level1-1)/10+(float)(level2-1)/10+(float)(level3-1)/10;
            float h=
                    balance(s1,snum1)+balance(s2,snum2)+balance(s3,snum3)+(float)(snum1-1)/10+(float)(snum2-1)/10+(float)(snum3-1)/10;
            if(g>h){
                replace(str1,level1,1);
                replace(str2,level2,2);
                replace(str3,level3,3);
            }
        }
        /*if(level1>level2)return ;
        if(level2>level3)return ;
        //System.out.println(c1+" "+c2+" "+c3+level1+" "+level2+" "+level3);
        if(calcuWater(str2,str3,level2,level3,1)<0)return;
        if(calcuWater(str1,str2,level1,level2,1)<0)return;
        point+=calcuWater(s1,str1,snum1,level1,1);
        point+=calcuWater(s2,str2,snum2,level2,2);
        point+=calcuWater(s3,str3,snum3,level3,3);

        if(point>0){
            replace(str1,level1,1);
            replace(str2,level2,2);
            replace(str3,level3,3);
        }*/
        //System.out.println(level1);
        //System.out.println(level2);
        //System.out.println(level3);
    }
    private static void enumerate(String[] str)throws IOException{
        String s=" ";
        for(int i=0;i<=12;i++){
            s=s+str[i].substring(0,2);
            s+=" ";
        }
        //System.out.println("s="+s);
        int a1=0,a2=1,a3=2;
        int b1=0,b2=1,b3=2,b4=3,b5=4;
        while(a1<=10){
            //System.out.println("a1="+a1+" "+"a2="+a2+" "+"a3="+a3);
            String ss=s;
            String c1=ss.substring(a1*3+1,(a1+1)*3+1)+ss.substring(a2*3+1,
                    (a2+1)*3+1)+ss.substring(a3*3+1,(a3+1)*3+1);
            b1=0;
            b2=1;
            b3=2;
            b4=3;
            b5=4;
            while(b1<=5){
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
                calcuWater(c1,c2,c3);
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
    public static String[] getResult(String[] str,Map m)throws IOException{

        map=m;
        str=sort(str);
        //card1=str[0]+" "+str[1]+" "+str[2];
        //card2=str[3]+" "+str[4]+" "+str[5]+" "+str[6]+" "+str[7];
        //card3=str[8]+" "+str[9]+" "+str[10]+" "+str[11]+" "+str[12];
        init();
        enumerate(str);
        card1="";
        card2="";
        card3="";
        for(int i=0;i<s1.length;i++)
        {
            if(s1[i].charAt(1)=='1')
                s1[i]+="0";
            card1+=s1[i];
            if(i!=s1.length-1)
                card1+=" ";
        }
        for(int i=0;i<s2.length;i++)
        {
            if(s2[i].charAt(1)=='1')
                s2[i]+="0";
            card2+=s2[i];
            if(i!=s2.length-1)
                card2+=" ";
        }
        for(int i=0;i<s3.length;i++)
        {
            if(s3[i].charAt(1)=='1')
                s3[i]+="0";
            card3+=s3[i];
            if(i!=s3.length-1)
                card3+=" ";
        }
        String[] ansstr=new String[3];
        ansstr[0]=card1;
        ansstr[1]=card2;
        ansstr[2]=card3;
        //System.out.println(ansstr);
        //System.out.println(card1);
        //System.out.println(card2);
        //System.out.println(card3);
        //System.out.println(judgeLevel(s1));
        //System.out.println(judgeLevel(s2));
        //System.out.println(judgeLevel(s3));
        return ansstr;
    }
}
