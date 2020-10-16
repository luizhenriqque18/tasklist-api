package com.supero.tasklist.exceptionhandler;

import java.time.LocalDateTime;

public class EntityException {

	public String msg;
	public LocalDateTime date;
	
	public EntityException(String message, LocalDateTime now) {
		this.msg = message;
		this.date = now;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
