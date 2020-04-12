package com.api.shadow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.shadow.dao.UserDao;
import com.api.shadow.entity.CardEntity;
import com.api.shadow.entity.RoleEntity;
import com.api.shadow.entity.UserEntity;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserEntity user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		Set<SimpleGrantedAuthority> grantedAuthorities = getAuthorities(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserPassword(),
				grantedAuthorities);
	}

	/*
	 * private List<SimpleGrantedAuthority> getAuthority() { return
	 * Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")); }
	 */

	private Set<SimpleGrantedAuthority> getAuthorities(UserEntity user) {
		Set<RoleEntity> roleByUserId = user.getRoles();
		final Set<SimpleGrantedAuthority> authorities = roleByUserId.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase()))
				.collect(Collectors.toSet());
		return authorities;
	}

	public List<UserEntity> findAll() {
		List<UserEntity> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public UserEntity save(UserEntity user) {
		return userDao.save(user);
	}

	@Override
	public UserEntity findByUserEmail(String userEmail) {
		return userDao.findByUserEmail(userEmail);
	}

	@Override
	public boolean saveCardDetail(CardEntity cardEntity, String username) {
		boolean resp = false;
		UserEntity userEntity = null;

		if (null != username) {
			userEntity = userDao.findByUsername(username);
			if (null == userEntity) {
				resp = false;
			} else {
				cardEntity.setCardUserID(userEntity.getUserID());
				cardEntity.setUpdatedBy("ENGINE");
				cardEntity.setCreatedDateTime(new Date());
				cardEntity.setModifiedDateTime(new Date());
				resp = userDao.saveCardDetail(cardEntity);
			}
		}
		return resp;
	}

	@Override
	public CardEntity getCardDetail(String username) {
		CardEntity cardEntity = null;
		UserEntity userEntity = null;

		if (null != username) {
			userEntity = userDao.findByUsername(username);
			if (null == userEntity) {
				cardEntity = null;
			} else {
				cardEntity = userDao.getCardDetail(userEntity.getUserID());
			}
		}
		return cardEntity;
	}
}
