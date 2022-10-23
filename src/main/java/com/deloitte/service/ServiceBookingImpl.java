package com.deloitte.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.dto.ServiceDto;
import com.deloitte.dto.UserDto;
import com.deloitte.mapper.ServiceDetailMapper;
import com.deloitte.model.BookingDetail;
import com.deloitte.repository.BookingDetailRepository;
import com.deloitte.repository.ServiceDetailRepository;
import com.deloitte.repository.ServiceRepository;
import com.deloitte.utils.BookingStatus;
import com.deloitte.utils.CommonConstants;
import com.deloitte.utils.ServiceUtils;

@Service
@Transactional
public class ServiceBookingImpl implements ServiceBooking {

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ServiceDetailMapper serviceDetailMapper;

	@Autowired
	ServiceDetailRepository serviceDetailRepo;

	@Autowired
	BookingDetailRepository bookingDetailRepository;

	/**
	 * returns services list
	 */
	@Override
	public List<ServiceDto> getServicesList() {

		List<ServiceDto> servicesList = new ArrayList<>();
		serviceRepository.findAll().stream().forEach(service -> servicesList.add(serviceDetailMapper
				.mapToServiceDto(service, serviceDetailRepo.findById(service.getServiceDetailId()))));
		return servicesList;
	}

	/**
	 * persist Booking Detail
	 */
	@Override
	public String bookServiceForUser(UserDto usDto, ServiceDto serviceDto) {
		if (ServiceUtils.isNotNullOrEmpty(usDto) && ServiceUtils.isNotNullOrEmpty(usDto.getId())
				&& ServiceUtils.isNotNullOrEmpty(serviceDto) && ServiceUtils.isNotNullOrEmpty(serviceDto.getId())) {
			Date currentDate = Date.from(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault())
					.atZone(ZoneId.systemDefault()).toInstant());
			DateFormat dateFormat = new SimpleDateFormat(CommonConstants.dateFormat);
			return bookingDetailRepository.save(new BookingDetail(usDto.getId(), serviceDto.getId(),
					BookingStatus.BOOKED.toString(), dateFormat.format(currentDate), currentDate)).getId();
		} else {
			return "";
		}

	}

	@Override
	public BookingDetail getUserBookings(UserDto userDto) {

		return null;
	}

}
