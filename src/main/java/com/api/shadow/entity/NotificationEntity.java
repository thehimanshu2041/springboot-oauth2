package com.api.shadow.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATION_ENTITY")
public class NotificationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTIF_ID", insertable = false, updatable = false)
	private int notifID;

	@Column(name = "NOTIF_USER_ID", nullable = false)
	private int notifUserID;

	@Column(name = "NOTIF_TITLE", nullable = false)
	private String notifTitle;

	@Column(name = "NOTIF_SORT_DESCRIPTION", nullable = false)
	private String notifSortDescription;

	@Column(name = "NOTIF_DESCRIPTION", nullable = false)
	private String notifDescription;

	@Column(name = "NOTIF_IMAGE", nullable = true)
	private String notifImage;

	@Column(name = "NOTIF_IS_READ", nullable = false)
	private String notifIsRead;

	@Column(name = "NOTIF_IS_DELETED", nullable = false)
	private String notifIsDeleted;

	@Column(name = "NOTIF_UPDATED_BY", nullable = false)
	private String notifUpdatedBy;

	@Column(name = "NOTIF_CREATED_DATE_TIME", nullable = false)
	private Date notifCreatedDateTime;

	@Column(name = "NOTIF_MODIFIED_DATE_TIME", nullable = false)
	private Date notifModifiedDateTime;

	public int getNotifID() {
		return notifID;
	}

	public void setNotifID(int notifID) {
		this.notifID = notifID;
	}

	public int getNotifUserID() {
		return notifUserID;
	}

	public void setNotifUserID(int notifUserID) {
		this.notifUserID = notifUserID;
	}

	public String getNotifTitle() {
		return notifTitle;
	}

	public void setNotifTitle(String notifTitle) {
		this.notifTitle = notifTitle;
	}

	public String getNotifSortDescription() {
		return notifSortDescription;
	}

	public void setNotifSortDescription(String notifSortDescription) {
		this.notifSortDescription = notifSortDescription;
	}

	public String getNotifDescription() {
		return notifDescription;
	}

	public void setNotifDescription(String notifDescription) {
		this.notifDescription = notifDescription;
	}

	public String getNotifImage() {
		return notifImage;
	}

	public void setNotifImage(String notifImage) {
		this.notifImage = notifImage;
	}

	public String getNotifIsRead() {
		return notifIsRead;
	}

	public void setNotifIsRead(String notifIsRead) {
		this.notifIsRead = notifIsRead;
	}

	public String getNotifIsDeleted() {
		return notifIsDeleted;
	}

	public void setNotifIsDeleted(String notifIsDeleted) {
		this.notifIsDeleted = notifIsDeleted;
	}

	public String getNotifUpdatedBy() {
		return notifUpdatedBy;
	}

	public void setNotifUpdatedBy(String notifUpdatedBy) {
		this.notifUpdatedBy = notifUpdatedBy;
	}

	public Date getNotifCreatedDateTime() {
		return notifCreatedDateTime;
	}

	public void setNotifCreatedDateTime(Date notifCreatedDateTime) {
		this.notifCreatedDateTime = notifCreatedDateTime;
	}

	public Date getNotifModifiedDateTime() {
		return notifModifiedDateTime;
	}

	public void setNotifModifiedDateTime(Date notifModifiedDateTime) {
		this.notifModifiedDateTime = notifModifiedDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
