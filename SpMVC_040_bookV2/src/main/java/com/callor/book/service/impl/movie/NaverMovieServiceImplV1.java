package com.callor.book.service.impl.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
public class NaverMovieServiceImplV1 extends NaverAbstractService<MovieDTO>{

	@Override
	public String queryURL(String search_text) throws UnsupportedEncodingException {

		String searchUTF8 = null;

		
		searchUTF8 = URLEncoder.encode(search_text, "UTF-8");
		

		String queryURL = NaverSecret.NURL.MOVIE;
		
//		String queryString = String.format("?query=%s", searchUTF8);
//		queryString += String.format("&display=%d", 10);
//		queryURL += queryString;
		
		queryURL += "?query=%s&display=10";
		queryURL = String.format(queryURL, searchUTF8);

		log.debug("url {} ", queryURL);

		return queryURL;
	}

	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {

		log.debug("치키챠 {}", jsonString);

		JSONParser jParser = new JSONParser();

		
			JSONObject jOb = (JSONObject) jParser.parse(jsonString);
			JSONArray items = (JSONArray) jOb.get("items");

			List<MovieDTO> mList = new ArrayList<MovieDTO>();

			int nSize = items.size();

			for (int i = 0; i < nSize; i++) {

				JSONObject item = (JSONObject) items.get(i);

				String title = (String) item.get("title");// string 검색 결과 영화의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
				String link = (String) item.get("link");// string 검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
				String image = (String) item.get("image");// string 검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
				String subtitle = (String) item.get("subtitle");// string 검색 결과 영화의 영문 제목이다.
				String pubDate = (String) item.get("pubDate");// date //검색 결과 영화의 제작년도이다.
				String director = (String) item.get("director");// string 검색 결과 영화의 감독이다.
				String actor = (String) item.get("actor");// string 검색 결과 영화의 출연 배우이다.
				String userRating = (String) item.get("userRating");//

				MovieDTO mDTO = MovieDTO.builder().title(title).link(link).image(image).subtitle(subtitle)
						.pubDate(pubDate).director(director).actor(actor).userRating(userRating).build();
				mList.add(mDTO);
			}
			return mList;
	}

}
