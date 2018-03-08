package com.bbw.pulsa.entity.response;

import java.io.Serializable;
import java.util.List;

import com.bbw.pulsa.enums.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long userid;
	private List<OperatorResponse> operator;
	private List<VoucherResponse> voucher;
	
	public PResponse() {}
	
	public PResponse(ResponseCode code) {
		this.status = code.getStatus();
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public List<OperatorResponse> getOperator() {
		return operator;
	}
	public void setOperator(List<OperatorResponse> operator) {
		this.operator = operator;
	}
	public List<VoucherResponse> getVoucher() {
		return voucher;
	}
	public void setVoucher(List<VoucherResponse> voucher) {
		this.voucher = voucher;
	}
	
	
	
}
