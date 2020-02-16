package com.api.shadow.service;

import java.util.List;

import com.api.shadow.modal.entity.UserEntity;

public interface UserService {

	UserEntity save(UserEntity user);

	List<UserEntity> findAll();

}
