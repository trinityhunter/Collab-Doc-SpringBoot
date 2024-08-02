package com.example.CollabDoc.entities;

public class Notification {
	
	private String email;
    private String socketId;
    private String type;

    public Notification(String email, String socketId, String type) {
        this.email = email;
        this.socketId = socketId;
        this.type = type;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSocketId() {
		return socketId;
	}

	public void setSocketId(String socketId) {
		this.socketId = socketId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    

}
