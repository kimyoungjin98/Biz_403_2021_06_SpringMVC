package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {

	public static void main(String[] args) {
		
		//VO, DTO를 생성하고 데이터를 담기
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("자바야놀자");
		
		BookDTO bookDTO1 = new BookDTO("자바야놀자", "linke", "image", "author", "price", "discount", "publisher",
										"isbn", "desc", "pubdate"
				);
				
		BookDTO bookDTO2 = BookDTO.builder().title("자바야놀자")
											.price("20000")
											.isbn("9760000")
											.build();
											
	}
	
}
