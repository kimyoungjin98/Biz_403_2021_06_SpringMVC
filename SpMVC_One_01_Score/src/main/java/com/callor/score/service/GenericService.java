package com.callor.score.service;

public interface GenericService<VO, PK> {

	public int insert(VO vo);
	public VO findById(String pk);
	public int delete(String pk);
	public int update(VO vo);
	
}
