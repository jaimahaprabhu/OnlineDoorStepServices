package com.deloitte.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.deloitte.dto.ServiceDto;
import com.deloitte.model.Service;
import com.deloitte.model.ServiceDetails;

/**
 * @author jaimahaprabhua
 *
 */
@Component
public class ServiceDetailMapper {

	public ServiceDto mapToServiceDto(Service service, Optional<ServiceDetails> serviceDetail) {
		if (serviceDetail.isPresent()) {
			return new ServiceDto(service.getServiceName(), serviceDetail.get().getFare(),
					serviceDetail.get().getPkgTime());
		}
		return new ServiceDto(service.getServiceName());
	}

}
