package com.deloitte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "UserDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

	@Id
	private String id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String email;
	private long contact;
	private String gender;
	private String dob;
	private String password;
	private boolean isServiceProvider;
	private String address;
	private String location;
}
