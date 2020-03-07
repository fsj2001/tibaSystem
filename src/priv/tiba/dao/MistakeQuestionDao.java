package priv.tiba.dao;

import priv.tiba.pojo.MistakeQuestion;

import java.util.List;

public interface MistakeQuestionDao {

    //加入错题集
    public int setMistakeQuestion(MistakeQuestion mistakeQuestion);

    //列出所有错题
    public List<MistakeQuestion> getMistakeQuestions(String userId);

    //删除错题
    public int deleteMistakeQuestion(String questionId);
}
