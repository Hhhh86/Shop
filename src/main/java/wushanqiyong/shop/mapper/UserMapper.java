package wushanqiyong.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wushanqiyong.shop.pojo.User;
import wushanqiyong.shop.utils.MyMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}