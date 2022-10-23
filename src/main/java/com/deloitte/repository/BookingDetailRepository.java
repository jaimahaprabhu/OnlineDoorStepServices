package com.deloitte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.BookingDetail;

@Repository
public interface BookingDetailRepository
		extends
			MongoRepository<BookingDetail, String> {

}
