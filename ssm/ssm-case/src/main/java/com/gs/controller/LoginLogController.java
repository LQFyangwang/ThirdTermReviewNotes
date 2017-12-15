package com.gs.controller;

import com.gs.common.Pager;
import com.gs.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login_log")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping("page")
    public String page() {
        return "log/login_log";
    }

    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int page, int rows) {
        return loginLogService.listPager(page, rows);
    }

}
