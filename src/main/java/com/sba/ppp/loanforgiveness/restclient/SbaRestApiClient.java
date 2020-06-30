package com.sba.ppp.loanforgiveness.restclient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.sba.ppp.loanforgiveness.domain.LoanDocument;
import com.sba.ppp.loanforgiveness.domain.SbaPPPLoanDocumentTypeResponse;
import com.sba.ppp.loanforgiveness.domain.SbaPPPLoanForgiveness;
import com.sba.ppp.loanforgiveness.domain.SbaPPPLoanForgivenessStatusResponse;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SbaRestApiClient {

    @Value("${sba.api-token}")
    private String apiToken;
    
    @Value("${sba.vendor-key}")
    private String vendorKey;
    
    @Value("${sba.loan-forgiveness.url}")
    private String loanForgivenessUrl;
    
    @Value("${sba.loan-documents.url}")
    private String loanDocumentsUrl;
    
    @Value("${sba.loan-document-types.url}")
    private String loanDocumentTypesUrl;
    
	private RestTemplate restTemplate;
	
	public static final String VENDOR_KEY_HEADER = "Vendor-Key";
	
    public SbaRestApiClient(@Qualifier("sbaRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SbaPPPLoanForgiveness invokeSbaLoanForgiveness(SbaPPPLoanForgiveness request) {
    	SbaPPPLoanForgiveness response = null;
    	HttpHeaders headers = getHttpHeaders();
    	HttpEntity<SbaPPPLoanForgiveness> entity = new HttpEntity<SbaPPPLoanForgiveness>(request, headers); 
    	        
    	log.info("Submitting LoanForgiveness Request");
    	ResponseEntity<SbaPPPLoanForgiveness> resEntity = restTemplate.exchange(loanForgivenessUrl, HttpMethod.POST, entity, SbaPPPLoanForgiveness.class);
    	
    	if (resEntity != null) {
    		response = resEntity.getBody();
    		Gson gson = new Gson();
			log.info("LoanForgiveness Response: {}", gson.toJson(response));
		}
		else {
			log.error("Error while submitting LoanForgiveness Request");
		}
		return response;
    }
    
    public LoanDocument invokeSbaLoanDocument(LoanDocument request) {
    	LoanDocument response = null;
    	HttpHeaders headers = getHttpHeaders();
    	HttpEntity<LoanDocument> entity = new HttpEntity<LoanDocument>(request, headers); 
    	        
    	log.info("Submitting LoanForgiveness Request");
    	ResponseEntity<LoanDocument> resEntity = restTemplate.exchange(loanDocumentsUrl, HttpMethod.POST, entity, LoanDocument.class);
    	
    	if (resEntity != null) {
    		response = resEntity.getBody();
    		Gson gson = new Gson();
			log.info("LoanForgiveness Response: {}", gson.toJson(response));
		}
		else {
			log.error("Error while submitting LoanForgiveness Request");
		}
		return response;
    }
    
    public SbaPPPLoanForgivenessStatusResponse getSbaLoanForgiveness(Integer pageNumber) {
    	SbaPPPLoanForgivenessStatusResponse response = null;
    	HttpHeaders headers = getHttpHeaders();
    	HttpEntity<String> entity = new HttpEntity<String>(headers); 
    	
    	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(loanForgivenessUrl);
    	if (pageNumber != null && pageNumber > 0) {
    		uriBuilder.queryParam("page", pageNumber);
    	}
    	        
    	log.info("Retreiving LoanForgiveness Request Status");
    	ResponseEntity<SbaPPPLoanForgivenessStatusResponse> resEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, SbaPPPLoanForgivenessStatusResponse.class);
    	
    	if (resEntity != null) {
    		response = resEntity.getBody();
    		Gson gson = new Gson();
			log.info("Retreiving LoanForgiveness Request Status. Response: {}", gson.toJson(response));
		}
		else {
			log.error("Error while Retreiving LoanForgiveness Request Status");
		}
		return response;
    }
    
    public SbaPPPLoanDocumentTypeResponse getSbaLoanDocumentTypes(Map<String, String> reqParams) {
    	SbaPPPLoanDocumentTypeResponse response = null;
    	HttpHeaders headers = getHttpHeaders();
    	HttpEntity<String> entity = new HttpEntity<String>(headers); 
    	
    	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(loanDocumentTypesUrl);
    	
    	reqParams.entrySet().forEach(r -> {    		
    		uriBuilder.queryParam(r.getKey(), r.getValue());
    	});
    	        
    	log.info("Retreiving Loan Document Types");
    	ResponseEntity<SbaPPPLoanDocumentTypeResponse> resEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, SbaPPPLoanDocumentTypeResponse.class);
    	
    	if (resEntity != null) {
    		response = resEntity.getBody();
    		Gson gson = new Gson();
			log.info("Retreiving Loan Document Types. Response: {}", gson.toJson(response));
		}
		else {
			log.error("Error while Retreiving Loan Document Types");
		}
		return response;
    }

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Token " + apiToken);
    	headers.add(VENDOR_KEY_HEADER, vendorKey);
		return headers;
	}
 
}
