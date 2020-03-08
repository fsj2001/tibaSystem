package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.tiba.dao.MistakeQuestionDao;
import priv.tiba.pojo.MistakeQuestion;
import priv.tiba.pojo.Question;
import priv.tiba.service.QuestionService;
import priv.tiba.tool.*;

import java.sql.Timestamp;
import java.util.*;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private MistakeQuestionDao mistakeQuestionDao;

    @Override
    public List<Question> getQuestionList(String knowledgePoint, String numberOfQuestions, String difficulty, String type) {
        Map<String, String> map = ParseKnowledgePoint.stringToNum();
        knowledgePoint = map.get(knowledgePoint);
        List<Question> questions = new ArrayList<>();
        if(type.equals("fill")||type.equals("choose")){
            if(!knowledgePoint.equals("2")){
                questions = QuestionBuilder.getQuestion(type, knowledgePoint, difficulty, numberOfQuestions);
            }else{
                questions = EquationBuilder.getEquationList(type, numberOfQuestions);
            }
        }else {
            int num = Integer.parseInt(numberOfQuestions);
            List<Integer> list = RandomBuilder.getRandoms(num, 2);
            if(!knowledgePoint.equals("2")){
                List<Question> questionList1 = QuestionBuilder.getQuestion("fill", knowledgePoint, difficulty, String.valueOf(list.get(0)));
                List<Question> questionList2 = QuestionBuilder.getQuestion("choose", knowledgePoint, difficulty, String.valueOf(list.get(1)));
                questions.addAll(questionList2);
                questions.addAll(questionList1);
            }else{
                List<Question> questionList1 = EquationBuilder.getEquationList("fill", String.valueOf(list.get(0)));
                List<Question> questionList2 = EquationBuilder.getEquationList("choose", String.valueOf(list.get(1)));
                questions.addAll(questionList2);
                questions.addAll(questionList1);
            }
        }

        return questions;
    }

    @Override
    public int setMistakeQuestion(String answer, String knowledgePoint, String title, String key, String type, List<String> itemList, String userId) {
        MistakeQuestion mistakeQuestion = new MistakeQuestion();
        mistakeQuestion.setQuestionId(UUID.randomUUID().toString().replaceAll("-", ""));
        mistakeQuestion.setQuestionDate(new Timestamp((new Date()).getTime()));
        mistakeQuestion.setUserId(userId);
        mistakeQuestion.setTitle(title);
        mistakeQuestion.setQuestionKey(key);
        mistakeQuestion.setType(type);
        mistakeQuestion.setAnswer(answer);
        mistakeQuestion.setItemList(itemList);
        mistakeQuestion.setKnowledgePoint(knowledgePoint);
        mistakeQuestion.combineTitleAndItem();
        mistakeQuestionDao.setMistakeQuestion(mistakeQuestion);

        return 1;
    }

    @Override
    public List<MistakeQuestion> getMistakeQuestions(String userId) {
        List<MistakeQuestion> list = mistakeQuestionDao.getMistakeQuestions(userId);
        for(MistakeQuestion mistakeQuestion : list){
            mistakeQuestion.detachTitle();
        }
        return list;
    }

    @Override
    public int deleteMistakeQuestion(String questionId) {
        return mistakeQuestionDao.deleteMistakeQuestion(questionId);
    }
}
