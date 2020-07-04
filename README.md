## Java Client Code Usage

Please refer swagger #[Swagger URL](https://sandbox.ussbaforgiveness.com/api-docs/) for any clarifications related to API request/response attributes.

Java Client code is provided to make it easier to integrate to SBA APIs.

	Usage #1: Use Services provided in the code to eliminate the complexity of creating Rest Clients to integrate with SBA API's
		src/main/java/com/sba/ppp/loanforgiveness/service
		
	Usage #2: Use domain objects to include in your code to make Rest API calls.
		src/main/java/com/sba/ppp/loanforgiveness/domain
	
	Usage #3: Use complete repository as a Spring boot Application for your integration.

## Clone repository

Clone repository using SourceTree or Git Bash.

	$git clone https://github.com/UsSbaForgiveness/sba-java-client.git
	
## Use Case 1: Submit Loan Forgiveness Request

	# POST API Call using SbaLoanForgivenessService Service and SbaPPPLoanForgiveness Request.
	
		SbaLoanForgivenessService.execute(SbaPPPLoanForgiveness request)
		
		You need to populate SbaPPPLoanForgiveness Request object with all the information provided in the 3508 and 3508EZ documents.
		Response is same as Request Object "SbaPPPLoanForgiveness" with id and slug are populated.
		
		Please refer Document - Field mapping diagrams provided in the Wiki Page: https://github.com/UsSbaForgiveness/SBAPPPForgiveness/wiki

# Note

	If you are uploading the documents immediately after Step 1, Response object from Step 1 contains all the information needed so please skip Step 2. 
	and continue with Step 3.
		
## Use Case 2: Retrieve Loan Forgiveness Request Status and detail

	# This is a GET API Call to retrieve Sba PPP Loan Forgiveness details submitted in Step 1.
	
		SbaLoanForgivenessService.getLoanStatus(Integer page)
		* page is a query parameter ex: 1,2 etc
		
		Response SbaPPPLoanForgivenessStatusResponse contains all the requests submitted as part of the Loan Forgiveness Process.

## Use Case 3: Upload Supporting Documentation for a Loan Forgiveness Request

	# To upload the documents, 
		a. Need SbaPPPLoanForgiveness Details (Details can be from Step 1 or Step 2)
		b. Need Document Type
			# To get Document Type make a GET API Call to 
				SbaLoanDocumentService.getDocumentTypes(Map<String, String> reqParams)
				* reqParams -> Please refer GET Document Types API Swagger at #[Swagger URL](https://sandbox.ussbaforgiveness.com/api-docs/)
	  
	  This is a POST API call to upload documents.
	  	SbaLoanDocumentService.submitLoanDocument(LoanDocument request)
