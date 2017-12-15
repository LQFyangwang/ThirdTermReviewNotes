package com.gs.controller;

import com.gs.bean.Clazz;
import com.gs.bean.Stu;
import com.gs.common.Pager;
import com.gs.enums.ControllerStatusEnum;
import com.gs.service.StuService;
import com.gs.vo.ControllerStatusVO;
import com.gs.vo.StuVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@ParentPackage("base-package")
@Namespace("/stu")
public class StuController extends BaseController {

    @Autowired
    private StuService stuService;

    private Stu stu;

    private Integer page;
    private Integer rows;

    private Pager<Stu> pager;

    private List<StuVO> stuVOList;

    private ControllerStatusVO statusVO;

    @Action(value = "stu_page", results = {@Result(name = "stuPage", location = "/WEB-INF/views/stu/stu.jsp")})
    public String stuPage() {
        return "stuPage";
    }

    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        stuService.save(stu);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_SAVE_SUCCESS);
        return "save";
    }

    @Action(value = "remove", results = {@Result(name = "remove", type = "json", params = {"root", "statusVO"})})
    public String remove() {
        stuService.remove(stu);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_REMOVE_SUCCESS);
        return "remove";
    }

    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        stuService.update(stu);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_UPDATE_SUCCESS);
        return "update";
    }

    @Action(value = "pager_criteria", results = {@Result(name = "pager_criteria", type = "json", params = {"root", "pager"})})
    public String pagerCriteria() {
        pager = stuService.listPagerCriteria(page, rows, stu);
        return "pager_criteria";
    }

    @Action(value = "stuvo_list", results = {@Result(name = "stuvo_list", type = "json", params = {"root", "stuVOList"})})
    public String stuVO() {
        stuVOList = stuService.listAllWithClass();
        return "stuvo_list";
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public Pager<Stu> getPager() {
        return pager;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<StuVO> getStuVOList() {
        return stuVOList;
    }

    public ControllerStatusVO getStatusVO() {
        return statusVO;
    }
}
