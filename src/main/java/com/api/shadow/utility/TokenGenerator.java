package com.api.shadow.utility;

import java.util.Calendar;
import java.util.UUID;

public class TokenGenerator {

	public String generateToken() {
		String token = null;
		try {
			token = "TOKEN" + UUID.randomUUID().toString().toUpperCase() + Calendar.getInstance().getTimeInMillis();
		} catch (Exception e) {
			System.out.println("Unable to generate token.");
			e.printStackTrace();
		}
		return token;
	}

	public String generateUserID() {
		String userID = null;
		try {
			userID = "ID" + Calendar.getInstance().getTimeInMillis();
		} catch (Exception e) {
			System.out.println("Unable to generate UserID.");
			e.printStackTrace();
		}
		return userID;
	}
}
