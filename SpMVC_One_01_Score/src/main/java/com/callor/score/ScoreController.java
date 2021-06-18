package com.callor.score;

import org.springframework.stereotype.Controller;

import com.callor.score.persistance.ScoreDao;

@Controller
public class ScoreController {
	
	protected final ScoreDao scoreDao;

	public ScoreController(ScoreDao scoreDao) {
	
		this.scoreDao = scoreDao;
		
	}
	
	
}
