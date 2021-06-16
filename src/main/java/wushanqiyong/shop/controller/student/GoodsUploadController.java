package wushanqiyong.shop.controller.student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import wushanqiyong.shop.pojo.Goods;
import wushanqiyong.shop.service.GoodService;
import wushanqiyong.shop.utils.GithubUploader;
import wushanqiyong.shop.vo.JSONResultVO;


/**
 * 功能描述：
 *
 * @Author: 曾伟添
 * @Date: 2021/6/7 10:09
 */

@RestController
@RequestMapping(value = "/upload")
public class GoodsUploadController {

    @Autowired
    private GoodService goodsService;

    @Autowired
    private GithubUploader githubUploader;


    /**
     * 上传商品
     * @param multipartFiles
     * @param price
     * @param sellprice
     * @param name
     * @param studentId
     * @param goodsCategoryId
     * @param content
     * @return
     * @throws IOException
     */
    @PostMapping(value = "goods", consumes = "multipart/form-data")
    public JSONResultVO upload(@RequestParam("file") MultipartFile[] multipartFiles,
                               @RequestParam("buyprice") Float price,
                               @RequestParam("sellprice") Float sellprice,
                               @RequestParam("name") String name,
                               @RequestParam("studentId") Long studentId,
                               @RequestParam("goodsCategoryId") Long goodsCategoryId,
                               @RequestParam("content") String content) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String url = this.githubUploader.upload(file);
            arrayList.add(url);
        }


        boolean flag = goodsService.saveGoods(price, sellprice,  name, arrayList, content, goodsCategoryId, studentId);
        if(flag){
            return JSONResultVO.ok(arrayList);
        }else {
            return  JSONResultVO.errorMsg("发布商品失败");
        }

    }

    @GetMapping("goods")
    public JSONResultVO queryGoods(@RequestParam("sid") Integer sid){
        List<Goods> goods = goodsService.queryByGoodsSid(sid);
        return  JSONResultVO.ok(goods);
    }

    @DeleteMapping("delete")
    public  JSONResultVO deleteById(@RequestParam("id") Integer id){
        boolean flag = goodsService.deleteByID(id);
        if(flag){
            return JSONResultVO.ok();
        }else {
            return  JSONResultVO.errorMsg("商品id错误");
        }
    }




}
