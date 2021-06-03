package wushanqiyong.shop.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ProjectName shop-api
 * @ClassName UserController
 * @create 2021-05-29 16:17
 * @Author by hyp
 */
@RestController
@RequestMapping("/")
public class LoginAndRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test() {
        return "测试";
    }

    @PostMapping("register")
    public JSONResultVO Register(@RequestParam("name") String name,@RequestParam("sn") String sn,@RequestParam("password") String password) throws Exception {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return JSONResultVO.errorMsg("用户名和密码不能为空...");
        }
        boolean usernameIsExist = userService.queryUsernameIsExist(name);
        if (usernameIsExist) {
            return JSONResultVO.errorMsg("该用户已被注册");
        }else{
            Student result = userService.save(sn, password);
            if(result!=null){
                System.out.println("插入成功");
                return JSONResultVO.ok("注册成功");
            }
            return JSONResultVO.ok("注册失败，请重新尝试");
        }
}
    @PostMapping("login")
    public JSONResultVO Login(@RequestParam("sn") String sn,@RequestParam("password") String password,HttpSession session){
        if (StringUtils.isEmpty(sn) || StringUtils.isEmpty(password)) {
            return JSONResultVO.errorMsg("学号或密码不能为空...");
        }
        Student student = userService.queryUserForLogin(sn, password);
        if(student != null){
            student.setPassword(null);
            session.setAttribute("user", student);
            return JSONResultVO.ok("登录成功");
        }else{
            return JSONResultVO.errorMsg("学号或密码错误");
        }
    }

    @GetMapping("logout")
    public JSONResultVO Logout(HttpSession session) {
        userService.logout(session);
        return JSONResultVO.ok("注销成功");
    }

    }