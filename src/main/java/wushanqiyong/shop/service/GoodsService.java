package wushanqiyong.shop.service;

import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.vo.JSONResultVO;


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
    // 查询商品是否存在
    boolean queryByGoodsId(Integer id);
    // 发布商品信息
    boolean saveGoods(float buyprice,  float sellPrice , String name, String photo , String content, Long  goodsCategoryId,  Long studentId  );
}
