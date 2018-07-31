package com.xinlizz.oh.service.login;

import com.xinlizz.oh.dto.LoginInfoDto;
import com.xinlizz.oh.vo.LoginInfoVo;

/**
 * ILoginService 登录接口
 */
public interface ILoginService {

    /**
     * 登录操作
     *
     * @return com.xinlizz.oh.dto.LoginInfoDto
     */
    LoginInfoVo doLogin(LoginInfoDto loginInfoDto) throws Exception;

    /**
     * 用户注册
     *
     * @author xinlizz
     * @Date 2018/7/14
     * @Param [loginInfoDto]
     * @return com.xinlizz.oh.dto.LoginInfoDto
     */
    LoginInfoDto registeLoginInfo(LoginInfoDto loginInfoDto) throws Exception;

    /**
     * 退出系统
     *
     * @author xinlizz
     * @Date 2018/7/14
     * @Param [loginInfoDto]
     * @return void
     */
    void doLogout(LoginInfoDto loginInfoDto) throws Exception;

    /**
     * 校验登录账号是否重复
     *
     * @author xinlizz
     * @Date 2018/7/24
     * @Param [loginNum]
     * @return boolean
     */
    boolean validateLoginNum(String loginNum);

    /**
     * 根据ID查询登录信息
     *
     * @author xinlizz
     * @Date 2018/7/31
     * @Param [loginId]
     * @return com.xinlizz.oh.dto.LoginInfoDto
     */
    LoginInfoDto queryLoginInfoById(Long loginId);

    /**
     * 修改密码
     *
     * @author xinlizz
     * @Date 2018/7/30
     * @Param [loginId, loginPassword]
     * @return void
     */
    void modifyLoginPassword(Long loginId, String loginPassword);
}
