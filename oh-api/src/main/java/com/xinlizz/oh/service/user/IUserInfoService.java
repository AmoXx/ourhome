package com.xinlizz.oh.service.user;

import com.xinlizz.oh.dto.UserInfoDto;

/**
 * 用户服务类接口
 * @author xinlizz
 * @Date 2018/7/10
 */
public interface IUserInfoService {

    UserInfoDto queryUserInfoByLoginId(Long loginId);
}
