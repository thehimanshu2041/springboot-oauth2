package com.api.shadow.dao;

import java.util.List;

import com.api.shadow.entity.CardEntity;
import com.api.shadow.entity.UserEntity;

public interface UserDao {

	UserEntity save(UserEntity user);

	List<UserEntity> findAll();

	UserEntity findByUsername(String userId);

	UserEntity findByUserEmail(String userEmail);

	boolean saveCardDetail(CardEntity cardEntity);

	CardEntity getCardDetail(int userID);
}
