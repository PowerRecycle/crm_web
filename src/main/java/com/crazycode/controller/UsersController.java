package com.crazycode.controller;

import com.crazycode.pojo.Users;
import com.crazycode.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 控制层UsersController
 *
 * @author Administrator
 */
@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/usersList/{pageNum}/{pageSize}")
    public ModelAndView usersList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, HttpSession session) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> allUsers = usersService.findAllUsers();
        PageInfo<Users> pageInfo = new PageInfo<>(allUsers);
        ModelAndView modelAndView = new ModelAndView("pages/user-list");
        session.setAttribute("users", allUsers);
        session.setAttribute("pageInfo", pageInfo);
        return modelAndView;
    }

    @PostMapping("/login.do")
    public ModelAndView login(Users user, HttpSession session) throws Exception {
        Users userByName = usersService.findUserByName(user);
        ModelAndView modelAndView = new ModelAndView();
        if (userByName != null) {
            PageHelper.startPage(1, 4);
            List<Users> allUsers = usersService.findAllUsers();
            modelAndView.setViewName("pages/main");
            session.setAttribute("user", userByName);
            session.setAttribute("users", allUsers);
            PageInfo<Users> pageInfo = new PageInfo<>(allUsers);
            session.setAttribute("pageInfo", pageInfo);
            /*modelAndView.addObject("user", userByName);
            modelAndView.addObject("users", allUsers);*/
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
