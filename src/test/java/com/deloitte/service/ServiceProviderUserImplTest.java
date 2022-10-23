package com.deloitte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deloitte.dto.UserDto;
import com.deloitte.mapper.UserDetailMapper;
import com.deloitte.model.UserDetail;
import com.deloitte.model.UserLogin;
import com.deloitte.repository.UserDetailRepository;
import com.deloitte.repository.UserLoginRepository;

@ExtendWith(MockitoExtension.class)
class ServiceProviderUserImplTest {

	@Mock
	UserLoginRepository userLoginRepository;

	@Mock
	UserDetailRepository userDetailRepository;

	@Mock
	UserDetailMapper userDetailMapper;

	@InjectMocks
	ServiceProviderUserImpl serviceProviderUserImpl;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(serviceProviderUserImpl);
	}

	private UserDto getUserDto() {
		return new UserDto("123", "jm", "a", "abc@gm.com", "pwd", 9003318386l, "Male", "12-09-2022", true, "address",
				"location");
	}

	private Optional<UserLogin> getUsrLogin() {
		return Optional.of(new UserLogin("abc@gm.com", "125", false));
	}

	private UserDetail getUserDetail() {
		return new UserDetail("123", "jm", "a", "abc@gm.com", 9003318386l, "Male", "12-09-2022", "pwd", true, "address",
				"location");
	}

	@Test
	void getLoginStatusAndDetailsEmptTest() {
		assertEquals(Optional.empty(), serviceProviderUserImpl.getLoginStatusAndDetails("abc", ""));
	}

	@Test
	void getLoginStatusAndDetailsEmptyTest() {

		when(userDetailRepository.findByEmail(Mockito.anyString())).thenReturn(null);
		assertEquals(Optional.empty(), serviceProviderUserImpl.getLoginStatusAndDetails("abc", "kn"));
	}

	@Test
	void getLoginStatusAndDetailsAlreadyLoginTest() {
		Optional<UserLogin> usOpt = Optional.of(new UserLogin("abc@gm.com", "125", true));
		when(userDetailRepository.findByEmail(Mockito.anyString())).thenReturn(new UserDetail("123", "jm", "a",
				"abc@gm.com", 9003318386l, "Male", "12-09-2022", "pwd", true, "address", "location"));
		when(userLoginRepository.findByEmail(Mockito.anyString())).thenReturn(usOpt);
		when(userDetailMapper.mapToUserDto(Mockito.any())).thenReturn(getUserDto());
		assertEquals(Optional.of(getUserDto()), serviceProviderUserImpl.getLoginStatusAndDetails("jm", "pwd"));

	}

	@Test
	void getLoginStatusAndDetailsNewLogTest() {
		when(userDetailRepository.findByEmail(Mockito.anyString())).thenReturn(getUserDetail());
		when(userLoginRepository.findByEmail(Mockito.anyString())).thenReturn(getUsrLogin());
		when(userDetailMapper.mapToUserDto(Mockito.any())).thenReturn(getUserDto());
		assertEquals(Optional.of(getUserDto()), serviceProviderUserImpl.getLoginStatusAndDetails("jm", "pwd"));

	}

	@Test
	void getLoginStatusAndDetailsSuccessLoginTest() {
		when(userDetailRepository.findByEmail(Mockito.anyString())).thenReturn(getUserDetail());
		when(userLoginRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
		when(userDetailMapper.mapToUserDto(Mockito.any())).thenReturn(getUserDto());
		assertEquals(Optional.of(getUserDto()), serviceProviderUserImpl.getLoginStatusAndDetails("jm", "pwd"));

	}

	@Test
	void doLogoutTest() {
		when(userLoginRepository.findByEmail(Mockito.anyString())).thenReturn(getUsrLogin());
		when(userLoginRepository.save(Mockito.any())).thenReturn(new UserLogin());
		assertTrue(serviceProviderUserImpl.doLogOut("abc@gm.com"));
	}

	@Test
	void doLogoutFailTest() {
		when(userLoginRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
		assertFalse(serviceProviderUserImpl.doLogOut("abc@gm.com"));
	}

	@Test
	void setUserDetailsFailTest() {

		assertFalse(serviceProviderUserImpl.setUserDetails(new UserDto()));
	}

	@Test
	void setUserDetailsSuccessTest() {
		when(userDetailMapper.mapToUserDetail(Mockito.any())).thenReturn(new UserDetail("123", "jm", "a", "abc@gm.com",
				9003318386l, "Male", "12-09-2022", "pwd", false, "add", "loc"));
		assertTrue(serviceProviderUserImpl.setUserDetails(new UserDto("123", "jm", "a", "abc@gm.com", "pwd",
				9003318386l, "Male", "12-09-2022", false, "Loc", "add")));
	}
}
