package com.callor.book.service.impl.news;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;

@Service(NaverQualifier.NAVER_NEWS_SERVICE_V1)
public class NaverNewsServiceImplV1 extends NaverAbstractService<NewsDTO>{

	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		
		String queryURL = NaverSecret.NURL.NEWS;
		queryURL += "?query=%s&display=10";
		
		String searchUTF = URLEncoder.encode(search, "UTF-8");
		queryURL = String.format(queryURL, searchUTF);
		
		return queryURL;
	}

	@Override
	public List<NewsDTO> getNaverList(String jsonString) {
		
		
		
		return null;
	}

	
	
}
