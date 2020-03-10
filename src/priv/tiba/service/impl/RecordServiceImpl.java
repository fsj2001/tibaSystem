package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.tiba.dao.RecordDao;
import priv.tiba.pojo.Record;
import priv.tiba.service.RecordService;
import priv.tiba.tool.DateTool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public Map<String, Object> getRecord(String userId) {
        Map<String, Object> map = new HashMap<>();
        List<Record> recordList = recordDao.getRecord(userId);
        String[] type1List = new String[]{"totalAmount", "rightAmount", "rightRate"};
        String[] type2List = new String[]{"time", "day"};
        int[] questionAmount = new int[7];
        int[] rightAmount = new int[7];
        double[] rightRate = new double[7];
        for(String type1:type1List){
            for(String type2:type2List){
                List<String> xList = new ArrayList<>();
                List<String> yList = new ArrayList<>();
                if(type2.equals("time")){
                    List<Record> records;
                    if(recordList.size()>=7){
                        records = recordList.subList(0, 7);
                    }else{
                        records = recordList;
                    }
                    Collections.reverse(records);
                    String strDateFormat = "yyyy-MM-dd HH:mm";
                    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                    for(Record record:records){
                        xList.add(sdf.format(record.getRecordDate()));
                    }
                    if(type1.equals("totalAmount")){
                        for(Record record:records){
                            yList.add(String.valueOf(record.getQuestionAmount()));
                        }
                    }else if(type1.equals("rightAmount")){
                        for(Record record:records){
                            yList.add(String.valueOf(record.getRightAmount()));
                        }
                    }else{
                        for(Record record:records){
                            yList.add(String.valueOf(record.getRightRate()));
                        }
                    }
                }
                else{
                    String strDateFormat = "yyyy-MM-dd";
                    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                    Calendar today = Calendar.getInstance();
                    Date now = new Date();
                    today.setTime(now);
                    for(int i=6;i>=0;i--){
                        Date date = DateTool.getDateBefore(now, i);
                        xList.add(sdf.format(date));
                    }
                    if(type1.equals("totalAmount")){
                        for(Record record:recordList){
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(record.getRecordDate());
                            int dayDiff = DateTool.getsdays(calendar, today);
                            if(dayDiff<=6){
                                questionAmount[dayDiff] += record.getQuestionAmount();
                            }
                        }
                        for(int j=6;j>=0;j--){
                            yList.add(String.valueOf(questionAmount[j]));
                        }
                    }else if(type1.equals("rightAmount")){
                        for(Record record:recordList){
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(record.getRecordDate());
                            int dayDiff = DateTool.getsdays(calendar, today);
                            if(dayDiff<=6){
                                rightAmount[dayDiff] += record.getRightAmount();
                            }
                        }
                        for(int j=6;j>=0;j--){
                            yList.add(String.valueOf(rightAmount[j]));
                        }
                    }else{
                        for(int j=6;j>=0;j--){
                            if(questionAmount[j]==0){
                                rightRate[j] = 0;
                            }else{
                                rightRate[j] = rightAmount[j]*1.0/questionAmount[j];
                            }
                            yList.add(String.valueOf(rightRate[j]));
                        }
                    }
                }
                map.put("x_"+type1+"_"+type2, xList);
                map.put("y_"+type1+"_"+type2, yList);
            }
        }

        return map;
    }
}
