package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/comp")
public class CompController {

	protected final CompDao compDao;
	protected final CompService compService;
	public CompController(CompDao compDao, CompService compService) {
		this.compDao = compDao;
		this.compService = compService;
	}
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {

		if(hSession.getAttribute("USERVO") == null) {
			model.addAttribute("MSG","LOGIN");
			return "redirect:/member/login";
		}
		
		List<CompVO> compList = compService.selectAll();
		log.debug("출판사 정보 가져오기: {} ", compList.toString());
		model.addAttribute("COMPS",compList);
		
		return "comp/list";
	}
	
	@RequestMapping(value= {"/search"}, method=RequestMethod.GET)
	public String getList(Model model) {
		List<CompVO> compList = compService.selectAll();
		model.addAttribute("COMPS", compList);
		return "comp/search";	
	}
	
	// localhost:8080/jdbc/comp/insert 로 호출되는 함수
	@RequestMapping(value="/insert", method=RequestMethod.GET) // insert GET method
	public String insert() {
		
		// WEB-INF/views/comp/input.jsp 를 열어라
		return "comp/input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST) // insert POST method
	public String insert(CompVO cmVO) { // 입력받은걸 직접 VO로 넘겨받을 수 있다?
		
		log.debug("Company VO {}", cmVO.toString());
		compService.insert(cmVO); // compService의 insert method에 cmVO를 전달해줌
									// return 받고 
		return "redirect:/"; // rootPath로 redirect를 하라
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
		
		return "comp/update";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	// 매개변수 이름은 script에 적힌 거랑 같아야하는데 바꾸고싶다! 하면 
	// @RequestParam() 사용한다.
	public String delete(@RequestParam("cp_code") String cpCode) {
		compDao.delete(cpCode);
		return "redirect:/";
	}
}