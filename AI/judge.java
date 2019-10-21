import java.awt.image.ImagingOpException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class judge {
    public static Map<Character,Integer>map=new HashMap<>();
    private static boolean iszzql(String str[]) {
        char z=str[0].charAt(0);
        for(int i=0;i<=12;i++)
        {
            //System.out.println(str[i].charAt(0)+" "+map.get(str[i].charAt
            // (1)));
            if(str[i].charAt(0)!=z||map.get(str[i].charAt(1))!=i)
            {
                return false;
            }
        }
        return true;
    }
    private static boolean isytl(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]>0)sum++;
        }
        if(sum==13)return true;
        return false;
    }
    private static boolean issehz(String[] str) {
        int sum=0;
        for(int i=0;i<=12;i++)
        {
            if(str[i].charAt(1)=='J'||str[i].charAt(1)=='Q'||str[i].charAt(1)=='K'||str[i].charAt(1)=='A')
            {
                sum++;
            }
        }
        if(sum==12)
            return true;
        else
            return false;
    }
    private static boolean issths(String[] str) {
        boolean ba=false,bb=false,bc=false,bd=false;
        int ta=0,tb=0,tc=0,td=0;
        int sumColor=0;
        for(int i=0;i<=12;i++)
        {
            if(str[i].charAt(0)=='$')
            {
                ba=true;
                ta++;
                continue;
            }
            if(str[i].charAt(0)=='&')
            {
                bb=true;
                tb++;
                continue;
            }
            if(str[i].charAt(0)=='*')
            {
                bc=true;
                tc++;
                continue;
            }
            if(str[i].charAt(0)=='#')
            {
                bd=true;
                td++;
                continue;
            }
        }
        if(ba==true)
            sumColor++;
        if(bb==true)
            sumColor++;
        if(bc==true)
            sumColor++;
        if(bd==true)
            sumColor++;

        if(sumColor>3)return false;
        if(ta!=0&&ta!=3&&ta!=5&&ta!=10||tb!=0&&tb!=3&&tb!=5&&tb!=10||tc!=0&&tc!=3&&tc!=5&&tc!=10||td!=0&&td!=3&&td!=5&&td!=10)
        {
            return false;
        }
        for(int i=1;i<=12;i++)
        {
            if(str[i].charAt(0)==str[i-1].charAt(0))
            {
                if(map.get(str[i].charAt(1))-map.get(str[i-1].charAt(1))!=1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean issftx(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]==4)
            {
                sum++;
            }
        }
        if(sum==3)return true;
        else return false;
    }
    private static boolean isqd(String[] str) {
        for(int i=0;i<=12;i++)
        {
            if(map.get(str[i].charAt(1))<6)
                return false;
        }
        return true;
    }
    private static boolean isqx(String[] str) {
        for(int i=0;i<=12;i++)
        {
            if(map.get(str[i].charAt(1))>6)
                return false;
        }
        return true;
    }
    private static boolean iscys(String[] str) {
        char z=str[0].charAt(0);
        if(z=='$'||z=='*')
        {
            for(int i=0;i<=12;i++)
            {
                if(str[i].charAt(0)!='$'&&str[i].charAt(0)!='*')
                {
                    return false;
                }
            }
        }
        if(z=='&'||z=='#')
        {
            for(int i=0;i<=12;i++)
            {
                if(str[i].charAt(0)!='&'&&str[i].charAt(0)!='#')
                {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean issgcs(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum1=0,sum2=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]==2)sum1++;
            if(a[i]==3)sum2++;
        }
        if(sum1==3&&sum2==2)return true;
        else return false;
    }
    private static boolean isstst(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]==3)sum++;
        }
        if(sum==4)return true;
        else return false;
    }
    private static boolean iswdst(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum1=0,sum2=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]==2)sum1++;
            if(a[i]==3)sum2++;
        }
        if(sum1==5&&sum2==1)return true;
        else return false;
    }
    private static boolean isldb(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        int sum=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]==2)sum++;
        }
        if(sum==6)return true;
        else return false;
    }
    private static boolean solve(int[] a,int[] b,int[] c) {
        int start=0;
        for(int i=0;i<=12;i++)
        {
            if(a[i]>0)
            {
                start=i;
                break;
            }
        }
        boolean flag=false;
        for(int i=start;i<=start+2;i++)
        {
            if(i>12)
            {
                flag=true;
                break;
            }
            if(a[i]<1)
            {
                flag=true;
                break;
            }
            a[i]--;
        }
        if(flag==false)
        {
            for(int i=start;i<=12;i++)
            {
                if(a[i]>0)
                {
                    for(int j=i;j<=i+4;j++)
                    {
                        if(j>12)
                        {
                            flag=true;
                            break;
                        }
                        if(a[j]<1)
                        {
                            flag=true;
                            break;
                        }
                        a[j]--;
                    }
                    if(flag==false)
                    {
                        for(int j=0;j<=12;j++)
                        {
                            if(a[j]>0)
                            {
                                for(int k=j;k<=j+4;k++)
                                {
                                    if(k>12)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    if(a[k]<1)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    a[k]--;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        //System.out.println(1);
        //System.out.println(flag);
        if(flag==false)return true;
        flag=false;
        for(int i=start;i<=start+4;i++)
        {
            if(i>12)
            {
                flag=true;
                break;
            }
            if(b[i]<1)
            {
                flag=true;
                break;
            }
            b[i]--;
        }
        if(flag==false)
        {
            for(int i=start;i<=12;i++)
            {
                if(b[i]>1)
                {
                    for(int j=i;i<=i+2;j++)
                    {
                        if(j>12)
                        {
                            flag=true;
                            break;
                        }
                        if(b[j]<1)
                        {
                            flag=true;
                            break;
                        }
                        b[j]--;
                    }
                    if(flag==false)
                    {
                        for(int j=0;j<=12;j++)
                        {
                            if(b[j]>1)
                            {
                                for(int k=j;k<=j+4;k++)
                                {
                                    if(k>12)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    if(b[k]<1)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    b[k]--;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }

        }
        if(flag==false)return true;

        flag=false;
        for(int i=start;i<=start+4;i++)
        {
            if(i>12)
            {
                flag=true;
                break;
            }
            if(c[i]<1)
            {
                flag=true;
                break;
            }
            a[i]--;
        }
        if(flag==false)
        {
            for(int i=start;i<=12;i++)
            {
                if(c[i]>1)
                {
                    for(int j=i;i<=i+4;j++)
                    {
                        if(j>12)
                        {
                            flag=true;
                            break;
                        }
                        if(c[j]<1)
                        {
                            flag=true;
                            break;
                        }
                        c[j]--;
                    }
                    if(flag==false)
                    {
                        for(int j=0;j<=12;j++)
                        {
                            if(c[j]>1)
                            {
                                for(int k=j;k<=j+2;k++)
                                {
                                    if(k>12)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    if(c[k]<1)
                                    {
                                        flag=true;
                                        break;
                                    }
                                    c[k]--;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        if(flag==false)return true;
        return false;
    }
    private static boolean isssz(String[] str) {
        int[] a=new int[13];
        for(int i=0;i<=12;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<=12;i++)
        {
            a[map.get(str[i].charAt(1))]++;
        }
        if(solve(a,a,a))return true;
        else return false;
    }
    private static boolean issth(String[] str) {
        int sum1=0,sum2=0,sum3=0,sum4=0;
        for(int i=0;i<=12;i++)
        {
            if(str[i].charAt(0)=='$')sum1++;
            if(str[i].charAt(0)=='&')sum2++;
            if(str[i].charAt(0)=='*')sum3++;
            if(str[i].charAt(0)=='#')sum4++;
        }
        if(sum1!=0&&sum1!=3&&sum1!=5||sum2!=0&&sum2!=3&&sum2!=5||sum3!=0&&sum3!=3&&sum3!=5||sum4!=0&&sum4!=3&&sum4!=5)
        {
            return false;
        }
        return true;
    }
    public static boolean isSpecial(String[] str,BufferedWriter bufferedWriter
            ,Map m) throws IOException {
        //String outputPath="D:\\IDEA2019\\IdeaProject\\13water\\src\\output" +
        //    ".txt";
        //File file1=new File(outputPath);
        //BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
        map=m;
        for(String ch:str) {
                bufferedWriter.write(ch);
                bufferedWriter.write(" ");
        }
        bufferedWriter.write("\n");
        if(iszzql(str))
            return true;
        if(isytl(str))
            return true;
        if(issehz(str))
            return true;
        if(issths(str))
            return true;
        if(issftx(str))
            return true;
        if(isqd(str))
            return true;
        if(isqx(str))
            return true;
        if(iscys(str))
            return true;
        if(issgcs(str))
            return true;
        if(isstst(str))
            return true;
        if(iswdst(str))
            return true;
        if(isldb(str))
            return true;
        if(isssz(str))
            return true;
        if(issth(str))
            return true;
        else return false;
    }
}
