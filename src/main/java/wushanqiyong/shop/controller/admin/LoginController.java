package wushanqiyong.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.admin.AdminService;
import wushanqiyong.shop.vo.JSONResultVO;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName shop-api
 * @ClassName UserController
 * @create 2021-05-29 16:17
 * @Author by hyp
 */
@RestController
@RequestMapping("/adminlogin")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test")
    public String test() {
        return "测试";
    }

    @PostMapping("/login")
    public JSONResultVO Login(@RequestBody String username,@RequestBody String password,HttpSession session){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResultVO.errorMsg("用户名或密码不能为空...");
        }
        User user = adminService.queryUserForLogin(username, password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user", user);
            return JSONResultVO.ok("登录成功");
        }else{
            return JSONResultVO.errorMsg("用户名或密码错误");
        }
    }

    @GetMapping("/logout")
    public JSONResultVO Logout(HttpSession session) {
        adminService.logout(session);
        return JSONResultVO.ok("注销成功");
    }
}