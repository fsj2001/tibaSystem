package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.tiba.dao.RecordDao;
import priv.tiba.pojo.Record;
import priv.tiba.service.RecordService;

import java.sql.Timestamp;
import java.util.*;

@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public int createNewRecord(int questionAmount, int rightAmount, String userId) {
        Record record = new Record();
        record.setQuestionAmount(questionAmount);
        record.setRightAmount(rightAmount);
        record.setRightRate(rightAmount*1.0/questionAmount);
        record.setRecordDate(new Timestamp((new Date()).getTime()));
        record.setUserId(userId);
        return recordDao.createNewRecord(record);
    }

    @Override
    public Map<String, Object> getRecordByTime(String userId, String type1, String type2) {
        Map<String, Object> map = new HashMap<>();
        List<String> xList = new ArrayList<>();
        List<String> yList = new ArrayList<>();
        return map;
    }


}
