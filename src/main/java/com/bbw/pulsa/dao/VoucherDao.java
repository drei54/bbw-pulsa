package com.bbw.pulsa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bbw.pulsa.entity.Voucher;



@Transactional
public interface VoucherDao extends CrudRepository<Voucher, Long> {
	
	/**
	 * Find by id
	 * @param Id
	 * @return
	 */
	public Voucher findById(long Id);

	/**
	 * Find answer by question id
	 * @param Id
	 * @return
	 */
	public List<Voucher> findByOperatorName(String name);


}
