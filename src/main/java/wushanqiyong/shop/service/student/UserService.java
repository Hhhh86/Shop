package wushanqiyong.shop.service.student;

import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.vo.JSONResultVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName UserService
 * @create 2021-05-29 16:12
 * @Author by hyp
 */
public interface UserService {

    /*查询用户名是否已经存在*/
    boolean queryUsernameIsExist(String username);
    /*登录*/
    Student queryUserForLogin(String sn, String pwd);
    /*注册*/
    Student save(Student users);
    /*注销*/
     void logout(HttpSession session);
    /*查询所有学生用户*/
     List<Student> findAll();
    /*封禁学生用户*/
     void banStudent(Integer id);
}
