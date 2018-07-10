package com.xinlizz.oh.mapper;

import com.xinlizz.oh.dto.LoginInfoDto;
import com.xinlizz.oh.dto.LoginInfoDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginInfoDtoMapper {
    long countByExample(LoginInfoDtoExample example);

    int deleteByExample(LoginInfoDtoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginInfoDto record);

    int insertSelective(LoginInfoDto record);

    List<LoginInfoDto> selectByExample(LoginInfoDtoExample example);

    LoginInfoDto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoginInfoDto record, @Param("example") LoginInfoDtoExample example);

    int updateByExample(@Param("record") LoginInfoDto record, @Param("example") LoginInfoDtoExample example);

    int updateByPrimaryKeySelective(LoginInfoDto record);

    int updateByPrimaryKey(LoginInfoDto record);
}