package com.callor.jdbc.pesistance.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.MemberService;

@Service
public class MemberServiceImplV1 implements MemberService{

	protected final JdbcTemplate jdbcTemplate;
	
	public MemberServiceImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public UserVO login(String username, String password) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_member ";
		sql += " WHERE mb_username = ? ";
		
		Object[] params = new Object[] { username };
		
		UserVO userVO = (UserVO)jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		
		// 로그인 처리
		// 1. id가 맞는 회원인가
		if(username.equalsIgnoreCase(userVO.getName()) && password.equals(userVO.getPassword())) {
			return userVO;
		}
		
		return null;
	}

	@Override
	public int join(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO viewInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
