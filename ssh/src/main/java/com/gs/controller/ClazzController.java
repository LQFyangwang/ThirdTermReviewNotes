package com.gs.controller;

import com.gs.bean.Clazz;
import com.gs.common.Combobox;
import com.gs.common.Pager;
import com.gs.enums.ControllerStatusEnum;
import com.gs.service.ClazzService;
import com.gs.vo.ControllerStatusVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@ParentPackage(value = "base-package")
@Namespace(value = "/class")
public class ClazzController extends BaseController {

    @Autowired
    private ClazzService clazzService;

    private Clazz clazz;
    private Integer rows;
    private Integer page;

    private Pager<Clazz> pager;
    private ControllerStatusVO statusVO;

    private Long clazzId;

    private List<Combobox> comboboxList;

    @Action(value = "class_page", results = {@Result(name = "success", location = "/WEB-INF/views/clazz/clazz.jsp")})
    public String classPage() {
        return SUCCESS;
    }

    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        clazzService.save(clazz);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_SAVE_SUCCESS);
        return "save";
    }

    @Action(value = "remove", results = {@Result(name = "remove", type = "json", params = {"root", "statusVO"})})
    public String remove() {
        clazzService.removeById(clazz.getId());
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_REMOVE_SUCCESS);
        return "remove";
    }

    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        clazzService.update(clazz);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_UPDATE_SUCCESS);
        return "update";
    }

    @Action(value = "getById", results = {@Result(name = "getById", type = "json", params = {"root", "clazz"})})
    public String getById() {
        clazz = clazzService.getById(clazz.getId());
        return "getById";
    }

    @Action(value = "pager", results = {@Result(name = "pager", type = "json", params = {"root", "pager"})})
    public String pager() {
        pager = clazzService.listPager(page, rows);
        return "pager";
    }

    @Action(value = "pager_criteria", results = {@Result(name = "pager_criteria", type = "json", params = {"root", "pager"})})
    public String pagerCriteria() {
        pager = clazzService.listPagerCriteria(page, rows, clazz);
        return "pager_criteria";
    }

    @Action(value = "all", results = {@Result(name = "all", type = "json", params = {"root", "comboboxList"})})
    public String all() {
        List<Clazz> clazzList = clazzService.listAll();
        comboboxList = new ArrayList<>();
        for (Clazz clazz : clazzList) {
            boolean selected = false;
            if (clazzId != null && clazz.getId().longValue() == clazzId.longValue()) {
                selected = true;
            }
            comboboxList.add(new Combobox(clazz.getId() + "", clazz.getTitle(), selected));
        }
        return "all";
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Pager<Clazz> getPager() {
        return pager;
    }

    public ControllerStatusVO getStatusVO() {
        return statusVO;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public List<Combobox> getComboboxList() {
        return comboboxList;
    }
}
