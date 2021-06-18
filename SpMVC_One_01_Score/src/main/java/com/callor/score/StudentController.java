package com.callor.score;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	protected final StudentDao stDao;
	
	public StudentController(StudentDao stDao) {
		this.stDao = stDao;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("num") String num) {
		
		StudentVO stVO = stDao.findById(num);
		
		
		return "stupdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update() {
		
		
		
		return "stupdate";
	}

}
