package com.neo.mapper;

import com.neo.entity.UserEntity;

public interface LoginMapper {

	UserEntity userLogin(String username, String password);
}
