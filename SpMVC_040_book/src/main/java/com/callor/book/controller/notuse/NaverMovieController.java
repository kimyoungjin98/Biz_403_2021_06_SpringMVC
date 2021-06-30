package com.callor.book.controller.notuse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
//@RequestMapping(value="/movie")
//@Controller
public class NaverMovieController {

	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(String search, Model model) throws MalformedURLException, IOException {
		
//		model.addAttribute("pHolder", "영화 검색어");
		model.addAttribute("CAT", "MOVIE");
	
		return "home";
	}
	
}
