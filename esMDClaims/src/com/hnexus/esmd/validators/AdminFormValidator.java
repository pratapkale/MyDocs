/**
 * 
 */
package com.hnexus.esmd.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hnexus.esmd.admins.domain.Admin;

/**
 * @author user
 *
 */
@Component
public class AdminFormValidator  implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdUserName", "field.reg.userName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdPassword", "field.reg.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdFamilyName", "field.reg.esmdFamilyName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdGivenName", "field.reg.esmdGivenName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdSecondNameOrInitials", "field.reg.esmdSecondNameOrInitials.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdAdminEmail", "field.reg.esmdAdminEmail.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdOrgIdentifier", "field.reg.esmdOrgIdentifier.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdFax", "field.reg.esmdFax.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdPhone", "field.reg.esmdPhone.empty");
		
	}
}
