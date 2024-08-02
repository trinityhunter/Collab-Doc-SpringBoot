package com.example.CollabDoc.payload;

import com.example.CollabDoc.entities.Auth;

public class LoginResponse {

    private Auth user;
    private String token;

    public LoginResponse(Auth user, String token) {
        this.user = user;
        this.token = token;
    }

	public Auth getUser() {
		return user;
	}

	public void setUser(Auth user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    
    
}
