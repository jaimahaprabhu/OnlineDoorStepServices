package com.deloitte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "ServiceDetail")
@Data
public class ServiceDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@NonNull
	private Double fare;
	private int pkgTime;

	public ServiceDetails(@NonNull Double fare, int pkgTime) {
		super();
		this.fare = fare;
		this.pkgTime = pkgTime;
	}

}
