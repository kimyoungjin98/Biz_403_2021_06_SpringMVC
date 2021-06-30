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

import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverMovieServiceV1")
public class NaverMovieServiceImplV1 implements NaverMovieService {

	@Override
	public String queryURL(String search_text) {

		String searchUTF8 = null;

		try {
			searchUTF8 = URLEncoder.encode(search_text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String queryURL = NaverSecret.NURL.MOVIE;
		String queryString = String.format("?query=%s", searchUTF8);
		queryString += String.format("&display=%d", 20);
		queryURL += queryString;

		log.debug("url {} ", queryURL);

		return queryURL.toString();
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {

		URL url = null;

		HttpURLConnection httpConn = null;

		url = new URL(queryURL);
		httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);

		int httpStatusCode = httpConn.getResponseCode();
		InputStreamReader is = null;

		if (httpStatusCode == 200) {

			is = new InputStreamReader(httpConn.getInputStream());
		} else {

			is = new InputStreamReader(httpConn.getErrorStream());
		}

		BufferedReader buffer = null;
		buffer = new BufferedReader(is);
		StringBuffer strBuffer = new StringBuffer();

		while (true) {

			String reader = buffer.readLine();
			if (reader == null) {
				break;
			}
			strBuffer.append(reader);
		}

		return strBuffer.toString();
	}

	@Override
	public List<MovieDTO> getNaverList(String jsonString) {

		log.debug("치키챠 {}", jsonString);

		JSONParser jParser = new JSONParser();

		try {
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
