package priv.tiba.dao;

import org.apache.ibatis.annotations.Param;
import priv.tiba.pojo.Record;

public interface RecordDao {
    //新建一条记录
    public int createNewRecord(Record record);

    //按次获取记录
    public Record getRecordByTime(@Param("userId") String userId, @Param("recordNum") int recordNum);

    //按天获取记录
    public Record getRecordByDay(String userId);
}
