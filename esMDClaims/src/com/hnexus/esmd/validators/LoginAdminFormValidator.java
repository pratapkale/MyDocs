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
public class LoginAdminFormValidator  implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdUserName", "field.userName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "esmdPassword", "field.password.empty");
	}
}
