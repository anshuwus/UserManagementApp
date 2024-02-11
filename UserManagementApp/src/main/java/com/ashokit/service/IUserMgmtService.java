package com.ashokit.service;

import java.util.Map;

import com.ashokit.binding.LoginForm;
import com.ashokit.binding.RegistrationForm;
import com.ashokit.binding.UnlockForm;

public interface IUserMgmtService {
	
	Map<Integer,String> getCountryIdAndName();
	boolean isEmailExist(String email);
	Map<Integer,String> getStateIdAndNameBasedOnCountryId(Integer counId);
	Map<Integer,String> getCityIdAndNameBasedOnStateId(Integer stateId);
	String insertFormData(RegistrationForm form, Integer stateId, Integer cityId);
	String unlockUserAccount(UnlockForm form);
	String recoverPwd(String email);
	String login(LoginForm form);
}
