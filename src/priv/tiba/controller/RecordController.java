package priv.tiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.tiba.pojo.User;
import priv.tiba.service.RecordService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    @ResponseBody
    @RequestMapping(value = "/createNewRecord.action", method = RequestMethod.POST)
    public String createNewRecord(@RequestBody Map<String,Object> jsonData, HttpSession session){
        recordService.createNewRecord(Integer.parseInt(jsonData.get("questionAmount").toString()), Integer.parseInt(jsonData.get("rightAmount").toString()), ((User)session.getAttribute("USER_SESSION")).getUserId());
        return "ok!";
    }

    @ResponseBody
    @RequestMapping(value = "/getRecord.action", method = RequestMethod.GET)
    public Map<String, Object> getRecord(HttpSession session){
        Map<String, Object> map = recordService.getRecord(((User)session.getAttribute("USER_SESSION")).getUserId());
        return map;
    }
}
