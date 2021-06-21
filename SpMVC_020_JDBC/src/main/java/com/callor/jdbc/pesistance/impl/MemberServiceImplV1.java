package com.callor.jdbc.pesistance.impl;

import java.util.List;

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
		
		UserVO userVO = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		
		System.out.println(userVO.toString());
		
		// 로그인 처리
		// 1. id가 맞는 회원인가
//		for(int i = 0 ; i < userVO.size() ; i ++) {
//			if(username.equalsIgnoreCase(userVO.get(i).getName()) && password.equals(userVO.get(i).getPassword())) {
//				return userVO.get(0);
//			}
//		}
		
		if(username.equalsIgnoreCase(userVO.getMb_username()) && password.equals(userVO.getMb_password())) {
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
