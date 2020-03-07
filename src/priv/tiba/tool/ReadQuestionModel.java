package priv.tiba.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadQuestionModel {

    public static List<String> readQuestionModel(File file){
        List<String> stringList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));//构造一个BufferedReader类来读取文件
            String s;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                stringList.add(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return stringList;
    }

    public static void main(String[] args){
        File file = new File("src/priv/tiba/questionModel/name.txt");
        System.out.println(readQuestionModel(file));
    }
}
