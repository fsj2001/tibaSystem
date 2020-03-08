package priv.tiba.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.tiba.pojo.MistakeQuestion;
import priv.tiba.pojo.Question;
import priv.tiba.pojo.User;
import priv.tiba.service.QuestionService;
import priv.tiba.tool.ParseKnowledgePoint;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class QuestionController {

    @Autowired
    public QuestionService questionService;

    @RequestMapping(value = "/getQuestionList.action", method = RequestMethod.POST)
    public String getQuestionList(String knowledgePoint, String numberOfQuestions, String difficulty, String type, String totalTime, Model model, HttpSession session){
        List<Question> questionList = questionService.getQuestionList(knowledgePoint, numberOfQuestions, difficulty, type);
        session.setAttribute("questionList", questionList);
        JSONArray jsonArray = JSONArray.fromObject(questionList);
        model.addAttribute("questionList", jsonArray);
        model.addAttribute("time", totalTime);
        return "question";
    }

    @ResponseBody
    @RequestMapping(value = "/setMistakeQuestion.action", method = RequestMethod.POST)
    public String setMistakeQuestion(@RequestBody Map<String,Object> jsonData, HttpSession session){
        List<String> itemList = new ArrayList<>();
        for(Object o : (List<?>) jsonData.get("itemList")){
            itemList.add((String) o);
        }
        questionService.setMistakeQuestion(jsonData.get("answer").toString(), jsonData.get("knowledgePoint").toString(), jsonData.get("title").toString(), jsonData.get("key").toString(),
                jsonData.get("type").toString(), itemList, ((User)session.getAttribute("USER_SESSION")).getUserId());

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/getMistakeQuestions.action", method = RequestMethod.GET)
    public Map<String, Object> getMistakeQuestions(HttpSession session){
        List<MistakeQuestion> mistakeQuestions = questionService.getMistakeQuestions(((User)session.getAttribute("USER_SESSION")).getUserId());
        JSONArray jsonArray = JSONArray.fromObject(mistakeQuestions);
        Map<String, Object> map = new HashMap<>();
        map.put("mistakeQuestions", jsonArray);
        map.put("knowledgeMap", ParseKnowledgePoint.numToString());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMistakeQuestion.action", method = RequestMethod.GET)
    public String deleteMistakeQuestion(String questionId){
        questionService.deleteMistakeQuestion(questionId);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/getKnowledgePointMap.action", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgePointMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("knowledgeMap", ParseKnowledgePoint.numToString());
        return map;
    }
}
