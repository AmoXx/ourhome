package com.xinlizz.oh.dto;

import com.xinlizz.oh.constant.CommonsDto;

public class LoginInfoDto extends CommonsDto {

    /** 登录账号 */
    private String loginNum;

    /** 登录密码 */
    private String loginPassword;

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum == null ? null : loginNum.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }
}