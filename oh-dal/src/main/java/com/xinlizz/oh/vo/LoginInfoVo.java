package com.xinlizz.oh.vo;

import com.xinlizz.oh.dto.LoginInfoDto;
import com.xinlizz.oh.dto.UserInfoDto;

/**
 * LoginInfoVo 登录信息VO 
 *
 * @Author: xinlizz
 * @Date: 2018/7/14
 */
public class LoginInfoVo extends LoginInfoDto {

    /** session的key */
    public static final String SESSION_LOGIN = "loginInfoVo";

    /** 用户信息 */
    private UserInfoDto userInfoDto;

    public UserInfoDto getUserInfoDto() {
        return userInfoDto;
    }

    public void setUserInfoDto(UserInfoDto userInfoDto) {
        this.userInfoDto = userInfoDto;
    }
}
