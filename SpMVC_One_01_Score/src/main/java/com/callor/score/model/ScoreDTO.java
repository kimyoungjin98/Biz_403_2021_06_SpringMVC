package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {

	private String v_num;
	private String v_name;
	private String v_dept;
	private Integer v_grade= 0;
	private Integer v_subject= 0;
	private Integer v_sum= 0;
	private Float v_avg = (float)0;
	
}
