package wushanqiyong.shop.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.GoodsService;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<Goods> selectPage(Integer page) {
            List<Goods> goodsList = new ArrayList<>();
            Page<Goods> pageSize = new Page<>(page,10);
            IPage<Goods> Result = goodsMapper.selectPage(pageSize, null);
            for(Goods goods : Result.getRecords()){
                goodsList.add(goods);
            }
            return goodsList;
    }

    @Override
    public void removeById(Integer id) {
        Goods goods = goodsMapper.selectById(id);
        /*0下架 1上架 2售出*/
        goods.setStatus(0);
        goods.setUpdateTime(new Date());
        int i = goodsMapper.updateById(goods);
        System.out.println("影响行数"+i);
    }

}
