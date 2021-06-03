package wushanqiyong.shop.service;

import wushanqiyong.shop.pojo.Goods;


import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName GoodsService
 * @create 2021-05-30 21:35
 * @Author by hyp
 */
public interface GoodsService {

    /*查询所有商品信息*/
    List<Goods> findAll();
    /*分页查询商品信息*/
    List<Goods> selectPage(Integer page);
    /*根据id移除商品信息*/
    void removeById(Integer id);
}
