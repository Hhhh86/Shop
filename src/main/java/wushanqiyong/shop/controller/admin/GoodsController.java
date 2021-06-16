package wushanqiyong.shop.controller.admin;

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
 * @ClassName GoodsController
 * @create 2021-05-30 14:45
 * @Author by hyp
 */
@RestController
@RequestMapping("/admin2goods")
public class GoodsController {

    @Autowired
    private GoodService goodsService;

    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("获取所有商品信息");
        List<Goods> goodsList = goodsService.findAll();
        return JSON.toJSONString(goodsList);
    }

    @RequestMapping("/remove")
    public String removeById(@RequestParam("id") Integer id){
        System.out.println("下架该商品信息");
        goodsService.removeById(id);
        return JSON.toJSONString("下架成功");
    }


}
