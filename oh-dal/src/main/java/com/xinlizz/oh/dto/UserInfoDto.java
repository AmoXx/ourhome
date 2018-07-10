package com.xinlizz.oh.dto;

import com.xinlizz.oh.constant.CommonsDto;

import java.util.Date;

public class UserInfoDto extends CommonsDto {

    /** 登录信息ID */
    private Long loginId;

    /** 真实姓名 */
    private String name;

    /** 出生日期 */
    private Date birthday;

    /** 身份证号码 */
    private String identityId;

    /** 用户手机号 */
    private String phoneNum;

    /** 用户邮箱 */
    private String email;

    /** 国家ID */
    private Long countryId;

    /** 省份ID */
    private Long provinceId;

    /** 城市ID */
    private Long cityId;

    /** 详细地址 */
    private String address;

    /** 头像地址 */
    private String portraitUrl;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl == null ? null : portraitUrl.trim();
    }
}