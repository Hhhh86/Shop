package wushanqiyong.shop.service;

import wushanqiyong.shop.pojo.Comment;

import java.util.List;

/**
 * 功能描述：评论服务接口
 *
 * @Author: 曾伟添
 * @Date: 2021/6/6 17:34
 */

public interface CommentService {
    // 获取商品所有评论
    List<Comment> getCommentByGoodID(Integer goodid);
    // 获取用户商品评论和信息
    List<Comment> getCommentByGoodIDAndSn(Integer goodid, Integer sn);


    boolean saveComment(Long goodids, Long studentid, String Context);

    /**
     * ID为主键
     * @param id
     * @param
     * @return
     */
    boolean deleteByStudentID(Long id);

    boolean saveRepyComment(Long id , String repy );






}

