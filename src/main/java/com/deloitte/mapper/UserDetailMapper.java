package com.deloitte.mapper;

import org.springframework.stereotype.Component;

import com.deloitte.dto.UserDto;
import com.deloitte.model.UserDetail;

/**
 * @author jaimahaprabhua
 *
 */
@Component
public class UserDetailMapper {

	/**
	 * @param userDetail
	 * @return
	 */
	public UserDto mapToUserDto(UserDetail userDetail) {
		return new UserDto(userDetail.getId(), userDetail.getFirstName(), userDetail.getLastName(),
				userDetail.getEmail(), userDetail.getPassword(), userDetail.getContact(), userDetail.getGender(),
				userDetail.getDob(), userDetail.isServiceProvider(), userDetail.getAddress(), userDetail.getLocation());
	}

	/**
	 * @param userDto
	 * @return
	 */
	public UserDetail mapToUserDetail(UserDto userDto) {
		return new UserDetail(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
				userDto.getContact(), userDto.getGender(), userDto.getDob(), userDto.getPassword(),
				userDto.isServiceProvider(), userDto.getAddress(), userDto.getLocation());
	}
}
