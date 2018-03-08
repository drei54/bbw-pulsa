package com.bbw.pulsa.enums;

public enum InputType {
	OPERATOR("operator"), 
	VOUCHER("voucher"), 
	LOGIN("login"), 
	TRANSACTION("transaction"),
	UNKNOWN("unknown");

	private String type;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	InputType(String type) {
		this.type = type;
	}


	public static final InputType get(String type) {
		for (InputType inputType : InputType.values()) {
			if (inputType.getType().equals(type))
				return inputType;
		}

		return UNKNOWN;
	}
}