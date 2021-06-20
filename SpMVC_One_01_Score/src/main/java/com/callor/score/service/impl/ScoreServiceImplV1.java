package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.ScoreService;


@Service
public class ScoreServiceImplV1 implements ScoreService {

	protected final ScoreDao scDao;
	protected final StudentDao stDao;

	public ScoreServiceImplV1(StudentDao stDao, ScoreDao scDao) {

		this.stDao = stDao;
		this.scDao = scDao;

	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub

		return scDao.insert(vo);
	}

	@Override
	public ScoreVO findById(String pk) {
		// TODO Auto-generated method stub

		ScoreVO vo = scDao.findById(pk);

		return vo;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub

		return scDao.delete(pk);
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub

		return scDao.update(vo);
	}

	@Override
	public List<ScoreVO> findByNum(String num) {
		// TODO Auto-generated method stub
		
		List<ScoreVO> scList = scDao.findByNum(num);
		
		return scList;
	}

}
