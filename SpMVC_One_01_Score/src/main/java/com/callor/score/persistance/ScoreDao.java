package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, String>{
	
	public List<ScoreDTO> selectAll();
	public List<ScoreVO> findByNum(String num);
	
}
