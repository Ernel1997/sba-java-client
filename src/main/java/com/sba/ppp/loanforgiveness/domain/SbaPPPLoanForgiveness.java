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
	
	private UUID slug;
	
	private String borrower_name;
	
	private EtranLoan etran_loan;
	
	private String approval_date;
	
	private String final_forgive_amount;
	
	private String calculated_interest;
	
	private String final_forgive_payment;
	
	private String final_forgive_payment_date;
	
	private String final_forgive_payment_batch;
	
}

