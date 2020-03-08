package priv.tiba.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MistakeQuestion extends Question{
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Timestamp questionDate) {
        this.questionDate = questionDate;
    }

    private Timestamp questionDate;
    private String userId;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;

    public void combineTitleAndItem(){
        StringBuilder newTitle = new StringBuilder();
        newTitle.append(this.getTitle());
        for(String item : this.getItemList()){
            newTitle.append("_");
            newTitle.append(item);
        }
        this.setTitle(newTitle.toString());
    }

    public void detachTitle(){
        String[] s = this.getTitle().split("_");
        if(this.getType().equals("choose")){
            this.setTitle(s[0]);
            List<String> itemList = new ArrayList<>();
            for(int i=1;i<s.length;i++){
                itemList.add(s[i]);
            }
            this.setItemList(itemList);
        }
    }
}
