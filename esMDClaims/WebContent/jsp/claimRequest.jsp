<%@include file="taglib_includes.jsp" %>
<%@include file="includes/header.jsp" %>

<div class="container_12">
        <script type="text/javascript">
            $(document).ready(function () {
                // $('input#familyName').gips({ 'theme': 'purple', autoHide: true, text: 'This is purple tooltip, auto hide after pausess time elapses.' });
                $('input#esmdFamilyName').gips({ 'theme': 'green', placement: 'bottom', text: 'Please Enter Family Name.'  });
                $('input#esmdGivenName').gips({ 'theme': 'green', placement: 'bottom', text: 'Please Enter Given Name.'  });
                $('input#esmdSecondNameOrInitials').gips({ 'theme': 'green', placement: 'bottom', text: 'Second Name Or Initials.'  });
                $('input#esmdFullName').gips({ 'theme': 'green', placement: 'bottom', text: 'Please Enter Full Name.'  });
                $('input#esmdUserName').gips({ 'theme': 'green', placement: 'bottom', text: 'Please Enter User Name.'  });
                $('textarea#esmdDescription').gips({ 'theme': 'green', placement: 'bottom', text: 'Description.'  });
                $('input#esmdTargetCommunity').gips({ 'theme': 'green', placement: 'bottom', text: 'Target Home Community.'  });
                $('input#esmdClaimId').gips({ 'theme': 'green', placement: 'bottom', text: 'Claim Identifier is the identifier with which the provider submits the Claim to CMS. This could be found in the Additional Documentation Request (ADR) letter from Review Contractor.'  });
                $('input#esmdCaseId').gips({ 'theme': 'green', placement: 'bottom', text: 'Case Identifier is the identifier, generated by the Review Contractor to open a claim specific case. This could be found in Additional Documentation Request (ADR) letter from the Review Contractor if the request is from MACs.'  });
                $('input#esmdIntendedRecipient').gips({ 'theme': 'green', placement: 'bottom', text: 'Intended Recipient represents the organization(s) or person(s) for whom the Document Submission set is intended for In esMD, the Intended Recipient will be an organization (Review Contractor) to whom the sender (HIH) will submit the message with esMD Claim supporting Documents. This Intended Recipient will be identified by a HL7 issued organizational identifier (OID)'  });
                $('input#esmdAuthor').gips({ 'theme': 'green', placement: 'bottom', text: 'Represents the provider (NPI), who submits the Claim Supporting Documents in response to the Additional Documentation Request letter (ADR) from the CMS Review Contractor This attribute could either contain the following sub-attributes based on who (either Provider or institution NPI) submits the documentation:'  });
                $('input#esmdAuthorInstitution').gips({ 'theme': 'green', placement: 'bottom', text: 'If there is only one document in the SubmissionSet, authorInstitution attribute of the SubmissionSet shall have the same NPI as the one used in the authorInstitution attribute at the document level. If there is more than one document in the SubmissionSet, authorInstitution attribute of the SubmissionSet shall have the NPI of the organization/institution which put together all the documents included in the SubmissionSet. Please note: At the SubmissionSet level, either the authorInstitution or authorPerson attribute shall be used but never both.'  });
                $('input#esmdAuthorPerson').gips({ 'theme': 'green', placement: 'bottom', text: 'If there is only one document in the SubmissionSet, authorPerson attribute of the SubmissionSet shall have the same NPI as the one used in the authorPerson attribute at the document level. If there is more than one document in the SubmissionSet, authorPerson attribute of the SubmissionSet shall have the NPI of the provider who put together all the documents in the SubmissionSet. Please note: At the SubmissionSet level, either the authorInstitution or authorPerson attribute shall be used but never both.'  });
                $('input#esmdContentTypeCode').gips({ 'theme': 'green', placement: 'bottom', text: 'The submission set is a response to Additional Documentation Request (ADR) from the Review Contractor. The ContentTypeCode is the code that specifies this – a Response to ADR'  });
                $('input#esmdEntryUuid').gips({ 'theme': 'green', placement: 'bottom', text: 'A unique ID or a globally unique identifier within the document submission request for the SubmissionSet. For example, “SubmissionSet01” can be entryUUID. It can also be in the UUID format. In the below example “SubmissionSet01” is used as entryUUID. This can also be UUID format.'  });
                $('input#esmdSubmissionSet').gips({ 'theme': 'green', placement: 'bottom', text: 'Submission Set Status.' });
                $('input#esmdSourceId').gips({ 'theme': 'green', placement: 'bottom', text: 'Globally unique identifier, in OID format, identifying the Health Information Handler (HIH) Gateway through which document/s were sent to the CMS esMD Gateway.'  });
                $('input#esmdDocumentTitle').gips({ 'theme': 'green', placement: 'bottom', text: 'Represents the title of the document. Max length, 128 bytes, UTF-8.'  });
                $('input#esmdPatientId').gips({ 'theme': 'green', placement: 'bottom', text: 'Since this is a required XDR field and we need to use it, we are going to populate this field with Claim ID. Since this field follows Root + Extension format, we are going to include CMS OID as the root and Claim ID as the extension, like so: CMS OID.ClaimID It is important to remember that Claim ID will also be populated in the attribute mentioned in row 1 of this table in addition to being populated here. Note: Soon, IHE might change PatientId to R2 ‘Required if known’.'  });
                $('input#esmdCreationTime').gips({ 'theme': 'green', placement: 'bottom', text: 'A unique ID or a globally unique identifier within the document submission request for the SubmissionSet. For example, “SubmissionSet01” can be entryUUID. It can also be in the UUID format. In the below example “SubmissionSet01” is used as entryUUID. This can also be UUID format.'  });
                $('input#esmdServiceStartTime').gips({ 'theme': 'green', placement: 'bottom', text: 'Represents the start time of the provider service being documented.<br> This value will not be used by esMD (i.e., will be ignored). However, since this field is required by XDR, an input is required. Any possible value assigned by the sender will be accepted.<br> Not applicable to esMD but required by XDR Interoperability.'  });
                $('input#esmdServiceStopTime').gips({ 'theme': 'green', placement: 'bottom', text: 'Represents the stop time of the provider service being documented. <br> This value will not be used by esMD (i.e., will be ignored). However, since this field is required by XDR, an input is required. Any possible value assigned by the sender will be accepted.'  });
                $('input#esmdSubmissionTime').gips({ 'theme': 'green', placement: 'bottom', text: 'Point in Time when the SubmissionSet was created at the HIH CONNECT Adapter.'  });
                $('input#esmdUniqueId').gips({ 'theme': 'green', placement: 'bottom', text: 'A globally unique identifier, in OID format, assigned by the HIH to the submission set in the transmission. The length of this Unique Identifier shall not exceed 128 bytes.'  });
                $('file#esmdUploadDocument').gips({ 'theme': 'green', placement: 'bottom', text: 'A unique ID or a globally unique identifier within the document submission request for the SubmissionSet. For example, “SubmissionSet01” can be entryUUID. It can also be in the UUID format. In the below example “SubmissionSet01” is used as entryUUID. This can also be UUID format.'  });
                $('input#esmdConfidentialityCode').gips({ 'theme': 'green', placement: 'bottom', text: 'Confidentiality Code.'  });
                $('input#esmdClassCode').gips({ 'theme': 'green', placement: 'bottom', text: 'Class Code.'  });
                $('input#esmdFormatCode').gips({ 'theme': 'green', placement: 'bottom', text: 'Format Code.'  });
                $('input#esmdHealthcareFacilityType').gips({ 'theme': 'green', placement: 'bottom', text: 'Healthcare Facility Type.'  });
                //$('input#yellow').gips({ 'theme': 'yellow', autoHide: true, placement: 'right' });
                // $('input#red').gips({ 'theme': 'red', placement: 'bottom' });
            });
        </script>
       
