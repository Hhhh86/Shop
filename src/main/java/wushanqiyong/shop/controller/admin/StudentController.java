package wushanqiyong.shop.controller.admin;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.student.UserService;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName UserController
 * @create 2021-05-30 14:46
 * @Author by hyp
 */
@RestController
@RequestMapping("/adminB")
public class StudentController {

    @Autowired
    private UserService userService;

    @GetMapping("/findall")
    public String findAll(){
        System.out.println("获取所有学生信息");
        List<Student> student = userService.findAll();
        return JSON.toJSONString(student);
    }
}
