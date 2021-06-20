package com.callor.score;

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

@RequestMapping("/score")
@Controller
public class ScoreController {
	
	protected final StudentService stService;
	protected final ScoreService scService;

	public ScoreController(ScoreService scService,StudentService stService) {
		this.scService = scService;
		this.stService = stService;
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@RequestParam("num") String num, Model model) {
		
		StudentVO stVO = stService.findById(num);
		model.addAttribute("ST",stVO);
		
		return "scinsert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
						@RequestParam("sub") String subject,
						@RequestParam("score") Integer score,
						@RequestParam("num") String num
			) {
		
		ScoreVO scVO = new ScoreVO();
		scVO.setSc_score(score);
		scVO.setSc_stnum(num);
		scVO.setSc_subject(subject);
		
		scService.insert(scVO);
		
		
		return "redirect:/info?num="+num;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("seq") String seq, Model model) {
		
		scService.delete(seq);
		
		return "redirect:/";
	}
	
	
	
	
}
