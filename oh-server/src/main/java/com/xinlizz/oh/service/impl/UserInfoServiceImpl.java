package com.xinlizz.oh.service.impl;

import com.xinlizz.oh.constant.CommonConstant;
import com.xinlizz.oh.dto.UserInfoDto;
import com.xinlizz.oh.dto.UserInfoDtoExample;
import com.xinlizz.oh.mapper.UserInfoDtoMapperExt;
import com.xinlizz.oh.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * com.xinlizz.oh.service.impl
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoDtoMapperExt userInfoDtoMapperExt;

    @Override
    public UserInfoDto queryUserInfoByLoginId(Long loginId) {
        UserInfoDtoExample example = new UserInfoDtoExample();
        example.createCriteria().andLoginIdEqualTo(loginId).andIsDeletedEqualTo(CommonConstant.NO);
        List<UserInfoDto> list = userInfoDtoMapperExt.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void saveUserInfo(UserInfoDto userInfoDto){
        userInfoDtoMapperExt.insertSelective(userInfoDto);
    }

    @Override
    public void modifyUserInfo(UserInfoDto userInfoDto) {
        userInfoDtoMapperExt.updateByPrimaryKeySelective(userInfoDto);
    }
}
