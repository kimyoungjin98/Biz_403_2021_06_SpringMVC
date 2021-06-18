package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("scoreDao")
@Service
public class ScoreDaoImplV1 implements ScoreDao{
	
	protected final JdbcTemplate jdbcTemplate;
	
	public ScoreDaoImplV1(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
		
		
	}

	@Override
	public List<ScoreDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_성적정보 ";
		
		List<ScoreDTO> sList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ScoreDTO>(ScoreDTO.class));  
		log.debug(" SELECT {}", sList.toString());
		
		return sList;
	}
	
	@Override
	public List<ScoreVO> select() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		
		List<ScoreVO> scoreList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));  
		log.debug(" SELECT {}", scoreList.toString());
		
		return scoreList;
	}

	@Override
	public ScoreVO findById(String num) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_stnum = ? "; 
		
		Object[] params = new Object[] { num };
		
		ScoreVO vo = (ScoreVO)jdbcTemplate.query(sql, params , new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		
		return vo;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_score(sc_stnum, sc_subject, sc_score) ";
		sql += " VALUES(?,?,?) ";
		
		Object[] params = new Object[]
				{
						vo.getSc_stnum(), vo.getSc_subject(), vo.getSc_score()
				};
		
		
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_score SET";
		sql += " sc_stnum = ? ";
		sql += " sc_subject = ? ";
		sql += " sc_score = ? ";
		
		
		Object[] params = new Object[]
				{
						vo.getSc_stnum(), vo.getSc_subject(), vo.getSc_score()
				};
		
		
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		String sql = " DELETE FROM tbl_score ";
		sql += " WHERE sc_seq = ? ";
		
		Integer sc_seq = Integer.valueOf(pk);
		
		Object params = new Object[] {sc_seq };
		
		
		return jdbcTemplate.update(sql, sc_seq);
	}

	@Override
	public List<ScoreVO> findByNum(String num) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		
		Object[] params = new Object[] {num};
		
		List<ScoreVO> scList = jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));

		return scList;
	}

	

}
