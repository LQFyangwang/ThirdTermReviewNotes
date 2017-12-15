package top.zywork.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.zywork.common.EncryptUtils;
import top.zywork.common.ExceptionUtils;
import top.zywork.dto.TemplateDTO;
import top.zywork.exception.ServiceException;
import top.zywork.service.TemplateService;

/**
 * Template测试控制器类<br />
 * 创建于2017-08-24
 *
 * @author 王振宇
 * @version 1.0
 *
 */
public class TemplateController extends BaseController {
    private static final long serialVersionUID = 1647679288455528889L;

    private Logger logger = LoggerFactory.getLogger(TemplateController.class);

    private TemplateService templateService;

    public String execute() {
        logger.info("template******");
        logger.info(getText("template.hello"));
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setName("test");
        templateDTO.setPassword(EncryptUtils.md5("123456"));
        try {
            templateService.save(templateDTO);
        } catch (ServiceException e) {
            logger.error(ExceptionUtils.stackTraceString(e));
            throw e;
        }
        return SUCCESS;
    }

    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }
}
