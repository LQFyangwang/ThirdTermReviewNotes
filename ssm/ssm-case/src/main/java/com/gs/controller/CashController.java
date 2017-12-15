package com.gs.controller;

import com.gs.bean.Cash;
import com.gs.bean.User;
import com.gs.common.Constants;
import com.gs.common.Pager;
import com.gs.enums.ControllerStatusEnum;
import com.gs.query.CashQuery;
import com.gs.service.CashService;
import com.gs.vo.ControllerStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/cash")
public class CashController {

    @Autowired
    private CashService cashService;

    @RequestMapping("page")
    public String page() {
        return "cash/cash";
    }

    @PostMapping("save")
    @ResponseBody
    public ControllerStatusVO save(HttpSession session, Cash cash) {
        ControllerStatusVO statusVO = null;
        User user = (User) session.getAttribute(Constants.USER_IN_SESSION);
        cash.setUserId(user.getId());
        cash.setCreateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        try {
            cashService.save(cash);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_SAVE_SUCCESS);
        return statusVO;
    }

    @PostMapping("update")
    @ResponseBody
    public ControllerStatusVO update(Cash cash) {
        ControllerStatusVO statusVO = null;
        try {
            cashService.update(cash);
        } catch (RuntimeException e) {
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_FAIL);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CASH_UPDATE_SUCCESS);
        return statusVO;
    }

    @RequestMapping("pager_criteria")
    @ResponseBody
    public Pager pager(int page, int rows, CashQuery cashQuery) {
        return cashService.listPagerCriteria(page, rows, cashQuery);
    }

}
