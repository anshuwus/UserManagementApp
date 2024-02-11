package com.ashokit.binding;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UnlockForm {
	
	private String email;
	private String tempPwd;
	private String newPwd;
	private String pwd;
}
