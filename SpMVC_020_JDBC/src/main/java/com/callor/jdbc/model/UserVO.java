package com.callor.jdbc.model;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

	private String mb_username;
	private String mb_password;
	private String mb_name;
	private String mb_nname;
	private String mb_email;
	private String mb_tel;
	private String mb_addr;
	
	private Boolean mb_expire;
	
}
