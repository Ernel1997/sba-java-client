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
public class MessageReply {
	
	private UUID slug;

	private Integer document_type;
	
    private String document;
    
    private String document_name;
    
    private String content;
    
    private String filePathToUpload;

}
