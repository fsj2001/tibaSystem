package priv.tiba.tool;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ParseKnowledgePoint {
    public static Map<String, String> numToString(){
        Map<String, String> map = new HashMap<>();
        String[] strings = getKnowledgePointItems();
        for(String string : strings){
            String[] ss = string.split(":");
            String key = ss[0].replaceAll("\"", "");
            String value = ss[1].replaceAll("\"", "");
            map.put(key, value);
        }
        return map;
    }

    public static Map<String, String> stringToNum(){
        Map<String, String> map = new HashMap<>();
        String[] strings = getKnowledgePointItems();
        for(String string : strings){
            String[] ss = string.split(":");
            String key = ss[1].replaceAll("\"", "");
            String value = ss[0].replaceAll("\"", "");
            map.put(key, value);
        }
        return map;
    }

    private static String[] getKnowledgePointItems(){
        File mapperFile = null;
        try {
            System.out.println(ResourceUtils.getURL("classpath:").getPath()+"priv/tiba/questionModel/knowledgePointTransfer.txt");
            mapperFile = new File(ResourceUtils.getURL("classpath:").getPath()+"/priv/tiba/questionModel/knowledgePointTransfer.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String mapper = ReadQuestionModel.readQuestionModel(mapperFile).get(0);
        mapper = mapper.replaceAll("\r\n", "");
        String[] strings = mapper.split(", ");
        return strings;
    }
}