<form:form method="post" id="claimRequestForm" enctype="multipart/form-data" action="saveRequest.do" commandName="claimRequest">

	<ul class="formMainUL" >
		<form:input type="hidden" path="esmdRequestId"/>
	    <li class="formHead"> <h2>User Info</h2></li>
	
	    <li class="leftFormLI">Family Name <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input type="text" path="esmdFamilyName"/></li>
		<li><form:errors path="esmdFamilyName" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Given Name <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdGivenName"/></li>
	    <li><form:errors path="esmdGivenName" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Second Name Or Initials</li>
	    <li class="rightFormLI"><form:input path="esmdSecondNameOrInitials"/></li>
	    <li><form:errors path="esmdSecondNameOrInitials" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Full Name <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdFullName"/></li>
	    <li style="clear: left;"><form:errors path="esmdFullName" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">User Name <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdUserName"/></li>
	    <li style="clear: left;"><form:errors path="esmdUserName" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI" style="height:80px;">Description <span class="required">*</span></li>
	    <li class="rightFormLI"><form:textarea path="esmdDescription" style="width:145px"/></li>
	    <li style="clear: left;"><form:errors path="esmdDescription" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI" style="clear:left;">Target Community <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdTargetCommunity"/></li>
	    <li style="clear: left;"><form:errors path="esmdTargetCommunity" cssStyle="color:red"></form:errors></li>
	    
	</ul>
	<ul class="formMainUL" >
	
	    <li class="formHead"> <h2>Document Info</h2></li>
	
	    <li class="leftFormLI">ES MD Claim Id <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdClaimId"/></li>
	    <li><form:errors path="esmdClaimId" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">ES MD Case Id <span class="required"></span></li>
	    <li class="rightFormLI"><form:input path="esmdCaseId"/></li>
	    <li style="clear: left;"><form:errors path="esmdCaseId" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Intended Recipient <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdIntendedRecipient"/></li>
	    <li><form:errors path="esmdIntendedRecipient" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Author <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdAuthor"/></li>
	    <li><form:errors path="esmdAuthor" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Author Institution <span class="required"></span></li>
	    <li class="rightFormLI"><form:input path="esmdAuthorInstitution"/></li>
	    <li><form:errors path="esmdAuthorInstitution" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Author Person <span class="required"></span></li>
	    <li class="rightFormLI"><form:input path="esmdAuthorPerson"/></li>
	    <li><form:errors path="esmdAuthorPerson" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Content Type Code <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdContentTypeCode"/></li>
	    <li><form:errors path="esmdContentTypeCode" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Entry UUID <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdEntryUuid"/></li>
	    <li><form:errors path="esmdEntryUuid" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Source Id <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdSourceId"/></li>
	    <li><form:errors path="esmdSourceId" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Document Title <span class="required"></span></li>
	    <li class="rightFormLI"><form:input path="esmdDocumentTitle"/></li>
	    <li><form:errors path="esmdDocumentTitle" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Patient id <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdPatientId"/></li>
	    <li><form:errors path="esmdPatientId" cssStyle="color:red"></form:errors></li>
	    
	</ul>

	<ul class="formMainUL" >
	
	    <li class="formHead"> <h2></h2></li>
	    <br/>
	
	    <li class="leftFormLI">Creation Time <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdCreationTime"/></li>
	    <li><form:errors path="esmdCreationTime" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Service Start Time <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdServiceStartTime"/></li>
	    <li><form:errors path="esmdServiceStartTime" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Service Stop Time <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdServiceStopTime"/></li>
	    <li><form:errors path="esmdServiceStopTime" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Submission Time <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdSubmissionTime"/></li>
	    <li><form:errors path="esmdSubmissionTime" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Unique Id <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdUniqueId"/></li>
	    <li><form:errors path="esmdUniqueId" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Confidentiality Code<span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdConfidentialityCode"/></li>
	    <li><form:errors path="esmdConfidentialityCode" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Class Code<span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdClassCode"/></li>
	    <li><form:errors path="esmdClassCode" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Format Code<span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdFormatCode"/></li>
	    <li><form:errors path="esmdFormatCode" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Healthcare Facility Type<span class="required">*</span></li>
	    <li class="rightFormLI"><form:input path="esmdHealthcareFacilityType"/></li>
	    <li><form:errors path="esmdHealthcareFacilityType" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Submission Set<span class="required">*</span></li>
	    <li class="rightFormLI"><form:input type="text" path="esmdSubmissionSet" id="esmdSubmissionSet"/></li>
	    <li><form:errors path="esmdSubmissionSet" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI">Upload Document  <span class="required">*</span></li>
	    <li class="rightFormLI"><form:input type="file" path="esmdUploadDocument" id="esmdUploadDocument"/></li>
	    <li><form:errors path="esmdUploadDocument" cssStyle="color:red"></form:errors></li>
	
	    <li class="leftFormLI"></li>
	    <li class="rightFormLI"><input type="submit" name="send" id="send" value="Submit" /></li>
	</ul>
</form:form>

</div>
<%@include file="includes/footer.jsp" %>