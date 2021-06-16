package wushanqiyong.shop.controller.student;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wushanqiyong.shop.pojo.Comment;
import wushanqiyong.shop.service.CommentService;
import wushanqiyong.shop.service.GoodService;
import wushanqiyong.shop.service.UserService;
import wushanqiyong.shop.vo.JSONResultVO;

import java.util.List;

/**
 * 功能描述：用来评论
 *
 * @Author: 曾伟添
 * @Date: 2021/6/6 17:32
 */

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private  UserService userService;

    @Autowired
    private GoodService goodsService;
    /**
     * 获取学生评论,指定商品，和指定用户
     */
    @PostMapping("/goodsId")
    public JSONResultVO GoodsComment(@RequestParam("goods_id") int id){
        if(StringUtils.isEmpty(id)){
            return JSONResultVO.errorMsg("传入的商品id不能为空");
        }
        List<Comment> comment = commentService.getCommentByGoodID(id);
        return JSONResultVO.ok(comment);
    }

    /**
     * 保存评论
     */
    @PostMapping("/goodsComment")
    public  JSONResultVO SaveComment(@RequestParam("goods_id") Long id,
                                     @RequestParam("context") String context,
                                     @RequestParam("student_id") Long student_id){
        if(StringUtils.isEmpty(id)){
            return JSONResultVO.errorMsg("传入的商品id不能为空");
        }else if (StringUtils.isEmpty(student_id)){
            return JSONResultVO.errorMsg("传入的学生id不能为空");
        }else  if(StringUtils.isEmpty(context)){
            return JSONResultVO.errorMsg("评论内容不能为空");
        }
        // 用户是否存在
        boolean snflag = userService.queryByStudentID(Math.toIntExact(student_id));
        if(snflag == false){
            return  JSONResultVO.errorMsg("学生用户不存在");
        }
        boolean goodflag = goodsService.queryByGoodsId(Math.toIntExact(id));
        if(goodflag == false){
            return  JSONResultVO.errorMsg("商品不存在");
        }
        boolean flag = commentService.saveComment(id, student_id, context);

        if(flag){
            return JSONResultVO.ok();
        }else {
            return  JSONResultVO.errorMsg("插入失败");
        }

    }

    /**
     *  删除学生评论
     */
    @DeleteMapping("/deleteByID")
    public  JSONResultVO deleteByID(@RequestParam("id") Long id){
        boolean flag = commentService.deleteByStudentID(id);
        if(flag){
            return  JSONResultVO.ok();

        }else {
            return  JSONResultVO.errorMsg("删除失败");
        }
    }

    /**
     * 回复评论
     */
    @PostMapping("/commentID")
    public  JSONResultVO saveCommentRepy(@RequestParam("id") Long id,
                                         @RequestParam("repy") String repy){
        boolean flag = commentService.saveRepyComment(id, repy);
        if(flag){
            return  JSONResultVO.ok();
        }else {
            return JSONResultVO.errorMsg("回复失败");
        }
    }















}
