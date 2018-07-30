package com.xinlizz.oh.service.user;

import com.xinlizz.oh.dto.UserInfoDto;

/**
 * 用户服务类接口
 * @author xinlizz
 * @Date 2018/7/10
 */
public interface IUserInfoService {

    /**
     * 根据loginId查询用户信息
     *
     * @author xinlizz
     * @Date 2018/7/30
     * @Param [loginId]
     * @return com.xinlizz.oh.dto.UserInfoDto
     */
    UserInfoDto queryUserInfoByLoginId(Long loginId);

    /**
     * 保存用户信息
     *
     * @author xinlizz
     * @Date 2018/7/30
     * @Param [userInfoDto]
     * @return void
     */
    void saveUserInfo(UserInfoDto userInfoDto);

    /**
     * 更新用户信息
     *
     * @author xinlizz
     * @Date 2018/7/30
     * @Param [userInfoDto]
     * @return void
     */
    void modifyUserInfo(UserInfoDto userInfoDto);
}
