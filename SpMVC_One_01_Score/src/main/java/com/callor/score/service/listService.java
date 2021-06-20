package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;

public interface listService {

	public List<ScoreDTO> selectDTO();
	public List<StudentVO> selectVO();
	
}
