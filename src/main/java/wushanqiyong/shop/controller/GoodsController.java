package wushanqiyong.shop.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.pojo.Student;
import wushanqiyong.shop.service.student.GoodsService;

import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName GoodsController
 * @create 2021-05-30 14:45
 * @Author by hyp
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/findall")
    public String findAll(){
        System.out.println("获取所有商品信息");
        List<Goods> goodsList = goodsService.findAll();
        return JSON.toJSONString(goodsList);
    }
}
