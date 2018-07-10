package com.xinlizz.oh.mapper;

import com.xinlizz.oh.dto.UserInfoDto;
import com.xinlizz.oh.dto.UserInfoDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDtoMapper {
    long countByExample(UserInfoDtoExample example);

    int deleteByExample(UserInfoDtoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDto record);

    int insertSelective(UserInfoDto record);

    List<UserInfoDto> selectByExample(UserInfoDtoExample example);

    UserInfoDto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfoDto record, @Param("example") UserInfoDtoExample example);

    int updateByExample(@Param("record") UserInfoDto record, @Param("example") UserInfoDtoExample example);

    int updateByPrimaryKeySelective(UserInfoDto record);

    int updateByPrimaryKey(UserInfoDto record);
}