package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.AuthorDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("authorDaoV1")
public class AuthorDaoImplV1 implements AuthorDao {

	/*
	 * 일반적인 Spring Framework에서 다른 bean을 연결하기
	 * 
	 * @Autowired는 이미 bean으로 생성되어 Spring Container에 보관중인 객체를 여기에 주입해 달라
	 * 
	 * @Inject Java에서 기본적으로 제공하는 DI(Dependency Inject)를 수행하는 Annotation
	 * 일부에서 @Inject를 사용하자라는 말이 있지만 SpringFrameword를 사용할때는 굳이 그러지 말자 !!
	 */

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_author ";

		List<AuthorVO> authorList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		log.debug("SELECT {}", authorList.toString());
		return authorList;
	}

	@Override
	public AuthorVO findById(String au_code) {
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_code = ? ";

		AuthorVO authorVO = (AuthorVO)jdbcTemplate.query(sql, new Object[] {au_code},new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		log.debug("SELECT {}", authorVO.toString());
		
		return authorVO;
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String aname) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_name LIKE CONCAT('%', ? , '%')";

		List<AuthorVO> authorList = jdbcTemplate.query(sql, new Object[] {aname} ,new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		log.debug("SELECT {}", authorList.toString());
		
		
		return authorList;
	}

	@Override
	public List<AuthorVO> findByATel(String atel) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_tel = ? ";

		// DB 조회는 PK를 기준으로 조회하는 경우를 제외하고 모두 List type으로 데이터가 추출된다고 생각해야 한다 
		List<AuthorVO> authorList = jdbcTemplate.query(sql, new Object[] {atel} ,new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		log.debug("SELECT {}", authorList.toString());
		
		
		return authorList;
		
	}

}
