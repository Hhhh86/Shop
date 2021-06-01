package wushanqiyong.shopapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wushanqiyong.shop.ShopApiApplication;
import wushanqiyong.shop.mapper.StudentMapper;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.admin.AdminService;
import wushanqiyong.shop.service.student.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

@SpringBootTest(classes = ShopApiApplication.class)
class ShopApiApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Test
    void testSelect() {

    }

    @Test
    void testLogin() {
        User user = adminService.queryUserForLogin("测试账号", "123456");
        System.out.println(user);
    }

    @Test
    void testFind() {
        Student student = studentMapper.selectById(2);
        System.out.println(student);
    }

    @Test
    void testUpdate() {
        userService.banStudent(3);
    }
}
