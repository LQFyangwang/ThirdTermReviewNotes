package com.gs.controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Controller
@ParentPackage("base-package")
@Namespace("/")
public class IndexController extends BaseController {

    @Action(value = "index", results = {@Result(name = "success", location = "/WEB-INF/views/index.jsp")})
    public String index() {
        return SUCCESS;
    }
}
