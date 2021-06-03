package wushanqiyong.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wushanqiyong.shop.pojo.News;
import wushanqiyong.shop.utils.MyMapper;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
}