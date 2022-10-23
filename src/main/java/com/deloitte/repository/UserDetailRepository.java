package com.deloitte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.model.UserDetail;

@Repository
public interface UserDetailRepository
		extends
			MongoRepository<UserDetail, String> {

	@Query("{email :?0}")
	UserDetail findByEmail(String email);

}
