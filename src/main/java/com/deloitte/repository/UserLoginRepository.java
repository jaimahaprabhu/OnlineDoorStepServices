package com.deloitte.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.model.UserLogin;

@Repository
public interface UserLoginRepository extends MongoRepository<UserLogin, String> {

	@Query("{email :?0}")
	Optional<UserLogin> findByEmail(String email);

//	@Query("_id :?0")
//	Optional<UserLogin> findId(String id);

}
