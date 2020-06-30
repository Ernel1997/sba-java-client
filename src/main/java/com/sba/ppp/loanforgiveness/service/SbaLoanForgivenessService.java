package com.sba.ppp.loanforgiveness.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.ppp.loanforgiveness.domain.SbaPPPLoanForgiveness;
import com.sba.ppp.loanforgiveness.domain.SbaPPPLoanForgivenessStatusResponse;
import com.sba.ppp.loanforgiveness.restclient.SbaRestApiClient;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Getter
@Setter
@Log4j2
public class SbaLoanForgivenessService {
	
	@Autowired
	private SbaRestApiClient sbaRestApiClient;
	
	public SbaPPPLoanForgiveness execute(SbaPPPLoanForgiveness request) throws IOException {
		log.info("Processing Sba Loan Forgiveness request");
		return sbaRestApiClient.invokeSbaLoanForgiveness(request);
		
	}
	
	public SbaPPPLoanForgivenessStatusResponse getLoanStatus(Integer page) throws IOException {
		log.info("Retreiving Sba Loan Forgiveness request");
		return sbaRestApiClient.getSbaLoanForgiveness(page);
		
	}
		


}
