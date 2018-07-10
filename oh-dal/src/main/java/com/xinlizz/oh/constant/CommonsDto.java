package com.xinlizz.oh.constant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共实体类
 *
 * @author xinlizz
 */
public class CommonsDto implements Serializable {
    private static final long serialVersionUID = 7723669745330703914L;

    /** ID */
    private Long id;

    /** 创建者 */
    private String creator;

    /** 创建时间 */
    private Date createDate;

    /** 更新者 */
    private String updater;

    /** 更新时间 */
    private Date updateDate;

    /** 是否删除 */
    private String isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
