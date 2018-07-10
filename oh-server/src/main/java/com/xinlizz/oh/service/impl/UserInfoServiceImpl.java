package com.xinlizz.oh.service.impl;

import com.xinlizz.oh.constant.CommonConstant;
import com.xinlizz.oh.dto.UserInfoDto;
import com.xinlizz.oh.dto.UserInfoDtoExample;
import com.xinlizz.oh.mapper.UserInfoDtoMapperExt;
import com.xinlizz.oh.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.xinlizz.oh.service.impl
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoDtoMapperExt mapperExt;

    @Override
    public UserInfoDto queryUserInfoByLoginId(Long loginId) {
        UserInfoDtoExample example = new UserInfoDtoExample();
        example.createCriteria().andLoginIdEqualTo(loginId).andIsDeletedEqualTo(CommonConstant.NO);
        return null;
    }
}
