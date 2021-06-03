package wushanqiyong.shop.service;

import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.News;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName NewsService
 * @create 2021-06-03 19:53
 * @Author by hyp
 */
public interface NewsService {

    /*查询所有公告*/

    /*查询所有商品信息*/
    List<News> findAll();
}
