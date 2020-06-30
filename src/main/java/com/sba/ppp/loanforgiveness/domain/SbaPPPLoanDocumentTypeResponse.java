package com.sba.ppp.loanforgiveness.domain;

import java.util.Date;
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
public class SbaPPPLoanDocumentTypeResponse {

	 private Integer count;
	 
	 private Integer next;
	 
	 private Integer previous;
	 
	 private List<LoanDocumentType> results;

}
