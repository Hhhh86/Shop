package wushanqiyong.shop.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wushanqiyong.shop.pojo.Goods;

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

    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("获取所有商品信息");
        List<Goods> goodsList = goodsService.findAll();
        return JSON.toJSONString(goodsList);
    }


    @RequestMapping("/findpage")
    public String findPage(@RequestParam(defaultValue = "0") Integer pageNum){
        System.out.println("获取分页商品信息");
        List<Goods> goodsList = goodsService.selectPage(pageNum);
        return JSON.toJSONString(goodsList);
    }
}
