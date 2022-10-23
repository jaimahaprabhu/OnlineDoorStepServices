package com.deloitte.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "BookingDetail")
@Data
public class BookingDetail {

	@Id
	private String id;
	@NonNull
	private String userId;
	@NonNull
	private String serviceId;
	private String bookingStatus;
	private String serviceDate;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date serviceTime;

	public BookingDetail(@NonNull String userId, @NonNull String serviceId, String bookingStatus, String serviceDate,
			Date serviceTime) {
		super();
		this.userId = userId;
		this.serviceId = serviceId;
		this.bookingStatus = bookingStatus;
		this.serviceDate = serviceDate;
		this.serviceTime = serviceTime;
	}

}
