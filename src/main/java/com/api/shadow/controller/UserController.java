package com.api.shadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.constants.Authorities;
import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.UserRepository;
import com.api.shadow.dao.repository.VersionRepository;
import com.api.shadow.entity.CardEntity;
import com.api.shadow.entity.UserEntity;
import com.api.shadow.response.ApiResponseCardObject;
import com.api.shadow.response.ApiResponseCardboolean;
import com.api.shadow.response.ApiResponseUserList;
import com.api.shadow.response.ApiResponseUserObject;
import com.api.shadow.response.ApiResponseVersionObject;
import com.api.shadow.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	public static final String SUCCESS = "success";

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	VersionRepository versionRepository;

	@GetMapping(produces = "application/json")
	public ApiResponseVersionObject version() throws Exception {
		return new ApiResponseVersionObject(HttpStatus.OK, VariableConstants.SUCCESS,
				versionRepository.findByIsAuthenticated(VariableConstants.FLAG_Y));
	}

	@RequestMapping(value = "/check-user-admin", method = RequestMethod.GET)
	public ApiResponseUserObject checkUserAdmin(@RequestParam(required = false, name = "username") String username) {

		UserEntity userEntity = userRepository.findByUsername(username);
		if (!userEntity.getUserIsAdmin().equalsIgnoreCase(VariableConstants.FLAG_Y)) {
			userEntity = null;
		}
		return new ApiResponseUserObject(HttpStatus.OK, VariableConstants.SUCCESS, userEntity);
	}

	@Secured({ Authorities.ROLE_ADMIN, Authorities.ROLE_USER })
	@GetMapping(value = "get-user-detail", produces = "application/json")
	public ApiResponseUserObject userDetail(@RequestParam(required = false, name = "userEmail") String userEmail)
			throws Exception {
		return new ApiResponseUserObject(HttpStatus.OK, VariableConstants.SUCCESS,
				userService.findByUserEmail(userEmail));
	}

	@Secured({ Authorities.ROLE_ADMIN })
	@RequestMapping(value = "/get-user-list", method = RequestMethod.GET)
	public ApiResponseUserList listUser() {
		return new ApiResponseUserList(HttpStatus.OK, VariableConstants.SUCCESS, userService.findAll());
	}

	@Secured({ Authorities.ROLE_ADMIN, Authorities.ROLE_USER })
	@RequestMapping(value = "/save-card-detail", method = RequestMethod.POST)
	public ApiResponseCardboolean SaveCardDetail(@RequestBody CardEntity cardEntity,
			@RequestParam(required = true, name = "username") String username) {
		return new ApiResponseCardboolean(HttpStatus.OK, VariableConstants.SUCCESS,
				userService.saveCardDetail(cardEntity, username));
	}

	@Secured({ Authorities.ROLE_ADMIN, Authorities.ROLE_USER })
	@RequestMapping(value = "/get-card-detail", method = RequestMethod.GET)
	public ApiResponseCardObject getCardDetail(@RequestParam(required = true, name = "username") String username) {
		return new ApiResponseCardObject(HttpStatus.OK, VariableConstants.SUCCESS, userService.getCardDetail(username));
	}

}
