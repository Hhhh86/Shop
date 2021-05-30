package wushanqiyong.shop.service.user.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import wushanqiyong.shop.mapper.StudentMapper;
import wushanqiyong.shop.pojo.Student;

import wushanqiyong.shop.service.user.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName shop-api
 * @ClassName UserServiceImpl
 * @create 2021-05-29 16:12
 * @Author by hyp
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public boolean queryUsernameIsExist(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",name);
        Student result = studentMapper.selectOne(queryWrapper);
        return result != null ? true : false;
    }


    @Override
    @Transactional
    public Student queryUserForLogin(String sn, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",sn);
        queryWrapper.eq("password",password);
        Student result = studentMapper.selectOne(queryWrapper);
        return result;
    }


    @Override
    public Student save(Student student) {
        studentMapper.insert(student);
        return student;
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
