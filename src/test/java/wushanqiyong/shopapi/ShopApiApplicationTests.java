package wushanqiyong.shopapi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wushanqiyong.shop.ShopApiApplication;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.mapper.StudentMapper;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.admin.AdminService;
import wushanqiyong.shop.service.student.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ShopApiApplication.class)
class ShopApiApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void testSelect() {
        boolean b = userService.queryUsernameIsExist("测试账号");
        System.out.println(b);
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

    @Test
    public List<Goods> selectPage() {
        List<Goods> goodsList = new ArrayList<>();
        Page<Goods> pageSize = new Page<>(2,5);
        IPage<Goods> Result = goodsMapper.selectPage(pageSize, null);
        for(Goods goods : Result.getRecords()){
            goodsList.add(goods);
        }
       return goodsList;
    }
}
