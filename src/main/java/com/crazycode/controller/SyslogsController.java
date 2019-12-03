package com.crazycode.controller;

import com.crazycode.pojo.Syslog;
import com.crazycode.service.SyslogService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class SyslogsController {
    @Autowired
    private SyslogService syslogService;

    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @RequiresRoles("admin")
    @GetMapping("/findAllSyslogs")
    public ModelAndView findAllSyslogs() throws Exception {
        ModelAndView modelAndView = new ModelAndView("pages/syslog-list");
        List<Syslog> sysLogs = syslogService.findAllSyslogs();
        modelAndView.addObject("sysLogs", sysLogs);
        return modelAndView;
    }
}
