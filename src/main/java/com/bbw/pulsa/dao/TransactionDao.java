package com.bbw.pulsa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bbw.pulsa.entity.Transaction;



@Transactional
public interface TransactionDao extends CrudRepository<Transaction, Long> {
	
	/**
	 * Find by id
	 * @param Id
	 * @return
	 */
	public Transaction findById(long Id);

}
