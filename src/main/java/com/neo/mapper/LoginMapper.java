package com.neo.mapper;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.UserEntity;

public interface LoginMapper {

	UserEntity userLogin(@Param("userName")String userName, @Param("password")String password);
}
