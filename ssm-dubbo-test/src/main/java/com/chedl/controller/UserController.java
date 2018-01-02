package com.chedl.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chedl.entity.user.User;
import com.chedl.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/showUser")  
    public String showUser(HttpServletRequest request,Model model){  
        String id = request.getParameter("id");
        User user = new User();
        if(null != id && !"".equals(id)){
        	user = userService.getUserById(Integer.parseInt(id));  
        }
        model.addAttribute("user", user);  
        return "user/user_detail";  
    }  
}