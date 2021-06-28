package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/student")
@Controller
public class StudentController {

	protected final StudentService stService;
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS",stList);
		
		// String BODY = "STUDENT_LIST";
		// view.rendering(BODY)
		
		model.addAttribute("BODY","STUDENT_LIST");
		return "home";
	
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		
		StudentVO stVO = new StudentVO();
		stVO.setSt_num( stService.makeStNum() );
		
		model.addAttribute("BODY","STUDENT_INPUT");
		model.addAttribute("STD", stVO);
		
		return "home";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(StudentVO studentVO, Model model) {
		
		log.debug("Req 학생정보 {}", studentVO.toString());
		
		int ret = stService.insert(studentVO);
		
		model.addAttribute("BODY","STUDENT_INPUT");
		return "redirect:/student";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String st_num, Model model) {
		
//		List<SubjectAndScoreDTO> ssList = scService.selectScore(st_num);
		
//		StudentVO stVO = stService.
				
//		model.addAttribute("SSLIST",ssList);
		
		String ret = stService.detail(model,st_num);
		
		model.addAttribute("BODY","STUDENT_DETAIL");
		
		log.debug("확인 : {}", ret);
		
		return "home";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.POST)
//	public String detail(@RequestParam(name="subject") List<String> subject,
//						 @RequestParam(name="score") List<String> score) {
	
	public String detail(ScoreInputVO scInputVO, Model model) {
//		log.debug(subject.toString());
//		log.debug(score.toString());
		
		log.debug("Score Input {}", scInputVO.toString());
		
		String ret = stService.scoreInput(scInputVO);
		String st_num = scInputVO.getSt_num();
		
		/*
		 * redirect를 수행할때 query string을 보내고 싶으면
		 * 해당 변수와 값을 model에 속성(attribute)로 추가(add)하라
		 * 
		 * "redirect:/student/detail?st_num=" + st_num
		 */
		model.addAttribute("st_num", st_num);
		
		return "redirect:/student/detail";
	}
	

	
	
}