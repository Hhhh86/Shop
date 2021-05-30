package wushanqiyong.shop.service.student.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.service.student.GoodsService;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName GoodsServiceImpl
 * @create 2021-05-30 21:37
 * @Author by hyp
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        List<Goods> goodsList = goodsMapper.selectList(null);
        return goodsList;
    }
}
