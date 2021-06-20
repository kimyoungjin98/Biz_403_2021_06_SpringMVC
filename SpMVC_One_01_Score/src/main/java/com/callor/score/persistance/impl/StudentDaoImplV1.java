package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("studentDao")
@Service
public class StudentDaoImplV1 implements StudentDao {

	protected final JdbcTemplate jdbcTemplate;

	public StudentDaoImplV1(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public List<StudentVO> select() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_student ";

		List<StudentVO> stList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));

		return stList;
	}

	@Override
	public StudentVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_num = ? ";

		Object[] params = new Object[] { pk };

//		StudentVO vo = (StudentVO)jdbcTemplate.queryForObject(sql,params, StudentVO.class);
		List<StudentVO> vo = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));

		System.out.println(vo.toString());
		return vo.get(0);
//		return vo;

	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_student ";
		sql += " (st_num, st_name, st_dept, st_grade, st_tel, st_addr)";
		sql += " VALUES(?,?,?,?,?,?) ";

		Object[] params = new Object[] {

				vo.getSt_num(), vo.getSt_name(), vo.getSt_dept(), vo.getSt_grade(), vo.getSt_tel(), vo.getSt_addr() };

		System.out.println(vo.toString());

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_student SET ";
		sql += " st_name = ?, ";
		sql += " st_dept = ?, ";
		sql += " st_grade = ?, ";
		sql += " st_tel = ?, ";
		sql += " st_addr = ? ";
		sql += " WHERE st_num = ? ";

		Object[] params = new Object[] {

				vo.getSt_name(), vo.getSt_dept(), vo.getSt_grade(), vo.getSt_tel(), vo.getSt_addr(), vo.getSt_num() };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		String sql = " DELETE FROM tbl_student ";
		sql += " WHERE st_num = ? ";

		Object[] params = new Object[] { pk };

		return jdbcTemplate.update(sql, params);
	}

	public String findByMaxNum() {

		String sql = " SELECT MAX(st_num) FROM tbl_student ";

		String num = jdbcTemplate.queryForObject(sql, String.class);
		String st_num = num.substring(4);

		return st_num;
	}

	@Override
	public Integer findByAll(StudentVO vo) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_name = ? && st_dept = ? && st_grade = ? && st_tel = ? && st_addr = ? ";
		
		Object[] params = new Object[] {

				vo.getSt_name(), vo.getSt_dept(), vo.getSt_grade(), vo.getSt_tel(), vo.getSt_addr() };
		
		List<StudentVO> stList = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		
		if(stList.size() > 0) {
			return 1;
		}
		
		return null;
	}

}
