package priv.tiba.service;


import java.util.Map;

public interface RecordService {

    //新建记录
    public int createNewRecord(int questionAmount, int rightAmount, String userId);

    //获取记录
    public Map<String, Object> getRecordByTime(String userId, String type1, String type2);
}
