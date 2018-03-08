package com.bbw.pulsa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bbw.pulsa.entity.Operator;



@Transactional
public interface OperatorDao extends CrudRepository<Operator, Long> {
	
	public Operator findById(long Id);
	
	public Operator findByName(String name);

}
