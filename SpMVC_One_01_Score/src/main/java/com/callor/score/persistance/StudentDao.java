package com.callor.score.persistance;

import com.callor.score.model.StudentVO;

public interface StudentDao extends GenericDao<StudentVO, String> {

	public String findByMaxNum();

	public Integer findByAll(StudentVO vo);

}
