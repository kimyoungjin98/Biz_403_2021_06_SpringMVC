package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverBookService;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("naverMainServiceV1")
public class NaverMainServiceImpl {
	
	@Qualifier("naverBookServiceV2")
	protected final NaverBookService nBookService;
	
	@Qualifier("naverMovieServiceV1")
	protected final NaverMovieService mService;

	public void naverGetData(String cat, String search,Model model) throws MalformedURLException, IOException {
		
		if(search != null && !search.equals("")) {
			if(cat.equalsIgnoreCase("BOOK")) {
				// 도서 검색 서비스
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS",books);
			}else if(cat.equalsIgnoreCase("MOVIE")) {
				// 영화 검색 서비스
				String queryURL = mService.queryURL(search);
				String jSonString = mService.getJsonString(queryURL);
				List<MovieDTO> movies = mService.getNaverList(jSonString);
				model.addAttribute("MOVIES",movies);
			}else if(cat.equalsIgnoreCase("NEWS")) {
				// 뉴스 검색 서비스
			}
		}
		
	}
	
}
