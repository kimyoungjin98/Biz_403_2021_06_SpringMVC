package com.callor.book.service.impl.books;

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
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverBookServiceV1")
public class NaverBookServiceImplV1 implements NaverBookService{
	
	public String queryURL(String search) {
		
		// 검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = null;
		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.NURL.BOOK); // String += BookURL
		
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);
		
		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		
		log.debug("queryURL {}", queryURL.toString());
		return queryURL.toString();
	}

	
	@Override
	public String getJsonString(String queryURL) throws IOException {
		// TODO Auto-generated method stub
		
		// API를 통하여 다른 서버에 Request를 보낼때 사용할 객체
		URL url = null;
		
		// http 프로토콜을 통하여 다른 서버에 연결할때 사용할 객체
		HttpURLConnection httpConn = null;
		
		
			// queryURL 주소를 Request 정보로 변환
			url = new URL(queryURL);
			
			httpConn = (HttpURLConnection) url.openConnection();
			
			// 요청하는 method를 GET로 설정하기
			httpConn.setRequestMethod("GET");
			
			httpConn.setRequestProperty("X-Naver-Client-Id", 
											NaverSecret.NAVER_CLIENT_ID);
			httpConn.setRequestProperty("X-Naver-Client-Secret", 
											NaverSecret.NAVER_CLIENT_SECRET);
			
			// naver가 어떤 응답을 할것인지를 미리 확인하는 
			// 코드를 요청한다
			int httpStatusCode = httpConn.getResponseCode();
			
			InputStreamReader is = null;
			
			if(httpStatusCode == 200) {
				
				is = new InputStreamReader(httpConn.getInputStream());
				
			} else {
				
				is = new InputStreamReader(httpConn.getErrorStream());
				
			}
			
			// is를 buffer에 연결
			BufferedReader buffer = null;
			buffer = new BufferedReader(is);
			
			/*
			 * StringBuilder, StringBuffer
			 * 
			 * String 형의 데이터를 += 처럼
			 * 사용할때 발생하는 메모리 leak 성능저하
			 * 문를 해결하기 위하여 탄생된 클래스
			 * 
			 * String 형의 데이터를 += 하면
			 * 예) 다음과 같은 코드를 반복하면
			 * 		String str += "대한민국" 
			 * 		str += "Korea"
			 * 		str += "Republic"
			 * 내부적으로는 str 변수를 생성, 제거, 생성, 제거
			 * 하는 코드가 반복적으로 수행된다
			 */
			StringBuffer sBuffer = new StringBuffer();
			
			while(true) {
				
				String reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				sBuffer.append(reader);
			}
			return sBuffer.toString();
		
	}

	@Override
	public List<BookDTO> getNaverList(String jsonString) {
		// TODO Auto-generated method stub
		
		JSONParser jParser = new JSONParser();
		
		try {
			JSONObject jObject = (JSONObject) jParser.parse(jsonString);
			JSONArray items = (JSONArray) jObject.get("items");
			
			List<BookDTO> bookList = new ArrayList<BookDTO>();
			
			int nSize = items.size();
			
			for(int i = 0 ; i < nSize ; i++) {
				
				JSONObject item = (JSONObject) items.get(i);
				
				 String title = (String) item.get("title");//	 String 검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
				 String link = (String) item.get("link");//	 String	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
				 String image = (String) item.get("image");//	 String	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
				 String author = (String) item.get("author");//	 String	저자 정보이다.
				 String price = (String) item.get("price");//	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
				 String discount = (String) item.get("discount");//	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
				 String publisher = (String) item.get("publisher");//	 String	출판사 정보이다.
				 String isbn = (String) item.get("isbn");//	integer	ISBN 넘버이다.
				 String description = (String) item.get("description");//	 String	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
				 String pubdate = (String) item.get("pubdate");
				 
				 BookDTO bookDTO = BookDTO.builder()
						.title(title)
				 		.link(link)
				 		.image(image)
				 		.author(author)
				 		.price(price)
				 		.discount(discount)
				 		.publisher(publisher)
				 		.isbn(isbn)
				 		.description(description)
				 		.pubdate(pubdate)
				 		.build();
				 
				 bookList.add(bookDTO);
			}
			return bookList;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

