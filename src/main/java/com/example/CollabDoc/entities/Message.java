package com.example.CollabDoc.entities;

public class Message {
	
	private String email;
    private String room;
    private String socketId;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSocketId() {
		return socketId;
	}
	public void setSocketId(String socketId) {
		this.socketId = socketId;
	}

}
