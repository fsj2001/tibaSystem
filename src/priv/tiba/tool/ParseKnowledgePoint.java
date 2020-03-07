package priv.tiba.tool;

import java.util.HashMap;
import java.util.Map;

public class ParseKnowledgePoint {
    public static Map<String, String> getKnowledgePoint(){
        Map<String, String> map = new HashMap<>();
        map.put("11", "小数乘整数");
        map.put("12", "小数乘小数");
        map.put("13", "除数是正数的小数除法");
        map.put("14", "一个数除以小数");
        map.put("2", "解简易方程");
        map.put("4", "解简易方程");
        return map;
    }
}
