package priv.tiba.pojo;

public class Answer {
    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;
    private String questionId;
    private String userAnswer;
    private String realAnswer;

    public String toString(){
        return "type:"+type+"questionId:"+questionId+" "+"userAnswer:"+userAnswer+" "+"realAnswer:"+realAnswer;
    }
}
