package wushanqiyong.shop.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.mapper.NewsMapper;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.News;
import wushanqiyong.shop.service.NewsService;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName NewsServiceImpl
 * @create 2021-06-03 19:54
 * @Author by hyp
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findAll() {
        List<News> newsList = newsMapper.selectList(null);
        return newsList;
    }


}
