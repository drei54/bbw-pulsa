package com.bbw.pulsa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bbw.pulsa.entity.User;



@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	
	public User findById(long Id);

	public User findByUsername(String username);

	public User findByUsernameAndPassword(String username, String password);


}
