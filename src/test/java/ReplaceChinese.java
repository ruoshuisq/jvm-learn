import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceChinese {

    /***

     * 把中文替换为指定字符

     * 注意:一次只匹配一个中文字符

     * @param source

     * @param replacement

     * @return

     */

    public static String replaceChinese(String source, String replacement){

        String reg = "[\u4e00-\u9fa5]";

        Pattern pat = Pattern.compile(reg);

        Matcher mat=pat.matcher(source);

        String repickStr = mat.replaceAll(replacement);

        return repickStr;

    }

    /**
     * 一行一行读取文件，解决读取中文字符时出现乱码
     *
     * 流的关闭顺序：先打开的后关，后打开的先关，
     *       否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    public static void readFile02() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\迅雷下载\\Contact.1997.1080p.BluRay.H264.AAC-RARBG.ChsEngA.ass");
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        //简写如下
        //BufferedReader br = new BufferedReader(new InputStreamReader(
        //        new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));
        String line="";
        while ((line=br.readLine())!=null) {
            line=replaceChinese(line,"");
            writeFile02("C:\\迅雷下载\\Contact.1997.1080p.BluRay.H264.AAC-RARBG.ChsEngA-en.ass",line);
        }
        br.close();
        isr.close();
        fis.close();
    }

    /**
     * 一行一行写入文件，解决写入中文字符时出现乱码
     *
     * 流的关闭顺序：先打开的后关，后打开的先关，
     *       否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    public static void writeFile02(String path,String context) throws IOException {
        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File(path),true);
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter  bw=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

        bw.write(context+"\t\n");

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        readFile02();
    }


}
