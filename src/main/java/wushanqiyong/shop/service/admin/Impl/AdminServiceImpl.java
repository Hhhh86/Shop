package wushanqiyong.shop.service.admin.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wushanqiyong.shop.mapper.UserMapper;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.admin.AdminService;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName shop-api
 * @ClassName UserServiceImpl
 * @create 2021-05-29 16:12
 * @Author by hyp
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User result = userMapper.selectOne(queryWrapper);
        return result != null ? true : false;
    }


    @Override
    @Transactional
    public User queryUserForLogin(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        User result = userMapper.selectOne(queryWrapper);
        return result;
    }


    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
