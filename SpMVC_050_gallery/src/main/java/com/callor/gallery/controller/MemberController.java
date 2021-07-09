package com.callor.gallery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
@RequiredArgsConstructor
public class MemberController {

	protected final MemberService memService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY", "JOIN");
		
		return "home";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, MemberVO memberVO) {
		
		log.debug("회원가입 정보 {}", memberVO.toString());
		memService.join(memberVO);
		model.addAttribute("BODY", "JOIN");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/id_check", method=RequestMethod.GET)
	public String id_check(String m_userid) {
		
		MemberVO memberVO = memService.findById(m_userid);
		
		if(memberVO == null) {
			return "NOT_USE_ID";
			
		} else {
			
			return "USE_ID";
		}
		
	}
	
	// 메뉴에서 로그인을 클릭했을 때 
	@RequestMapping(value="/login/{url}")
	public String login(@PathVariable("url") String url) {
		
		
		
		return "redirect:/member/login?url=login";
	}
	
	// 다른 곳에서 redirect 했을 때
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(name="url", required = false, defaultValue = "NONE") String url, Model model) {
		
		if(url.equals("NONE")) {
			model.addAttribute("LOGIN_FAIL","LOGIN_REQ");
		}
		
		model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, MemberVO memberVO, HttpSession hSession) {
		
		memberVO = memService.login(memberVO, model);
		if(memberVO == null) {
			model.addAttribute("BODY","LOGIN");
			return "home";
		} else {
			
			hSession.setAttribute("MEMBER", memberVO);
			hSession.setAttribute("USERID", memberVO.getM_userid());
			
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("MEMBER");
		return "redirect:/";
	
	}
	
}
