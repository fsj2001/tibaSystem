package priv.tiba.dao;

import org.apache.ibatis.annotations.Param;
import priv.tiba.pojo.Record;

import java.util.List;

public interface RecordDao {
    //新建一条记录
    public int createNewRecord(Record record);

    //按天获取记录
    public List<Record> getRecord(String userId);
}
