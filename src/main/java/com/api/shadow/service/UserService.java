package com.api.shadow.service;

import java.util.List;

import com.api.shadow.entity.CardEntity;
import com.api.shadow.entity.UserEntity;

public interface UserService {

	UserEntity save(UserEntity user);

	List<UserEntity> findAll();

	UserEntity findByUserEmail(String userEmail);

	boolean saveCardDetail(CardEntity cardEntity, String username);

	CardEntity getCardDetail(String username);
}
