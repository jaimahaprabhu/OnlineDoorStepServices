package com.deloitte.service;

import java.util.List;

import com.deloitte.dto.ServiceDto;
import com.deloitte.dto.UserDto;
import com.deloitte.model.BookingDetail;

public interface ServiceBooking {

	public List<ServiceDto> getServicesList();

	public String bookServiceForUser(UserDto usDto, ServiceDto serviceDto);

	public BookingDetail getUserBookings(UserDto userDto);

}
