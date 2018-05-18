package com.neo.mapper;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.User;

public interface LoginMapper {

	User userLogin(@Param("username")String username, @Param("password")String password);
}
