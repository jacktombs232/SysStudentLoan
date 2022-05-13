package com.example.sysstudentloan.dao;

import com.example.sysstudentloan.entity.ParentAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {
    public Map VerificationStduent(@Param("username") String username , @Param("password") String password);

    public List<ParentAuthority> selectAuthorityInfo(Map map);
}
