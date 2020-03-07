package priv.tiba.dao;

import priv.tiba.pojo.Record;

public interface RecordDao {
    //新建一条记录
    public int createNewRecord(Record record);
}
