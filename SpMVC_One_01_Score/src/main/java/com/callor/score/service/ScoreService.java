package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreVO;

public interface ScoreService extends GenericService<ScoreVO, String>{

	public List<ScoreVO> findByNum(String num);

	
	
}
