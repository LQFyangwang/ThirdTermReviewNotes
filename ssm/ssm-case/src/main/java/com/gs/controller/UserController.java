package com.gs.controller;

import com.gs.bean.LoginLog;
import com.gs.bean.User;
import com.gs.common.Constants;
import com.gs.common.EncryptUtils;
import com.gs.enums.ControllerStatusEnum;
import com.gs.service.LoginLogService;
import com.gs.service.UserService;
import com.gs.vo.ControllerStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("login")
    @ResponseBody
    public ControllerStatusVO login(HttpSession session, HttpServletRequest request, String phone, String pwd, String code) {
        ControllerStatusVO statusVO = null;
        Object checkObj = session.getAttribute(Constants.CODE_IN_SESSION);
        if (checkObj != null) {
            String checkCode = (String) checkObj;
            if (checkCode.equalsIgnoreCase(code)) {
                // 此处可根据login_log表里的is_online判断用户是否已经登录，如果is_online为1，说明登录过，则不需要再次登录
                User user = userService.getByPhonePwd(phone, EncryptUtils.md5(pwd));
                if (user != null) {
                    session.setAttribute(Constants.USER_IN_SESSION, user);
                    loginLogService.save(user.getId(), request.getRemoteHost());
                    statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_SUCCESS);
                } else {
                    statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_FAIL);
                }
            } else {
                statusVO = ControllerStatusVO.status(ControllerStatusEnum.USER_LOGIN_CODE_ERROR);
            }
        }
        return statusVO;
    }

    @RequestMapping("home")
    public String home() {
        return "home";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute(Constants.USER_IN_SESSION);
        loginLogService.updateByUserId(user.getId());
        session.invalidate();
        return "user/login";
    }

}
