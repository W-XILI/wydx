package com.ibm.cn.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.cn.entity.User;


@Mapper
public interface UserMapper {
	public int addUser(User user);
}
