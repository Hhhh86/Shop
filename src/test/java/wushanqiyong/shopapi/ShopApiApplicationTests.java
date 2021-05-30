package wushanqiyong.shopapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wushanqiyong.shop.ShopApiApplication;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.admin.AdminService;
import wushanqiyong.shop.service.student.UserService;

@SpringBootTest(classes = ShopApiApplication.class)
class ShopApiApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Test
    void testSelect() {

    }

    @Test
    void testLogin() {
        User user = adminService.queryUserForLogin("测试账号", "123456");
        System.out.println(user);
    }
}
