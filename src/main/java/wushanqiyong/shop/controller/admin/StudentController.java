package wushanqiyong.shop.controller.admin;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName UserController
 * @create 2021-05-30 14:46
 * @Author by hyp
 */
@RestController
@RequestMapping("/admin2student")
public class StudentController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("获取所有学生信息");
        List<Student> student = userService.findAll();
        return JSON.toJSONString(student);
    }

    @RequestMapping("/ban")
    public JSONResultVO banStundent(@RequestParam("id") Integer id){
        System.out.println("封禁id" +id+ "的学生用户");
        userService.banStudent(id);
        return JSONResultVO.ok("封禁成功");
    }
}
