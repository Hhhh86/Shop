package wushanqiyong.shop.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wushanqiyong.shop.mapper.OperaterLogMapper;
import wushanqiyong.shop.mapper.UserMapper;
import wushanqiyong.shop.pojo.OperaterLog;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.service.AdminService;

import javax.servlet.http.HttpSession;
import java.util.Date;

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

    @Autowired
    private OperaterLogMapper operaterLogMapper;


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

        OperaterLog operaterLog = new OperaterLog();
        operaterLog.setUpdateTime(new Date());
        operaterLog.setContent("用户【"+result.getUsername()+"】于【"+operaterLog.getUpdateTime()+"】登录系统！");
        operaterLogMapper.insert(operaterLog);
        return result;
    }


    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
