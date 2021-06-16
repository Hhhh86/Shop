package wushanqiyong.shop.service;

import org.springframework.stereotype.Service;
import wushanqiyong.shop.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 曾伟添
 * @Date: 2021/6/15 21:17
 */
@Service
public interface GoodService {
    /*查询所有商品信息*/
    List<Goods> findAll();
    /*分页查询商品信息*/
    List<Goods> selectPage(Integer page);
    /*根据id移除商品信息*/
    void removeById(Integer id);
    // 查询商品是否存在
    boolean queryByGoodsId(Integer id);
    // 发布商品信息
    boolean saveGoods(float buyprice, float sellPrice , String name, ArrayList photo , String content, Long  goodsCategoryId, Long studentId  );
    // 学生查询用户的所有商品
    List<Goods> queryByGoodsSid(Integer id);
    // 学生删除单个商品
    boolean deleteByID(Integer id);
    //
}
