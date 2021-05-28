package wushanqiyong.shop.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tuoguan_goods")
public class Goods {
    @Id
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "buy_price")
    private Float buyPrice;

    private String content;

    private Integer flag;

    private String name;

    private String photo;

    private Integer recommend;

    @Column(name = "sell_price")
    private Float sellPrice;

    private Integer status;

    @Column(name = "goods_category_id")
    private Long goodsCategoryId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "view_number")
    private Integer viewNumber;

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
     * @return buy_price
     */
    public Float getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice
     */
    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
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
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return recommend
     */
    public Integer getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    /**
     * @return sell_price
     */
    public Float getSellPrice() {
        return sellPrice;
    }

    /**
     * @param sellPrice
     */
    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return goods_category_id
     */
    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    /**
     * @param goodsCategoryId
     */
    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
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

    /**
     * @return view_number
     */
    public Integer getViewNumber() {
        return viewNumber;
    }

    /**
     * @param viewNumber
     */
    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }
}