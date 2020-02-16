package com.api.shadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.constants.Authorities;
import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.VersionRepository;
import com.api.shadow.response.ApiResponseUserList;
import com.api.shadow.response.ApiResponseVersionObject;
import com.api.shadow.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	public static final String SUCCESS = "success";

	@Autowired
	UserService userService;

	@Autowired
	VersionRepository versionRepository;

	@GetMapping(produces = "application/json")
	public ApiResponseVersionObject version() throws Exception {
		return new ApiResponseVersionObject(HttpStatus.OK, VariableConstants.SUCCESS,
				versionRepository.findByIsAuthenticated(VariableConstants.FLAG_Y));
	}

	@Secured({ Authorities.ROLE_ADMIN })
	@RequestMapping(value = "/get-user-list", method = RequestMethod.GET)
	public ApiResponseUserList listUser() {
		return new ApiResponseUserList(HttpStatus.OK, VariableConstants.SUCCESS, userService.findAll());
	}

}
