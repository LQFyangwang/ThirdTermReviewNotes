package top.zywork.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import top.zywork.common.EncryptUtils;
import top.zywork.common.ExceptionUtils;
import top.zywork.dto.TemplateDTO;
import top.zywork.exception.AppException;
import top.zywork.exception.ServiceException;
import top.zywork.service.TemplateService;

import javax.annotation.Resource;

/**
 * Template测试控制器类<br />
 * 创建于2017-08-24
 *
 * @author 王振宇
 * @version 1.0
 *
 */
@Controller
@ParentPackage(value = "base-package")
@Namespace(value = "/template")
public class TemplateController extends BaseController {
    private static final long serialVersionUID = 1647679288455528889L;

    private Logger logger = LoggerFactory.getLogger(TemplateController.class);

    private TemplateService templateService;

    @Action(value = "ssh2", results = {@Result(name = "success", location = "/WEB-INF/views/index.jsp")})
    public String execute() {
        logger.info("template******");
        logger.info(getText("template.hello"));
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setName("test");
        templateDTO.setPassword(EncryptUtils.md5("123456"));
        try {
            templateService.save(templateDTO);
        } catch (ServiceException e) {
            logger.error(ExceptionUtils.stackTraceString(new StringBuilder(""), e));
            throw e;
        }
        return SUCCESS;
    }

    @Resource
    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }
}
