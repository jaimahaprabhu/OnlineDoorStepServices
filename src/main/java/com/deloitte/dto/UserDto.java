package com.deloitte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jaimahaprabhua
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@JsonProperty("")
	private String id;
	@JsonProperty("")
	private String firstName;
	@JsonProperty("")
	private String lastName;
	@JsonProperty("")
	private String email;
	@JsonProperty("")
	private String password;
	@JsonProperty("")
	private long contact;
	@JsonProperty("")
	private String gender;
	@JsonProperty("")
	private String dob;
	@JsonProperty("")
	private boolean isServiceProvider;
	@JsonProperty("")
	private String address;
	@JsonProperty("")
	private String location;

}
