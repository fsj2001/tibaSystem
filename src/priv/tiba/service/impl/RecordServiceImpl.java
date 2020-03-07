package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.tiba.dao.RecordDao;
import priv.tiba.pojo.Record;
import priv.tiba.service.RecordService;

import java.util.Date;

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
        record.setRecordDate(new Date());
        record.setUserId(userId);
        return recordDao.createNewRecord(record);
    }
}
