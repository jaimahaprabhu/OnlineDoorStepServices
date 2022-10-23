package com.deloitte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.dto.ServiceDto;
import com.deloitte.model.Service;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {

	public long count();

	// @Query("")
	public ServiceDto findByServiceName(String serviceName);

}
