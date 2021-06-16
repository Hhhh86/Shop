package wushanqiyong.shop.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.service.GoodService;


import java.util.List;

/**
 * @ProjectName shop-api
 * @ClassName GoodShowController
 * @create 2021-06-03 19:41
 * @Author by hyp
 */

@RestController
@RequestMapping("/goods")
public class GoodShowController {

    @Autowired
    private GoodService goodsService;

    @RequestMapping("/findpage")
    public String findPage(@RequestParam(defaultValue = "0") Integer pageNum){
        System.out.println("获取分页商品信息");
        List<Goods> goodsList = goodsService.selectPage(pageNum);
        return JSON.toJSONString(goodsList);
    }
}


