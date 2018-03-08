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
@Table(name = "transaction")
public class Transaction{

	private long id;
	private User user;
	private Operator operator;
	private String harga;
	private String noHp;
	
	public Transaction() {}
	public Transaction(User user, Operator operator, String harga, String noHp) {
		this.user = user;
		this.operator = operator;
		this.harga = harga;
		this.noHp = noHp;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "transaction_id", columnDefinition = "INT")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	@Column(name = "harga", nullable = false, length = 10)
	public String getHarga() {
		return harga;
	}
	public void setHarga(String harga) {
		this.harga = harga;
	}
	@Column(name = "no_hp", nullable = false, length = 15)
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	
	
}
