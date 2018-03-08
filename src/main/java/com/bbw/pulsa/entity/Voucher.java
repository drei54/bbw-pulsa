package com.bbw.pulsa.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "voucher")
public class Voucher{

	private long id;
	private String pulsa;
	private String harga;
	private Operator operator;

	
	@Id
    @GeneratedValue
    @Column(name = "voucher_id", columnDefinition = "INT")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "pulsa", nullable = false, length = 32)
	public String getPulsa() {
		return pulsa;
	}
	public void setPulsa(String pulsa) {
		this.pulsa = pulsa;
	}
	@Column(name = "harga", nullable = false, length = 10)
	public String getHarga() {
		return harga;
	}
	public void setHarga(String harga) {
		this.harga = harga;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}	
}
