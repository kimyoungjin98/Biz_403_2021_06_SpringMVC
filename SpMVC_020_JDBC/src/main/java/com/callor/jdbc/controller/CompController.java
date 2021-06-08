package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/comp")
public class CompController {
	
	protected final CompDao compDao;
	
	public CompController(CompDao compDao) {
		
		this.compDao = compDao;
		
	}

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		
		
		// Web-INF/views/comp/input.jsp 열어라
		return "comp/input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CompVO cmVO) {
		
		log.debug("CompanyVO {}", cmVO.toString());
		compDao.insert(cmVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update() {
		
		return "comp/input";
	}
	
}
