package wushanqiyong.shopapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wushanqiyong.shop.ShopApiApplication;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.user.UserService;

import java.util.Date;

@SpringBootTest(classes = ShopApiApplication.class)
class ShopApiApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void testSelect() {

    }
}
