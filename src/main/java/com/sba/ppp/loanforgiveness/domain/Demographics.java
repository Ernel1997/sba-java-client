package com.sba.ppp.loanforgiveness.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Demographics {
	
	private String name;
	
	private String position;
	
	private String veteran_status;
	
	private String gender;
	
	private String ethnicity;
	
	private List<Race> races;

}
