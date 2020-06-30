package com.sba.ppp.loanforgiveness.domain;

import java.util.UUID;

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
public class SbaPPPLoanForgiveness {
	
	private Integer id;
	
	private UUID slug;
	
	private String borrower_name;
	
	private EtranLoan etran_loan;
	
}

