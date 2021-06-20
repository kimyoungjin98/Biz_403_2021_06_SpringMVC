package com.callor.score;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.listService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	
	protected final listService list;
	
	public HomeController(listService list) {
		this.list = list;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<ScoreDTO> sList = list.selectDTO();
		model.addAttribute("sList" , sList);
		
		return "home";
	}
	
}
