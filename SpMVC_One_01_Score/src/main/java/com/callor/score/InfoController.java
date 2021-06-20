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
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

@Controller
public class InfoController {
	
	protected final StudentService stService;
	protected final ScoreService scService;

	public InfoController(ScoreService scService,StudentService stService) {
		this.scService = scService;
		this.stService = stService;
		
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String info(@RequestParam("num") String num, 
						Model model) {
		
		
		
		StudentVO stVO = stService.findById(num);
		List<ScoreVO> scList = scService.findByNum(num);
		
		model.addAttribute("SCLIST", scList);
		model.addAttribute("ST", stVO);
		
		return "info";
	}

	
}
