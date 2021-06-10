package wushanqiyong.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import wushanqiyong.shop.pojo.Comment;
import wushanqiyong.shop.utils.MyMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}