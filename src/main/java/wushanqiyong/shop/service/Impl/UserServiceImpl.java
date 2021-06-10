package wushanqiyong.shop.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wushanqiyong.shop.mapper.StudentMapper;
import wushanqiyong.shop.pojo.Student;

import wushanqiyong.shop.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("name",name);
        List<Student> result = studentMapper.selectByMap(map);
       if(result == null){
           return false;
       }else{
           return true;
       }
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
    public Student save(String sn, String password) {
        Student student = new Student();
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        student.setAcademy("");
        student.setGrade("");
        student.setMobile("");
        student.setQq("");
        student.setSchool("");
        student.setSn(sn);
        student.setStatus(1);
        student.setPassword(password);
        studentMapper.insert(student);
        return student;
    }


    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentMapper.selectList(null);
        studentList.forEach(System.out::println);
        return studentList;
    }

    @Override
    public void banStudent(Integer id) {
        Student student = studentMapper.selectById(id);
        student.setStatus(0);
        student.setUpdateTime(new Date());
        int i = studentMapper.updateById(student);
        System.out.println("影响行数"+i);
    }

    @Override
    public boolean queryByStudentID(Integer id) {
        Student student = studentMapper.selectById(id);
        if(student != null){
            return  true;
        }else {
            return false;
        }
    }
}
