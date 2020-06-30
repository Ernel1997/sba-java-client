package com.sba.ppp.loanforgiveness.domain;

import java.time.ZonedDateTime;
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
public class LoanDocument {
	
	 private UUID slug;
	 
     private String name;
     
     private String description;
     
     private ZonedDateTime created_at;
     
     private ZonedDateTime updated_at;
     
     private String document;
     
     private String url;
     
     private boolean requires_esign;
     
     private boolean schedule_a;
     
     private String etran_loan;
     
     private LoanDocumentType document_type;
     
     private boolean final_3508_document;

}
