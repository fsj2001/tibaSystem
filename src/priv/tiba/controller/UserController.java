package priv.tiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import priv.tiba.pojo.User;
import priv.tiba.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String email, String password, Model model, HttpSession session){
        User user = userService.findUser(email, password);
        if(user != null){
            session.setAttribute("USER_SESSION", user);
            return "frame";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "login";
    }

    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login.action";
    }

    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/modifyPassword.action", method = RequestMethod.POST)
    public String modifyPassword(String oldpassword, String password, String password2, Model model, HttpSession session){
        if(!password.equals(password2)){
            model.addAttribute("msg", "两次密码不一致！");
            return "modify_password";
        }
        User user = userService.findUser(((User)session.getAttribute("USER_SESSION")).getUserId(), oldpassword);
        if(user != null){
            int status = userService.updatePwd(user.getUserId(), password);
            if(status == 1){
                model.addAttribute("msg", "修改成功！");
                System.out.println("修改成功！");
            }
            else{
                model.addAttribute("msg", "修改失败！");
                System.out.println("修改失败！");
            }
            return "modify_password";
        }
        model.addAttribute("msg", "原密码错误！");
        return "modify_password";
    }
}
