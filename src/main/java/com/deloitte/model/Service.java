package com.deloitte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Service")
public class Service implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String serviceName;

	private String serviceDetailId;

//	@DocumentReference(lazy = true, lookup = "{'_id':?self._id}}")
//	private ServiceDetails ServiceDetails;

	public Service(String serviceName, String serviceDetailId) {
		super();
		this.serviceName = serviceName;
		this.serviceDetailId = serviceDetailId;
		// this.ServiceDetails = ServiceDetails;
	}

}
