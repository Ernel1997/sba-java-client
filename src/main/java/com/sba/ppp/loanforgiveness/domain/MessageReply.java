package com.sba.ppp.loanforgiveness.domain;

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
public class MessageReply {

	private Integer document_type;
	
    private String document;
    
    private String document_name;

}
