package wushanqiyong.shop.pojo;

import javax.persistence.*;

@Table(name = "role_authorities")
public class RoleAuthorities {
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "authorities_id")
    private Long authoritiesId;

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return authorities_id
     */
    public Long getAuthoritiesId() {
        return authoritiesId;
    }

    /**
     * @param authoritiesId
     */
    public void setAuthoritiesId(Long authoritiesId) {
        this.authoritiesId = authoritiesId;
    }
}