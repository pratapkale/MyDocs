/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
	//global vars
	var form = $("#customForm");
	var familyName = $("#familyName");
	var familyNameInfo = $("#familyNameInfo");
        var givenName = $("#givenName");
	var givenNameInfo = $("#givenNameInfo");
        var secondNameOrInitials =$("#secondNameOrInitials");
        var secondNameOrInitialsInfo =$("#secondNameOrInitialsInfo");
        var fullName =$("#fullName");
        var fullNameInfo =$("#fullNameInfo");
        var prefix =$("#prefix");
        var prefixInfo =$("#prefixInfo");
        var suffix =$("#suffix");
        var suffixInfo =$("#suffixInfo");
        var userName =$("#userName");
        var userNameInfo =$("#userNameInfo");
        var description =$("#description");
        var descriptionInfo =$("#descriptionInfo");
        var homeCommunityId =$("#homeCommunityId");
        var homeCommunityIdInfo =$("#homeCommunityIdInfo");
        var name =$("#name");
        var nameInfo =$("#nameInfo");
        var file =$("#file");
        var fileInfo =$("#fileInfo");

	
	var message = $("#message");

	//On blur
	familyName.blur(validateName);
        givenName.blur(validateName);
        secondNameOrInitials.blur(validateName);
        fullName.blur(validateName);
        prefix.blur(validateName);
        suffix.blur(validateName);
        userName.blur(validateName);
        description.blur(validateName);
        homeCommunityId.blur(validateName);
        name.blur(validateName);
        file.blur(validateName);
	message.blur(validateMessage);
	//On key press
	familyName.keyup(validateName);
        givenName.keyup(validateName);
        secondNameOrInitials.keyup(validateName);
        fullName.keyup(validateName);
        prefix.keyup(validateName);
        suffix.keyup(validateName);
        userName.keyup(validateName);
        description.keyup(validateName);
        homeCommunityId.keyup(validateName);
        name.keyup(validateName);
        file.keyup(validateName);	
	message.keyup(validateMessage);
	//On Submitting
	form.submit(function(){
		if(validateMessage())
			return true
		else
			return false;
	});

	//validation functions

	function validateName(){
		//if it's NOT valid
		if(familyName.val().length < 4){
			familyName.addClass("error");
			familyNameInfo.text("We want family name with more than 3 letters!");
			familyNameInfo.addClass("error");
			return false;
		}else{
			familyName.removeClass("error");
			familyNameInfo.text("");
			familyNameInfo.removeClass("error");
                }
                if(givenName.val().length < 4){
			givenName.addClass("error");
			givenNameInfo.text("We want Given Name with more than 3 letters!");
			givenNameInfo.addClass("error");
			return false;
		}else{
                        givenName.removeClass("error");
			givenNameInfo.text("");
			givenNameInfo.removeClass("error");
			
		}
                if(secondNameOrInitials.val().length < 4){
			secondNameOrInitials.addClass("error");
			secondNameOrInitialsInfo.text("We want secondNameOrInitials with more than 3 letters!");
			secondNameOrInitialsInfo.addClass("error");
			return false;
		}else{
                        secondNameOrInitials.removeClass("error");
			secondNameOrInitialsInfo.text("");
			secondNameOrInitialsInfo.removeClass("error");
			
		}
                if(fullName.val().length < 4){
			fullName.addClass("error");
			fullNameInfo.text("We want Full Name with more than 3 letters!");
			fullNameInfo.addClass("error");
			return false;
		}else{
                        fullName.removeClass("error");
			fullNameInfo.text("");
			fullNameInfo.removeClass("error");
			
		}
                 if(prefix.val().length < 4){
			prefix.addClass("error");
			prefixInfo.text("We want prefix with more than 3 letters!");
			prefixInfo.addClass("error");
			return false;
		}else{
                        prefix.removeClass("error");
			prefixInfo.text("");
			prefixInfo.removeClass("error");
			
		}
                if(suffix.val().length < 4){
			suffix.addClass("error");
			suffixInfo.text("We want suffix with more than 3 letters!");
			suffixInfo.addClass("error");
			return false;
		}else{
                        suffix.removeClass("error");
			suffixInfo.text("");
			suffixInfo.removeClass("error");
			
		}
                if(userName.val().length < 4){
			userName.addClass("error");
			userNameInfo.text("We want User Name with more than 3 letters!");
			userNameInfo.addClass("error");
			return false;
		}else{
                        userName.removeClass("error");
			userNameInfo.text("");
			userNameInfo.removeClass("error");
			return true;
		}
               if(description.val().length < 10){
			descriptionInfo.addClass("error");
			descriptionInfo.text("We want description with more than 3 letters!");
			descriptionInfo.addClass("error");
			return false;
		}else{
                        descriptionInfo.removeClass("error");
			descriptionInfo.text("");
			descriptionInfo.removeClass("error");
			
		}
                if(homeCommunityId.val().length < 0){
			homeCommunityId.addClass("error");
			homeCommunityIdInfo.text("We want homeCommunityId with more than 3 letters!");
			homeCommunityIdInfo.addClass("error");
			
		}else{
                       homeCommunityId.removeClass("error");
                       homeCommunityIdInfo.text("");
                       homeCommunityIdInfo.removeClass("error");
			
		}
                if(name.val().length < 4){
			name.addClass("error");
			nameInfo.text("We want  Name with more than 3 letters!");
			nameInfo.addClass("error");
			return false;
		}else{
                       name.removeClass("error");
                       nameInfo.text("");
                       nameInfo.removeClass("error");
			
		}
                if(file.val().length < 4){
			file.addClass("error");
			fileInfo.text("We want file with more than 3 letters!");
			fileInfo.addClass("error");
			return false;
		}else{
                       file.removeClass("error");
                       fileInfo.text("");
                       fileInfo.removeClass("error");
			return true;
		}
        }
	/*function validatePass1(){
		var a = $("#password1");
		var b = $("#password2");

		//it's NOT valid
		if(pass1.val().length <5){
			pass1.addClass("error");
			pass1Info.text("Ey! Remember: At least 5 characters: letters, numbers and '_'");
			pass1Info.addClass("error");
			return false;
		}
		//it's valid
		else{
			pass1.removeClass("error");
			pass1Info.text("At least 5 characters: letters, numbers and '_'");
			pass1Info.removeClass("error");
			validatePass2();
			return true;
		}
	}
	function validatePass2(){
		var a = $("#password1");
		var b = $("#password2");
		//are NOT valid
		if( pass1.val() != pass2.val() ){
			pass2.addClass("error");
			pass2Info.text("Passwords doesn't match!");
			pass2Info.addClass("error");
			return false;
		}
		//are valid
		else{
			pass2.removeClass("error");
			pass2Info.text("Confirm password");
			pass2Info.removeClass("error");
			return true;
		}
	}
	function validateMessage(){
		//it's NOT valid
		if(message.val().length < 10){
			message.addClass("error");
			return false;
		}
		//it's valid
		else{
			message.removeClass("error");
			return true;
		}*/
            function validateMessage(){
		//it's NOT valid
		if(message.val().length < 10){
			message.addClass("error");
			return false;
		}
		//it's valid
		else{
			message.removeClass("error");
			return true;
		}
            }
	
});