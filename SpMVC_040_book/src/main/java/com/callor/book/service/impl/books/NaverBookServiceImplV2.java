package com.callor.book.service.impl.books;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.model.BookDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

/*
 * ServiceV1을 상속받은 ServiceV2
 * 
 * Service method 
 * 	queryURL(), getJsonString(), getNaverList() 
 * 	중에서 getNaverList() method를 재정의
 */
@Slf4j
@Service("naverBookServiceV2")
public class NaverBookServiceImplV2 extends NaverBookServiceImplV1 {
	
	@Override
	public List<BookDTO> getNaverList(String jsonString) {
		
		log.debug("나는 ServiceV2");
		
		// 문자열형 JSON 인 jsonString을 Json 객체로 변환하기
		JsonElement jSonElement = JsonParser.parseString(jsonString);
		
		// 필요한 항목만 가져오기
		
		JsonElement oItems = jSonElement.getAsJsonObject().get("items");
	
		Gson gson = new Gson();
		
		// List는 interface인데 interface는 자신의 type을
		// 가지고 있지 않는 객체
		TypeToken<List<BookDTO>> typeToken 
			= new TypeToken<List<BookDTO>>() {};
			
		List<BookDTO> bookList 
			= gson.fromJson(oItems, typeToken.getType());
		
		return bookList;
	}

	
	
}
