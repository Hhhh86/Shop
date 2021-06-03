package wushanqiyong.shop.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wushanqiyong.shop.pojo.News;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.NewsService;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName NewsController
 * @create 2021-06-03 19:40
 * @Author by hyp
 */
@RestController
@RequestMapping("/news")
public class NewShowController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("获取所有商品信息");
        List<News> news = newsService.findAll();
        return JSON.toJSONString(news);
    }


}
