package com.callor.book.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Naver News 정보를 담는 NewsDTO 클래스를 list로 선언한
 * 부모 DTO 선언
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverParentDTO {

	private String lastBuildDate;//": "Mon, 05 Jul 2021 09:30:30 +0900",
	private String total;//": 440110,
	private String start;//": 1,
	private String display;//": 10,
	private List<NewsDTO> items;//":
	
}
