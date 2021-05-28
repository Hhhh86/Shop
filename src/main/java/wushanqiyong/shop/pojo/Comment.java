package wushanqiyong.shop.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tuoguan_comment")
public class Comment {
    @Id
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private String content;

    @Column(name = "reply_to")
    private String replyTo;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "student_id")
    private Long studentId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return reply_to
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * @param replyTo
     */
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    /**
     * @return goods_id
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return student_id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}