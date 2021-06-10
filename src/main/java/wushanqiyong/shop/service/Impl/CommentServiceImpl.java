package wushanqiyong.shop.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wushanqiyong.shop.mapper.CommentMapper;
import wushanqiyong.shop.mapper.GoodsMapper;
import wushanqiyong.shop.pojo.Comment;
import wushanqiyong.shop.service.CommentService;
import wushanqiyong.shop.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 曾伟添
 * @Date: 2021/6/6 17:34
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;



    @Autowired
    private UserService userService;
    /**
     * 获取当下商品的评论信息
     * @param goodid
     * @return
     */


    @Override
    public List<Comment> getCommentByGoodID(Integer goodid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods_id", goodid);
        List<Comment> comments = commentMapper.selectByMap(map);
        return comments;
    }

    @Override
    public List<Comment> getCommentByGoodIDAndSn(Integer goodid, Integer sn) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods_id", goodid);
        map.put("student_id" ,sn);
        List<Comment> comments = commentMapper.selectByMap(map);
        return comments;
    }

    /**
     * 保存评论
     * @param goodids
     * @param studentid
     * @param Context
     * @return
     */
    @Override
    public boolean saveComment(Long goodids, Long studentid, String Context) {
        Comment comment = new Comment();
        comment.setContent(Context);
        comment.setCreateTime(new Date());
        comment.setGoodsId(goodids);
        comment.setUpdateTime(new Date());
        comment.setStudentId(studentid);
        // 先判断这个用户是否存在和这个商品是否存在

        int total = commentMapper.insert(comment);
        System.out.println(total);
        if(total == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteByStudentID(Long id) {
        int i = commentMapper.deleteById(id);
        if(i > 0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean saveRepyComment(Long id, String repy) {
        Comment comment = commentMapper.selectById(id);
        comment.setReplyTo(repy);
        comment.setUpdateTime(new Date());
        int i = commentMapper.updateById(comment);
        if(i > 0){
            return true;
        }else {
            return  false;
        }
    }


}
