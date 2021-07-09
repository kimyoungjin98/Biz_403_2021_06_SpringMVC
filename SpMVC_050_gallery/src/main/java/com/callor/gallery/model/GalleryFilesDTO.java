package com.callor.gallery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GalleryFilesDTO {
	
	/*
	 * tbl_gallery와 tbl_files table을 join하여 select 한 데이터는
	 * 실제로는 1:N 관계로 생성된 결과이다
	 * 
	 * 하지만 실제 보여지는 list는 마치 tbl_gallery가 여러개 있는 것처럼 보인다
	 * 
	 * 
	 */

	private Long g_seq;//	bigint
	private String g_writer;//	varchar(125)
	private String g_date;//	varchar(10)
	private String g_time;//	varchar(10)
	private String g_subject;//	varchar(50)
	private String g_content;//	varchar(1000)
	private Long f_seq;//	bigint
	private String f_original;//	varchar(256)
	private String f_upname;//	varchar(256)
	
}
