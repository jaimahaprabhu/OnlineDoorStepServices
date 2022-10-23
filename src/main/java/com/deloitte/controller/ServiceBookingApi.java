package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.dto.ServiceDto;
import com.deloitte.service.ServiceBookingImpl;
import com.deloitte.utils.CommonConstants;

/**
 * @author jaimahaprabhua
 *
 */
@RestController
@CrossOrigin(origins = CommonConstants.SERVER_ADDRESS)
public class ServiceBookingApi {

	@Autowired
	ServiceBookingImpl serviceBookingImpl;

	@GetMapping(CommonConstants.SERVICES)
	public ResponseEntity<List<ServiceDto>> getServices() {
		return new ResponseEntity<>(serviceBookingImpl.getServicesList(), HttpStatus.OK);
	}

}
