package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import priv.tiba.dao.MistakeQuestionDao;
import priv.tiba.pojo.MistakeQuestion;
import priv.tiba.pojo.Question;
import priv.tiba.service.QuestionService;
import priv.tiba.tool.EquationBuilder;
import priv.tiba.tool.QuestionBuilder;
import priv.tiba.tool.RandomBuilder;
import priv.tiba.tool.ReadQuestionModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private MistakeQuestionDao mistakeQuestionDao;

    @Override
    public List<Question> getQuestionList(String knowledgePoint, String numberOfQuestions, String difficulty, String type) {
        Map<String, String> map = new HashMap<>();
        File mapperFile = null;
        try {
            System.out.println(ResourceUtils.getURL("classpath:").getPath()+"priv/tiba/questionModel/knowledgePointTransfer.txt");
            mapperFile = new File(ResourceUtils.getURL("classpath:").getPath()+"/priv/tiba/questionModel/knowledgePointTransfer.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String mapper = ReadQuestionModel.readQuestionModel(mapperFile).get(0);
        mapper = mapper.replaceAll("\r\n", "");
        String[] strings = mapper.split(", ");
        for(String string : strings){
            String[] ss = string.split(":");
            String key = ss[1].replaceAll("\"", "");
            String value = ss[0].replaceAll("\"", "");
            map.put(key, value);
        }
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
        mistakeQuestion.setQuestionDate(new Date());
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

    public static void main(String[] args){
//        List<MistakeQuestion> list = this.getMistakeQuestions("848564778@qq.com");
//        for(MistakeQuestion mistakeQuestion : list){
//            System.out.println(mistakeQuestion.getTitle());
//        }
    }
}
