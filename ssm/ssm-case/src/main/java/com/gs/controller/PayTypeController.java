package com.gs.controller;

import com.gs.bean.PayType;
import com.gs.common.Combobox;
import com.gs.service.CashTypeService;
import com.gs.service.PayTypeService;
import com.gs.vo.CashTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pay_type")
public class PayTypeController {

    @Autowired
    private PayTypeService payTypeService;

    @RequestMapping("list")
    @ResponseBody
    public List<Combobox> listAll() {
        List<Object> objectList = payTypeService.listAll();
        List<Combobox> comboboxList = new ArrayList<>();
        for (Object obj : objectList) {
            PayType payType = (PayType) obj;
            comboboxList.add(new Combobox(payType.getId() + "", payType.getType(), false));
        }
        return comboboxList;
    }

}
