package wushanqiyong.shop.utils;

/**
 * @ProjectName shop-api
 * @ClassName MyMapper
 * @create 2021-05-28 21:03
 * @Author by hyp
 */
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}