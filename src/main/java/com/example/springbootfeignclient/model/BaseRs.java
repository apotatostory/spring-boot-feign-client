package com.example.springbootfeignclient.model;

public class BaseRs {

	public BaseRs() {
	}

	public BaseRs(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
