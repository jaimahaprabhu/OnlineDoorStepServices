package com.deloitte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.ServiceDetails;

@Repository
public interface ServiceDetailRepository
		extends
			MongoRepository<ServiceDetails, String> {

}
