package wushanqiyong.shop.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.GoodsService;
import wushanqiyong.shop.utils.GithubUploader;
import wushanqiyong.shop.vo.JSONResultVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private GithubUploader githubUploader;

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

    @Override
    public boolean queryByGoodsId(Integer id) {
        Goods goods = goodsMapper.selectById(id);
        if(goods != null){
            return  true;
        }else {
            return  false;
        }
    }

    @Override
    public boolean saveGoods(float buyprice,  float sellPrice ,String name, String photo, String content, Long goodsCategoryId, Long studentId) {
        Goods goods = new Goods();
        // 获取连接
        goods.setFlag(0);
        goods.setSellPrice(sellPrice);
        goods.setBuyPrice(buyprice);
        goods.setContent(content);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        goods.setPhoto(photo);
        goods.setRecommend(0);
        goods.setViewNumber(0);
        goods.setStatus(1);
        goods.setName(name);
        goods.setGoodsCategoryId(goodsCategoryId);
        int flag = goodsMapper.insert(goods);
        if(flag >= 1){
            return  true;
        }
        return false;
    }




}
