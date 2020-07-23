# Java Client Code Usage

Please refer #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html) for any clarifications related to API request/response attributes.

Java Client code is provided to make it easier to integrate to SBA APIs.

**Usage #1:** Use Services provided in the code to eliminate the complexity of creating Rest Clients to integrate with SBA API's
> src/main/java/com/sba/ppp/loanforgiveness/service
		
**Usage #2:** Use domain objects to include in your code to make Rest API calls.
> src/main/java/com/sba/ppp/loanforgiveness/domain
	
**Usage #3:** Use complete repository as a Spring boot Application for your integration.

## Clone repository

Clone repository using SourceTree or Git Bash.

`$git clone https://github.com/UsSbaForgiveness/sba-java-client.git`
	
## Use Case 1: Submit Loan Forgiveness Request

## POST API Call using SbaLoanForgivenessService Service and SbaPPPLoanForgiveness Request.
	
`SbaLoanForgivenessService.execute(SbaPPPLoanForgiveness request)`
		
You need to populate SbaPPPLoanForgiveness Request object with all the information provided in the 3508 and 3508EZ documents.
Response is same as Request Object "SbaPPPLoanForgiveness" with id and slug are populated.

Please refer Document - Field mapping diagrams provided in the API Docs Page: https://ussbaforgiveness.github.io/

### Step 2: Retrieve the document types required for uploading the documents ###

### To get Document Type make a GET API Call to ###

`SbaLoanDocumentService.getDocumentTypes(Map<String, String> reqParams)`

reqParams -> Please refer GET Document Types API Swagger at #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html)
	  
### Use Case 3: Upload Supporting Documentation for a Loan Forgiveness Request ###

To upload the documents, 
  a. Need SbaPPPLoanForgiveness Details (Details can be from Step 1)
  b. Need Document Type  (Details can be from Step 1)
  
This is a POST API call to upload documents.
`SbaLoanDocumentService.submitLoanDocument(LoanDocument request)`

Please refer Upload Forgiveness Document Rest API at #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html#3-upload-forgiveness-documents)

### Step 4: Retrieve Loan Forgiveness Request Status and detail ###

### This is a GET API Call to retrieve Sba PPP Loan Forgiveness details submitted in Step 1. ###
`SbaLoanForgivenessService.getLoanStatus(Integer page)`
_page_ is a query parameter ex: 1,2 etc
		
Response `SbaPPPLoanForgivenessStatusResponse` contains all the requests submitted as part of the Loan Forgiveness Process.

Please refer Retrieve Forgiveness Request Rest API at #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html#6-get-forgiveness-request-details-using-sba-number)


### Some more API Samples ###

### Get SBA Messages
### During review of a Forgiveness request, SBA may require additional information from lender. This API is used to retrieve all messages sent by SBA to lender. ###

```SbaLoanForgivenessMessageService.getSbaLoanMessages(Integer page,String sbaNumber, boolean isComplete)```

Response `SbaPPPLoanMessagesResponse` contains all the messages exchanged between SBA and the lender
Please refer Get SBA Messages Rest API at #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html#8-get-forgiveness-messages)

### Reply SBA Messages
### During review of a Forgiveness request, SBA may require additional information from lender. This API is used by lender to respond back to SBA by attaching requested documents. ###

```SbaLoanForgivenessMessageService.updateSbaLoanMessageReply(MessageReply request)```

Please refer Reply SBA Messages Rest API at #[API Dictionary URL](https://ussbaforgiveness.github.io/API-Dictionary.html#10-reply-to-sba-message)
