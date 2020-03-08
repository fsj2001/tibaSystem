package priv.tiba.pojo;

import java.sql.Timestamp;

public class Record {
    private int recordId;
    private int questionAmount;

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }

    private Timestamp recordDate;
    private int rightAmount;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(int questionAmount) {
        this.questionAmount = questionAmount;
    }

    public int getRightAmount() {
        return rightAmount;
    }

    public void setRightAmount(int rightAmount) {
        this.rightAmount = rightAmount;
    }

    public double getRightRate() {
        return rightRate;
    }

    public void setRightRate(double rightRate) {
        this.rightRate = rightRate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private double rightRate;
    private String userId;
}
