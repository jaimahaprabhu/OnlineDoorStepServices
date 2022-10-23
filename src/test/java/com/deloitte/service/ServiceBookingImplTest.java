package com.deloitte.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deloitte.dto.ServiceDto;
import com.deloitte.mapper.ServiceDetailMapper;
import com.deloitte.model.Service;
import com.deloitte.model.ServiceDetails;
import com.deloitte.repository.ServiceDetailRepository;
import com.deloitte.repository.ServiceRepository;

@ExtendWith(MockitoExtension.class)
class ServiceBookingImplTest {

	@Mock
	ServiceRepository serviceRepository;

	@InjectMocks
	ServiceBookingImpl serviceBookingImpl;

	@Mock
	ServiceDetailMapper serviceDetailMapper;

	@Mock
	ServiceDetailRepository serviceDetailRepo;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(serviceBookingImpl);
	}

	@Test
	void getServicesListTest() {
		when(serviceRepository.findAll()).thenReturn(mockServiceFactory());
		when(serviceDetailRepo.findById(Mockito.anyString())).thenReturn(Optional.of(new ServiceDetails(100.0, 2)));
		when(serviceDetailMapper.mapToServiceDto(Mockito.any(), Mockito.any()))
				.thenReturn(new ServiceDto("Salon", 100.0, 12));
//		List<ServiceDto> servicesList = new ArrayList<>();
//		servicesList.add(new ServiceDto("Salon", "id"));
		assertThat(serviceBookingImpl.getServicesList()).contains(new ServiceDto("Salon", 100.0, 12));
		verify(serviceRepository, times(1)).findAll();

	}

	@Test
	void getServicesListEmptyTest() {
		when(serviceRepository.findAll()).thenReturn(mockServiceFactory());
		when(serviceDetailRepo.findById(Mockito.anyString())).thenReturn(Optional.empty());
		when(serviceDetailMapper.mapToServiceDto(Mockito.any(), Mockito.any())).thenReturn(new ServiceDto("Salon"));
//		List<ServiceDto> servicesList = new ArrayList<>();
//		servicesList.add(new ServiceDto("Salon", "id"));
		assertThat(serviceBookingImpl.getServicesList()).contains(new ServiceDto("Salon"));
		verify(serviceRepository, times(1)).findAll();

	}

	public List<Service> mockServiceFactory() {
		List<Service> serviceList = new ArrayList<>();
		Service service = new Service("plumbing", "servDetlId1");
		serviceList.add(service);
		return serviceList;
	}

}
