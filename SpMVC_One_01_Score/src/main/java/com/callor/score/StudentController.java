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
import com.callor.score.service.listService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	protected final StudentService stService;
	protected final ScoreService scService;
	protected final listService list;

	public StudentController(ScoreService scService,StudentService stService, listService list) {
		this.scService = scService;
		this.stService = stService;
		this.list = list;
		
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String select(Model model) {
		
		List<StudentVO> stList = list.selectVO();
		model.addAttribute("STLIST",stList);
		
		
		return "stList";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "stInsert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
			@RequestParam("name") String name,
			@RequestParam("dept") String dept,
			@RequestParam("grade") Integer grade,
			@RequestParam("tel") String tel,
			@RequestParam("addr") String addr
			
			) {
		
		
		StudentVO stVO = new StudentVO();
		stVO.setSt_addr(addr);
		stVO.setSt_dept(dept);
		stVO.setSt_grade(grade);
		stVO.setSt_name(name);
		stVO.setSt_tel(tel);
		
		
		int result = stService.insert(stVO);
		if(result == 0) {
			return "redirect:/";
		}
		
		
		
		return "redirect:/student";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("num") String num, Model model) {
		
		StudentVO stVO = stService.findById(num);
		model.addAttribute("ST",stVO);
		
		
		return "stupdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(
						@RequestParam("num") String num,
						@RequestParam("name") String name,
						@RequestParam("dept") String dept,
						@RequestParam("grade") Integer grade,
						@RequestParam("tel") String tel,
						@RequestParam("addr") String addr
						
						) {
		
		StudentVO stVO = new StudentVO();
		stVO.setSt_addr(addr);
		stVO.setSt_dept(dept);
		stVO.setSt_grade(grade);
		stVO.setSt_name(name);
		stVO.setSt_num(num);
		stVO.setSt_tel(tel);
		
		stService.update(stVO);
		
		return "redirect:/info?num="+num;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("num") String num,
			 			@RequestParam(name="MSG" ,required = false) String msg,
							Model model) {
		
		
		int result = stService.delete(num);
		if(result == 0) {
			
			model.addAttribute("MSG", "error");
			
			return "redirect:/student";
		}

		
		return "redirect:/";
	}
	

}
