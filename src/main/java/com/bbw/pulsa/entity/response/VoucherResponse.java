package com.bbw.pulsa.entity.response;

import java.io.Serializable;

import com.bbw.pulsa.entity.Voucher;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VoucherResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pulsa;
	private String harga;
	
	public VoucherResponse() {}
	
	public VoucherResponse(Voucher voucher) {
		this.pulsa = voucher.getPulsa();
		this.harga = voucher.getHarga();
	}

	public String getPulsa() {
		return pulsa;
	}

	public void setPulsa(String pulsa) {
		this.pulsa = pulsa;
	}

	public String getHarga() {
		return harga;
	}

	public void setHarga(String harga) {
		this.harga = harga;
	}
	
	
}
