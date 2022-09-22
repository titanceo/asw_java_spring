package com.turns.asw.model.responsepersonalized;

public class GeneralResp {
	
	private String status;
	private String value;
	private String message;
	
	public GeneralResp() {}
	
	public GeneralResp(String status, String value, String message) {
		super();
		this.status = status;
		this.value = value;
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
