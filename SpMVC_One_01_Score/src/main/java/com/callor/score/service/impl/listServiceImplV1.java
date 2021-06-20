package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.listService;

@Service
public class listServiceImplV1 implements listService{
	
	protected final ScoreDao scDao;
	protected final StudentDao stDao;
	
	public listServiceImplV1(StudentDao stDao, ScoreDao scDao) {
		
		this.stDao = stDao;
		this.scDao = scDao;
		
	}
	

	@Override
	public List<ScoreDTO> selectDTO() {
		// TODO Auto-generated method stub
		
		List<ScoreDTO> list =  scDao.selectAll();
		
		return list;
	}

	@Override
	public List<StudentVO> selectVO() {
		// TODO Auto-generated method stub
		
		List<StudentVO> stList = stDao.select();
		
		return stList;
	}

}
