package com.api.shadow.modal;

import java.io.Serializable;

public class NotificationModal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notifUserEmail;
	private String notifTitle;
	private String notifSortDescription;
	private String notifDescription;
	private String notifImage;

	public String getNotifUserEmail() {
		return notifUserEmail;
	}

	public void setNotifUserEmail(String notifUserEmail) {
		this.notifUserEmail = notifUserEmail;
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

}
