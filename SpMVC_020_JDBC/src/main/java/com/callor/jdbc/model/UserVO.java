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

	private String username;
	private String password;
	private String name;
	private String nname;
	private String email;
	private String tel;
	private String addr;
	
	private Boolean expire;
	
}
