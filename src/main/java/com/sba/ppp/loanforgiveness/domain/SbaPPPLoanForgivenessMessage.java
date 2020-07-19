package com.sba.ppp.loanforgiveness.domain;

import java.util.List;
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
public class SbaPPPLoanForgivenessMessage {
	
	private String sba_number;
	
	private String subject;
	
	private UUID ticket;
	
	private boolean is_complete;
	
	private String needs_attention;
	
	private List<Message> messages; 
	
}

