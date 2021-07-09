package com.callor.gallery.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Qualifier("galleryServiceV2")
	protected final GalleryService gService;
	
	@RequestMapping(value="/dumy", method=RequestMethod.GET)
	public String dumy() {
		
		return "home";
	}

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		List<GalleryDTO> gaList = gService.selectAll();
		
		model.addAttribute("GALLERYS", gaList);
		model.addAttribute("BODY","GA-LIST");
		
		return "home";
	}
	
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(Model model, HttpSession session) {
		
		MemberVO mVO = (MemberVO) session.getAttribute("MEMBER");
		if(mVO == null) {
			return "redirect:/member/login";
		}
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		GalleryDTO gaDTO = GalleryDTO.builder()
					.g_date(curDate)
					.g_time(curTime)
					.g_writer("gyu250")
					.build();
				
		
		
		model.addAttribute("CMD", gaDTO);
		model.addAttribute("BODY", "GA-INPUT");
		
		return "home";
	}
	
	@RequestMapping(value="/input" ,method=RequestMethod.POST)
	public String input(GalleryDTO gaDTO, Model model,
						MultipartFile one_file,
						MultipartHttpServletRequest m_file
						) throws IOException {
		log.debug("갤러리 정보 {}", gaDTO.toString());
		
		gService.input(gaDTO, one_file, m_file);
		
		return "redirect:/gallery";
	}
	
//	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
//	public String detail(@PathVariable("seq") String seq, Model model) {
//		Long g_seq = 0L;
//		
//		try {
//			g_seq = Long.valueOf(seq);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			return "redirect:/gallery";
//		}
//		
//		List<GalleryFilesDTO> gfList = gService.findByGalleryFiles(g_seq);
//		model.addAttribute("GFLIST",gfList);
//		model.addAttribute("BODY","GA-DETAIL");
//		
//		return "home";
//	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model, HttpSession session) {
		
		Long g_seq = 0L;
		
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
			log.debug("갤러리 ID값 오류");
			return "redirect:/";
		}
		
		GalleryDTO galleryDTO = gService.findByGallery(g_seq);
		
		model.addAttribute("GALLERY", galleryDTO);
		model.addAttribute("BODY", "GA-DETAIL-V2");
		return "home";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("g_seq") String seq, HttpSession session) {
		
		// 삭제를 요구하면
		// 1. 로그인이 되었나 확인
		MemberVO memVO = (MemberVO)session.getAttribute("MEMBER");
		if(memVO == null) {
			return "redirect:/member/login";
		}
		Long g_seq = 0L;
		
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "redirect:/gallery";
		}
		
		int ret = gService.delete(g_seq);
		
		return "redirect:/gallery";
	}
	
}

