package com.api.shadow.modal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ENTITY")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", insertable = false, updatable = false)
	private int userID;

	@Column(name = "USER_FIRST_NAME", nullable = false)
	private String userFirstName;

	@Column(name = "USER_LAST_NAME", nullable = true)
	private String userLastName;

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String username;

	@Column(name = "USER_EMAIL", nullable = false, unique = true)
	private String userEmail;

	@Column(name = "USER_PASSWORD", nullable = false)
	private String userPassword;

	@Column(name = "USER_PHONE", nullable = false)
	private String userPhone;

	@Column(name = "USER_GENDER", nullable = false)
	private String userGender;

	@Column(name = "USER_TOKEN", nullable = false)
	private String userToken;

	@Column(name = "USER_IMAGE", nullable = true)
	private String userImage;

	@Column(name = "USER_IS_DELETED", nullable = false)
	private String userIsDeleted;

	@Column(name = "USER_IS_ADMIN", nullable = false)
	private String userIsAdmin;

	@Column(name = "USER_UPDATED_BY", nullable = false)
	private String userUpdatedBy;

	@Column(name = "USER_CREATED_DATE_TIME", nullable = false)
	private Date userCreatedDateTime;

	@Column(name = "USER_MODIFIED_DATE_TIME", nullable = false)
	private Date userModifiedDateTime;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "User_ROLES_ENTITY", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<RoleEntity> roles;

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserIsDeleted() {
		return userIsDeleted;
	}

	public void setUserIsDeleted(String userIsDeleted) {
		this.userIsDeleted = userIsDeleted;
	}

	public String getUserIsAdmin() {
		return userIsAdmin;
	}

	public void setUserIsAdmin(String userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

	public String getUserUpdatedBy() {
		return userUpdatedBy;
	}

	public void setUserUpdatedBy(String userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	public Date getUserCreatedDateTime() {
		return userCreatedDateTime;
	}

	public void setUserCreatedDateTime(Date userCreatedDateTime) {
		this.userCreatedDateTime = userCreatedDateTime;
	}

	public Date getUserModifiedDateTime() {
		return userModifiedDateTime;
	}

	public void setUserModifiedDateTime(Date userModifiedDateTime) {
		this.userModifiedDateTime = userModifiedDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
