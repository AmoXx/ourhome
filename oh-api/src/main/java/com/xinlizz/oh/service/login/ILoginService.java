package com.xinlizz.oh.service.login;

import com.xinlizz.oh.dto.LoginInfoDto;

/**
 * ILoginService 登录接口
 */
public interface ILoginService {

    /**
     * 登录操作
     *
     * @return com.xinlizz.oh.dto.LoginInfoDto
     */
    LoginInfoDto doLogin(LoginInfoDto loginInfoDto);
}
