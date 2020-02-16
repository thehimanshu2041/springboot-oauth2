package com.api.shadow.dao;

import java.util.List;

import com.api.shadow.modal.entity.UserEntity;

public interface UserDao {

	UserEntity save(UserEntity user);

	List<UserEntity> findAll();

	UserEntity findByUsername(String userId);

}
