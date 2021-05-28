package wushanqiyong.shop.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tuoguan_site_setting")
public class SiteSetting {
    @Id
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "all_rights")
    private String allRights;

    @Column(name = "logo_1")
    private String logo1;

    @Column(name = "logo_2")
    private String logo2;

    private String qrcode;

    @Column(name = "site_name")
    private String siteName;

    @Column(name = "site_url")
    private String siteUrl;

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
     * @return all_rights
     */
    public String getAllRights() {
        return allRights;
    }

    /**
     * @param allRights
     */
    public void setAllRights(String allRights) {
        this.allRights = allRights;
    }

    /**
     * @return logo_1
     */
    public String getLogo1() {
        return logo1;
    }

    /**
     * @param logo1
     */
    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }

    /**
     * @return logo_2
     */
    public String getLogo2() {
        return logo2;
    }

    /**
     * @param logo2
     */
    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    /**
     * @return qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * @param qrcode
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * @return site_name
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * @param siteName
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * @return site_url
     */
    public String getSiteUrl() {
        return siteUrl;
    }

    /**
     * @param siteUrl
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}