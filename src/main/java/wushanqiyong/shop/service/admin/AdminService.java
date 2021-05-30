package wushanqiyong.shop.service.admin;

import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName shop-api
 * @ClassName UserService
 * @create 2021-05-29 16:12
 * @Author by hyp
 */
public interface AdminService {

    /*查询用户名是否已经存在*/
    boolean queryUsernameIsExist(String username);
    /*登录*/
    User queryUserForLogin(String username, String pwd);
    /*注销*/
    public void logout(HttpSession session);
}
