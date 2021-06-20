package com.callor.score.service;

import com.callor.score.model.StudentVO;

public interface StudentService extends GenericService<StudentVO, String>{

	public String findByMaxNum(String pk);
	
}
