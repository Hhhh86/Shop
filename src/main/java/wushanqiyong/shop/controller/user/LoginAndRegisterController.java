package wushanqiyong.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.user.UserService;
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
@RequestMapping("/user")
public class LoginAndRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        return "测试";
    }

    @PostMapping("/register")
    public JSONResultVO Register(@RequestBody String name,@RequestBody String sn,@RequestBody String password) throws Exception {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return JSONResultVO.errorMsg("用户名和密码不能为空...");
        }
        boolean usernameIsExist = userService.queryUsernameIsExist(name);
        if (usernameIsExist) {
            return JSONResultVO.errorMsg("该用户已被注册");
        }else{
            Student student = new Student();
            student.setId(null);
            student.setCreateTime(new Date());
            student.setUpdateTime(new Date());
            student.setAcademy("");
            student.setGrade("");
            student.setMobile("");
            student.setQq("");
            student.setSchool("");
            student.setSn(sn);
            student.setStatus(1);
            student.setPassword(password);
            userService.save(student);
            System.out.println("插入成功");
            return JSONResultVO.ok("注册成功");
        }
}
    @PostMapping("/login")
    public JSONResultVO Login(@RequestBody String sn,@RequestBody String password,HttpSession session){
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

    @GetMapping("/logout")
    public JSONResultVO Logout(HttpSession session) {
        userService.logout(session);
        return JSONResultVO.ok("注销成功");
    }

    }