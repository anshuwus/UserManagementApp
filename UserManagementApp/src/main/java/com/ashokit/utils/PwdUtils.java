package com.ashokit.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PwdUtils {
	
	public static String generatePwd() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random( 8, characters );
		return pwd;
	}
}
