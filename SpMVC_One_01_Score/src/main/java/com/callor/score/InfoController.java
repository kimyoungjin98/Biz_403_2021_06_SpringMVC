package com.callor.score;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.StudentDao;

@Controller
public class InfoController {
	
	protected final StudentDao stDao;
	protected final ScoreDao scDao;

	public InfoController(StudentDao stDao, ScoreDao scDao) {
		this.stDao = stDao;
		this.scDao = scDao;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String info(@RequestParam("num") String num, Model model) {
		
		StudentVO stVO = stDao.findById(num);
		List<ScoreVO> scList = scDao.findByNum(num);
		
		model.addAttribute("SCLIST", scList);
		model.addAttribute("ST", stVO);
		
		return "info";
	}

	
}
