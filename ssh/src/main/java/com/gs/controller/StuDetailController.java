package com.gs.controller;

import com.gs.bean.Stu;
import com.gs.bean.StuDetail;
import com.gs.enums.ControllerStatusEnum;
import com.gs.service.StuDetailService;
import com.gs.vo.ControllerStatusVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ParentPackage("base-package")
@Namespace("/stuDetail")
public class StuDetailController extends BaseController {

    @Autowired
    private StuDetailService stuDetailService;

    private Long stuDetailId;

    private StuDetail stuDetail;

    private ControllerStatusVO statusVO;

    @Action(value = "get", results = {@Result(name = "get", type = "json", params = {"root", "stuDetail"})})
    public String byId() {
        stuDetail = stuDetailService.getById(stuDetailId);
        return "get";
    }

    @Action(value = "save", results = {@Result(name = "save", type = "json", params = {"root", "statusVO"})})
    public String save() {
        stuDetailService.save(stuDetail);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_SAVE_SUCCESS);
        return "save";
    }

    @Action(value = "remove", results = {@Result(name = "remove", type = "json", params = {"root", "statusVO"})})
    public String remove() {
        stuDetailService.remove(stuDetail);
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_REMOVE_SUCCESS);
        return "remove";
    }

    @Action(value = "update", results = {@Result(name = "update", type = "json", params = {"root", "statusVO"})})
    public String update() {
        if (stuDetail.getId() == null) {
            stuDetailService.save(stuDetail);
        } else {
            stuDetailService.update(stuDetail);
        }
        statusVO = ControllerStatusVO.status(ControllerStatusEnum.CLASS_UPDATE_SUCCESS);
        return "update";
    }

    public StuDetail getStuDetail() {
        return stuDetail;
    }

    public void setStuDetail(StuDetail stuDetail) {
        this.stuDetail = stuDetail;
    }

    public void setStuDetailId(Long stuDetailId) {
        this.stuDetailId = stuDetailId;
    }

    public ControllerStatusVO getStatusVO() {
        return statusVO;
    }
}
