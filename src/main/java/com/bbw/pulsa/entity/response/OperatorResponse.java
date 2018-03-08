package com.bbw.pulsa.entity.response;

import java.io.Serializable;

import com.bbw.pulsa.entity.Operator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OperatorResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nama;
	
	public OperatorResponse() {}
	
	public OperatorResponse(Operator operator) {
		this.nama = operator.getName();
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	
}
