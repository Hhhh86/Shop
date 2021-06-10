package wushanqiyong.shop.controller.student;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import wushanqiyong.shop.service.GoodsService;
import wushanqiyong.shop.utils.GithubUploader;
import wushanqiyong.shop.vo.JSONResultVO;


/**
 * 功能描述：
 *
 * @Author: 曾伟添
 * @Date: 2021/6/7 10:09
 */

@RestController
@RequestMapping("/upload")
public class GoodsUploadController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GithubUploader githubUploader;


    /**
     * 上传商品
     * @param multipartFile
     * @param price
     * @param sellprice
     * @param name
     * @param studentId
     * @param goodsCategoryId
     * @param content
     * @return
     * @throws IOException
     */
    @PostMapping("goods")
    public JSONResultVO upload(@RequestParam("file") MultipartFile multipartFile,
                               @RequestParam("buyprice") Float price,
                               @RequestParam("sellprice") Float sellprice,
                               @RequestParam("name") String name,
                               @RequestParam("studentId") Long studentId,
                               @RequestParam("goodsCategoryId") Long goodsCategoryId,
                               @RequestParam("content") String content) throws IOException {
        String url = this.githubUploader.upload(multipartFile);
        System.out.println("商品url" + url);
        boolean flag = goodsService.saveGoods(price, sellprice,  name, url, content, goodsCategoryId, studentId);
        if(flag){
            return JSONResultVO.ok(this.githubUploader.upload(multipartFile));
        }else {
            return  JSONResultVO.errorMsg("发布商品失败");
        }

    }



}
