package com.deloitte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author jaimahaprabhua
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ServiceDto {

	@JsonProperty("")
	private String id;
	@JsonProperty("")
	private String serviceName;
	@JsonProperty("")
	private String serviceDetailId;
	@JsonProperty("")
	private Double fare;
	@JsonProperty("")
	private int pkg;

	public ServiceDto(String serviceName) {
		super();
		this.serviceName = serviceName;
	}

	public ServiceDto(String serviceName, Double fare, int pkgTime) {
		super();
		this.serviceName = serviceName;
		this.fare = fare;
		this.pkg = pkgTime;
	}

}