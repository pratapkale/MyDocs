/**
 * 
 */
package com.hnexus.esmd.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hnexus.esmd.commons.utils.CommonUtils;
import com.hnexus.esmd.commons.utils.CustomValidations;
import com.hnexus.esmd.request.domain.ClaimRequest;

/**
 * @author user
 *
 */
@Component
public class ClaimRequestFromValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return ClaimRequest.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdFamilyName", "field.esmdFamilyName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdGivenName", "field.esmdGivenName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdFullName", "field.esmdFullName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdUserName", "field.esmdUserName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdDescription", "field.esmdDescription.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdTargetCommunity", "field.esmdTargetCommunity.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdClaimId", "field.esmdClaimId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdCaseId", "field.esmdCaseId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdIntendedRecipient", "field.esmdIntendedRecipient.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdAuthor", "field.esmdAuthor.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdContentTypeCode", "field.esmdContentTypeCode.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdEntryUuid", "field.esmdEntryUuid.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdSourceId", "field.esmdSourceId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdSubmissionSet", "field.esmdSubmissionSet.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdPatientId", "field.esmdPatientId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdCreationTime", "field.esmdCreationTime.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdServiceStartTime", "field.esmdServiceStartTime.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdServiceStopTime", "field.esmdServiceStopTime.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdSubmissionTime", "field.esmdSubmissionTime.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdUniqueId", "field.esmdUniqueId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdConfidentialityCode", "field.esmdConfidentialityCode.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdClassCode", "field.esmdClassCode.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdFormatCode", "field.esmdFormatCode.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdHealthcareFacilityType", "field.esmdHealthcareFacilityType.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdUploadDocument", "field.esmdUploadDocument.empty");
		
		ClaimRequest oClaimRequest = (ClaimRequest)target;
		if(oClaimRequest != null && oClaimRequest.getEsmdAuthor() != null){
			if(oClaimRequest.getEsmdUploadDocument().getSize()==0){
				errors.rejectValue("esmdUploadDocument", "field.esmdUploadDocument.empty");
			}
		}
		if(oClaimRequest != null && oClaimRequest.getEsmdAuthor() != null){
			if(CommonUtils.isNotNull(oClaimRequest.getEsmdAuthor().toString())){
				if(!CustomValidations.isInteger(oClaimRequest.getEsmdAuthor().toString())){
					errors.rejectValue("esmdAuthor", "field.esmdAuthor.integer");
				}
			}
		}
		if(oClaimRequest != null && oClaimRequest.getEsmdAuthorInstitution() != null){
			if(CommonUtils.isNotNull(oClaimRequest.getEsmdAuthorInstitution().toString())){
				if(!CustomValidations.isInteger(oClaimRequest.getEsmdAuthorInstitution().toString())){
					errors.rejectValue("esmdAuthorInstitution", "field.esmdAuthorInstitution.integer");
				}
			}
		}
		if(oClaimRequest != null && oClaimRequest.getEsmdAuthorPerson() != null){
			if(CommonUtils.isNotNull(oClaimRequest.getEsmdAuthorPerson().toString())){
				if(!CustomValidations.isInteger(oClaimRequest.getEsmdAuthorPerson().toString())){
					errors.rejectValue("esmdAuthorPerson", "field.esmdAuthorPerson.integer");
				}
			}
		}
	}

}
