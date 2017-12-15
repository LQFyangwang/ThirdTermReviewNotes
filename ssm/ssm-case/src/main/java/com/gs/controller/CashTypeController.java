package com.gs.controller;

import com.gs.common.Combobox;
import com.gs.service.CashTypeService;
import com.gs.vo.CashTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cash_type")
public class CashTypeController {

    @Autowired
    private CashTypeService cashTypeService;

    @RequestMapping("list/{pid}")
    @ResponseBody
    public List<Combobox> listByPid(@PathVariable("pid") Long pid) {
        List<CashTypeVO> cashTypeVOList = cashTypeService.listByPid(pid);
        List<Combobox> comboboxList = new ArrayList<>();
        for (CashTypeVO cashTypeVO : cashTypeVOList) {
            comboboxList.add(new Combobox(cashTypeVO.getId() + "", cashTypeVO.getType(), false));
        }
        return comboboxList;
    }

}
