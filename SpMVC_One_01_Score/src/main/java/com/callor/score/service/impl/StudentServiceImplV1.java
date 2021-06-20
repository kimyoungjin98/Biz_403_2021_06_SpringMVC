package com.callor.score.service.impl;

import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{
	
	protected final ScoreDao scDao;
	protected final StudentDao stDao;
	
	public StudentServiceImplV1(StudentDao stDao, ScoreDao scDao) {
		
		this.stDao = stDao;
		this.scDao = scDao;
	}
	

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		
		String st_num = stDao.findByMaxNum();
		Integer num = Integer.valueOf(st_num);

		if (st_num == null || st_num.equals("")) {

			st_num = "20210001";

		} else {

			st_num = String.format("2021%04d", num + 1);
		}
		vo.setSt_num(st_num);
		
		Integer result = stDao.findByAll(vo);
		if(result != null) {
			return 0;
		}
		
		return stDao.insert(vo);
	}

	@Override
	public StudentVO findById(String pk) {
		// TODO Auto-generated method stub
		
		StudentVO vo = stDao.findById(pk);
		
		return vo;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		ScoreVO vo = scDao.findById(pk);
		if(vo != null) {
			return 0;
		}
		
		
		return stDao.delete(pk);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		
		return stDao.update(vo);
	}

	@Override
	public String findByMaxNum(String pk) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	
	
}
