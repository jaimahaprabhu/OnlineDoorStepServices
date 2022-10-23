package com.deloitte.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.dto.UserDto;
import com.deloitte.mapper.UserDetailMapper;
import com.deloitte.model.UserDetail;
import com.deloitte.model.UserLogin;
import com.deloitte.repository.UserDetailRepository;
import com.deloitte.repository.UserLoginRepository;
import com.deloitte.utils.CommonConstants;
import com.deloitte.utils.ServiceUtils;

/**
 * @author jaimahaprabhua
 * 
 */
@Service
@Transactional
public class ServiceProviderUserImpl implements ServiceProviderUser {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	UserDetailRepository userDetailRepository;

	@Autowired
	UserDetailMapper userDetailMapper;

	/**
	 * checking logging credentials and setting login status
	 * 
	 * @param email String
	 * @param pwd   String
	 */
	@Override
	public Optional<UserDto> getLoginStatusAndDetails(String email, String pwd) {
		if (ServiceUtils.isNotNullOrEmpty(pwd) && ServiceUtils.isNotNullOrEmpty(email)) {
			UserDetail userDetail = getUserDetailByEmail(email);
			if (ServiceUtils.isNotNullOrEmpty(userDetail)) {
				return setLogin(email, pwd, userDetail.getId()).isEmpty() ? emptyObj()
						: Optional.ofNullable(getUserDto(email));
			} else {
				return emptyObj();
			}
		} else {
			return emptyObj();
		}
	}

	/**
	 * logging out functionality by setting login status
	 * 
	 * @param email String
	 */
	@Override
	public boolean doLogOut(String email) {
		Optional<UserLogin> userData = getUserByEmail(email);
		if (userData.isPresent()) {
			saveUserLogin(userData.get(), false);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Registering a new user
	 * 
	 * @param userDto UserDto
	 */
	@Override
	public boolean setUserDetails(UserDto userDto) {
		if (ServiceUtils.isNotNullOrEmpty(userDto) && validateUser(userDto)) {
			userDetailRepository.save(getUserDetails(userDto));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * persisting and updating login status.
	 * 
	 * 
	 * @param email
	 * @param pwd
	 * @param userDetail
	 * @return
	 */
	private Optional<UserDto> setLogin(String email, String pwd, String userDetailId) {
		UserDto usDto = getUserDto(email);
		Optional<UserLogin> userLogin = getUserByEmail(email);
		if (ServiceUtils.isNotNullOrEmpty(usDto) && usDto.getPassword().equals(pwd)) {
//			if (userLogin.isPresent() && userLogin.get().isLoginStatus()) {
//				return emptyObj();
//			} else
			if (userLogin.isPresent() && !userLogin.get().isLoginStatus()) {
				saveUserLogin(userLogin.get(), true);
			} else if (!userLogin.isPresent()) {
				userLoginRepository.save(new UserLogin(email, userDetailId, true));
			}
			return Optional.ofNullable(usDto);
		} else {
			return emptyObj();
		}

	}

	/**
	 * return dto after mapping
	 * 
	 * @param email
	 * @return
	 */
	public UserDto getUserDto(String email) {
		return userDetailMapper.mapToUserDto(getUserDetailByEmail(email));
	}

	/**
	 * return dto after mapping
	 * 
	 * @param email
	 * @return
	 */
	private UserDetail getUserDetails(UserDto usDto) {
		return userDetailMapper.mapToUserDetail(usDto);
	}

	/**
	 * return UserLogin
	 * 
	 * @param email
	 * @return
	 */
	private Optional<UserLogin> getUserByEmail(String email) {
		return userLoginRepository.findByEmail(email);
	}

	/**
	 * return UserDetails
	 * 
	 * @param email
	 * @return
	 */
	private UserDetail getUserDetailByEmail(String email) {
		return userDetailRepository.findByEmail(email);
	}

	/**
	 * persist userlogin
	 * 
	 * @param email
	 * @param userDetail
	 */
	private void saveUserLogin(UserLogin usLogin, boolean isLogin) {
		usLogin.setLoginStatus(isLogin);
		userLoginRepository.save(usLogin);
	}

	/**
	 * @param userDto
	 * @return
	 */
	private boolean validateUser(UserDto userDto) {
		return (!isEmptyCheck(userDto) && String.valueOf(userDto.getContact()).length() == 10
				&& !validDob(userDto.getDob()).isEmpty());
	}

	/**
	 * @param dob
	 * @return
	 */
	private String validDob(String dob) {
		// use isEmpty instead java version < v11
		return dob.isBlank() ? CommonConstants.EMPTY_STRING
				: dob.replaceAll(CommonConstants.DOT, CommonConstants.HYPHEN);
	}

	/**
	 * @param userDto
	 * @return
	 */
	private boolean isEmptyCheck(UserDto userDto) {
		return (ServiceUtils.isNullOrEmpty(userDto.getFirstName()) || ServiceUtils.isNullOrEmpty(userDto.getLastName())
				|| ServiceUtils.isNullOrEmpty(userDto.getEmail()) || ServiceUtils.isNullOrEmpty(userDto.getGender())
				|| ServiceUtils.isNullOrEmpty(userDto.getDob()) || ServiceUtils.isNullOrEmpty(userDto.getPassword()));
	}

	private Optional<UserDto> emptyObj() {
		return Optional.ofNullable(null);
	}
}
