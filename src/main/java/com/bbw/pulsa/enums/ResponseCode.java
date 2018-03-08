package com.bbw.pulsa.enums;

public enum ResponseCode {
	SUKSES(1),GAGAL(0);	
	
	private int status = 1;
	
	private ResponseCode(int status) {
		this.status = status;
	}
	
	/*
	 * Setter and Getter
	 */
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
