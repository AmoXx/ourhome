package com.xinlizz.oh.service.impl;

import com.xinlizz.oh.constant.CommonConstant;
import com.xinlizz.oh.dto.LoginInfoDto;
import com.xinlizz.oh.dto.LoginInfoDtoExample;
import com.xinlizz.oh.dto.UserInfoDto;
import com.xinlizz.oh.mapper.LoginInfoDtoMapperExt;
import com.xinlizz.oh.service.login.ILoginService;
import com.xinlizz.oh.service.user.IUserInfoService;
import com.xinlizz.oh.utils.PasswordEnOrDescUtil;
import com.xinlizz.oh.vo.LoginInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * LoginInfoServiceImpl 登录服务接口实现类
 *
 * @Author: xinlizz
 * @Date: 2018/7/14
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoginInfoServiceImpl implements ILoginService {

    @Autowired
    private LoginInfoDtoMapperExt loginInfoDtoMapperExt;

    @Autowired
    private IUserInfoService userInfoService;

    @Resource
    private RedisTemplate<String, LoginInfoVo> redisTemplate;

    @Override
    public LoginInfoVo doLogin(LoginInfoDto loginInfoDto) throws Exception {
        LoginInfoDtoExample example = new LoginInfoDtoExample();
        example.createCriteria().andLoginNumEqualTo(loginInfoDto.getLoginNum()).andLoginPasswordEqualTo(PasswordEnOrDescUtil.encodePassword(loginInfoDto.getLoginPassword())).andIsDeletedEqualTo(CommonConstant.NO);
        List<LoginInfoDto> list = loginInfoDtoMapperExt.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        LoginInfoVo loginInfoVo = new LoginInfoVo();
        BeanUtils.copyProperties(list.get(0), loginInfoVo, new String[]{"loginPassword"});
        UserInfoDto userInfoDto = userInfoService.queryUserInfoByLoginId(loginInfoVo.getId());
        loginInfoVo.setUserInfoDto(userInfoDto);
        redisTemplate.opsForValue().set(loginInfoVo.getId().toString(), loginInfoVo);
        redisTemplate.expire(loginInfoVo.getId().toString(), 5, TimeUnit.MINUTES);
        return loginInfoVo;
    }

    @Override
    public LoginInfoDto registeLoginInfo(LoginInfoDto loginInfoDto) throws Exception {
        loginInfoDto.setLoginPassword(PasswordEnOrDescUtil.encodePassword(loginInfoDto.getLoginPassword()));
        loginInfoDtoMapperExt.insertSelective(loginInfoDto);

        LoginInfoVo loginInfoVo = new LoginInfoVo();
        BeanUtils.copyProperties(loginInfoDto, loginInfoVo);
        redisTemplate.opsForValue().set(loginInfoVo.getId().toString(), loginInfoVo);
        redisTemplate.expire(loginInfoVo.getId().toString(), 5, TimeUnit.MINUTES);
        return loginInfoDto;
    }

    @Override
    public void doLogout(LoginInfoDto loginInfoDto) throws Exception {
        loginInfoDto = redisTemplate.opsForValue().get(loginInfoDto.getId());
        if (null != loginInfoDto) {
            redisTemplate.delete(loginInfoDto.getId().toString());
        }
    }

    @Override
    public boolean validateLoginNum(String loginNum) {
        if (StringUtils.isEmpty(loginNum)) {
            return false;
        }

        LoginInfoDtoExample example = new LoginInfoDtoExample();
        example.createCriteria().andLoginNumEqualTo(loginNum).andIsDeletedEqualTo(CommonConstant.NO);
        List<LoginInfoDto> list = loginInfoDtoMapperExt.selectByExample(example);
        return CollectionUtils.isEmpty(list);
    }

    @Override
    public LoginInfoDto queryLoginInfoById(Long loginId) {
        return loginInfoDtoMapperExt.selectByPrimaryKey(loginId);
    }

    @Override
    public void modifyLoginPassword(Long loginId, String newPwd) {
        LoginInfoDto loginInfoDto = queryLoginInfoById(loginId);
        loginInfoDto.setLoginPassword(PasswordEnOrDescUtil.encodePassword(newPwd));
        loginInfoDtoMapperExt.updateByPrimaryKeySelective(loginInfoDto);
    }
}
