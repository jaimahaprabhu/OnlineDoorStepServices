package com.deloitte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "UserLogin")
@Data
@NoArgsConstructor
public class UserLogin {

	@Id
	private String id;
	@NonNull
	private String email;
	@NonNull
	private String userDetailId;
	private boolean loginStatus;

	public UserLogin(@NonNull String email, @NonNull String userDetailId, boolean loginStatus) {
		super();
		this.email = email;
		this.userDetailId = userDetailId;
		this.loginStatus = loginStatus;
	}

}
