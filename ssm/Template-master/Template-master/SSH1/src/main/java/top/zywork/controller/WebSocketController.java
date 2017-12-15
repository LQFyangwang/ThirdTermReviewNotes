package top.zywork.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * WebSocket测试用控制器<br />
 * 创建于2017-09-21
 *
 * @author 王振宇
 * @version 1.0
 */
public class WebSocketController extends BaseController {
    private static final long serialVersionUID = 4314529153953195464L;

    /**
     * 显示socket测试页
     * @return socket测试页
     */
    public String socket_page() {
        return "socketPage";
    }
}
