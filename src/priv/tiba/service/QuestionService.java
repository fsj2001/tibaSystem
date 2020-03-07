package priv.tiba.service;

import priv.tiba.pojo.MistakeQuestion;
import priv.tiba.pojo.Question;

import java.util.List;

public interface QuestionService {

    //生成题目
    public List<Question> getQuestionList(String knowledgePoint, String numberOfQuestions, String difficulty, String type);

    //加入选择题入错题集
    public int setMistakeQuestion(String answer, String knowledgePoint, String title, String key, String type, List<String> itemList, String userId);

    //获取错题集
    public List<MistakeQuestion> getMistakeQuestions(String userId);

    //删除错题
    public int deleteMistakeQuestion(String questionId);
}
