$(document).ready(function() {
	
	/*
	 * Make request to JSPRequestServlet Changes the body content on click
	 * applicable to Get Started, Login, Join
	 */
	$('body').on('click', '#getStartedBtn', (function(e) {
		//e.preventDefault(); // prevent default event
		var ele = $(this).attr('id'); // gets the element id and stores it
		$.ajax({
			type : "POST", 
			data : {
				anchorId : ele // declared a new parameter and assigned a value
								// = ID
			},
			url : "JSPRequestServlet", // SERVLET
			success : function(msg) {
				$('.section').remove(); // REMOVE THE DIV CONTENT
				$(".changingContent").append(msg); // APPEND NEW DIV
			}
		});
	})
	);

	
	/*
	 * Populate the state option field based on country selection for both
	 * customer and store field
	 */
	$('body').on('change', '#storeCountries, #memberCountries', (function(){
		var selection = $(this).val(); // get the value of the element
		var eleId = $(this).attr('id');
		console.log(selection);
		$.ajax({
			type: "POST",
			// contentType: "application/json", //NOT TAKING CONTENT TYPE
			data: {
				getList : "state",
				country : selection
			},
			url: "../DropDownRequestServlet",
			success : function(xhr) {
				console.log(xhr); // FOR CONSOLE LOGGING
				var response = jQuery.parseJSON(xhr);
				
				if(eleId === 'storeCountries'){
					// REMOVE THE OPTIONS IF ONE EXISTS BEFORE
					$('#storeStates').find('option').remove();
					$('#storeStates').append(
					"<option selected='selected' value='0'>select state / province</option>");
					$.each(response, function(key,value){
						// getting data on [{},{}] format so need two iteration
						$.each(value, function(key, value){
							console.log(key, value);
							$("#storeStates").append(
									"<option value='" + key + "'>" + value + "</option>");
						});
					});
				}
				
				// due to time limit it is seperate but
				// Need to combine Two logics together
				// can be done and have been done before
				
				if(eleId === 'memberCountries'){
					$('#memberStates').find('option').remove();
					$('#memberStates').append(
					"<option selected='selected' value='0'>select state / province</option>");
					$.each(response, function(key,value){
						// getting data on [{},{}] format so need two iteration
						$.each(value, function(key, value){
							console.log(key, value);
							$("#memberStates").append(
									"<option value='" + key + "'>" + value + "</option>");
						});
					});
				}
				
			}
		})
		
		
	})
	);
	
	
	/*
	 * need to combine with previous ajax Populate the Store option field based
	 * on State selection
	 */
	$('body').on('change', '#storeStates', (function(){
		var selection = $(this).val(); // get the value of the element
		console.log(selection);
		$.ajax({
			type: "POST",
			// contentType: "application/json", //NOT TAKING CONTENT TYPE
			data: {
				getList : "store",
				state : selection
			},
			url: "../DropDownRequestServlet", // SERVLET
			success : function(xhr) {
				console.log(xhr); // FOR CONSOLE LOGGING
				var response = jQuery.parseJSON(xhr);

				// REMOVE THE OPTIONS IF ONE EXISTS BEFORE
				$('#locations').find('option').remove();
				$('#locations').append(
						"<option selected='selected' value='0' ToolTip=''>select your home store</option>");
				$.each(response, function(key,value){
					// getting data on [{},{}] format so need two iteration
					 $.each(value, function(key, value){
						 console.log(key, value);
						 $("#locations").append(
									"<option value='" + key + "'>" + value + "</option>");
					 });
					
					
				});
			}
		})
		
		
	})
	);
	
	/**
	 * ON SIGNOUT CLICK INVALIDATE THE SESSION
	 */ 
	$('#signout').click(function(e){
		// change the form object to string
		$.ajax({
			type: "GET",
			url : "LoginController",
			data : {
				logout : true,
			},
			success : function(data) {
				console.log(data);
			}
		});
	})
	
	/**
	 * VALIDATE IF USERNAME EXISTS
	 */
	$("#username").on('blur keyup', function(e){
		$("#registerForm").find("[class^='error_']").hide();
		if(e.type == 'keyup' && e.keyCode == '13' || e.type == 'blur'){
			$.ajax({
				type:'POST',
				data : {
					username : $(this).val(),
					anchorId : "usernameRequest" // declared a new parameter
													// and assigned a value = ID
				},
				url : "JSPRequestServlet", // SERVLET
				success : function(data){
					if(data == "invalid"){
						$(".error_username").show().html("Invalid Username");
					}else if (data == "exist") {
						$(".error_username").show().html("Username already exist");
					} 
				}
			})
		}
	})
	
	/**
	 * CALL CONFIRM PASSWORD ON THE FLY
	 */
	$("#registerConfirmPassword").keyup(function(){
		var password = $("#registerPassword").val();
		var confirmPassword = $("#registerConfirmPassword").val();
		
		var error = validateConfirmPassword(password, confirmPassword);
		if(error == ""){
			$(".error_confirmPassword").hide();
		}
	});
	
	/**
	 * CALL CONFIRM EMAIL ON THE FLY
	 */
	$("#confirmEmail").keyup(function(){
		var email = $("#email").val();
		var confirmEmail = $("#confirmEmail").val();
		
		var error = validateConfirmEmail(email, confirmEmail);
		if(error == ""){
			$(".error_confirmEmail").hide();
		}
	});
	

	/**
	 * REGISTER FORM SUBMISSION 
	 */
	$("#submitForm").on('click', function (e){
		    // get all the inputs into an array.
		    var $inputs = $('#registerForm :input');

		    // get array of just the values.
		    var values = {};
		    $inputs.each(function() {
		        values[this.name] = $(this).val();
		    });
		    
		    //validate form elements
		    if(validate(values)){
		    	$("#registerForm").submit();
		    } else {
		    	e.preventDefault();
		    }
		    
		    console.log(values);
	});
    
	
	
	/**
	 * REGISTRATION FROM VALIDATION
	 */
	
	function validate(formValues){
		var reason = "";
		
		reason += validateUsername(formValues.username);
		reason += validatePassword(formValues.password);
		reason += validateConfirmPassword(formValues.password, formValues.confirmPassword);
		reason += validateEmailAddresss(formValues.email);
		reason += validateConfirmEmail(formValues.email, formValues.confirmEmail);
		reason += validatePhoneNumber(formValues.phoneNumber);
		reason += validateFirstName(formValues.firstName);
		reason += validateLastName(formValues.secondName);
		
		if(reason != ""){
			return false;
		}
		
		return true;
	}
	
	/**
	 * FUNCTION TO VALIDATE USERNAME
	 */
	function validateUsername(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(field.length == 0){
				error = "Please Enter Username \n";
				$(".error_username").html(error);
			}
		}
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE PASSWORD
	 */
	function validatePassword(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(field.length == 0){
				error = "Please Enter Password \n";
				$(".error_password").html(error);
			}
		}
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE CONFIRM PASSWORD
	 */
	function validateConfirmPassword(password, confirmPassword){
		var error = "";

		if(password != confirmPassword ){
			error = "Password Doesn't Match";
			$(".error_confirmPassword").show().html(error);
		}
		
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE FIRSTNAME
	 */
	function validateFirstName(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(field.length == 0){
				error = "Please Enter First Name \n";
				$(".error_firstName").html(error);
			}
		}
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE LASTNAME
	 */
	function validateLastName(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(field.length == 0){
				error = "Please Enter Last Name \n";
				$(".error_secondName").html(error);
			}
		}
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE EMAIL IS TYPED
	 */
	function validateEmailAddresss(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(field.length == 0){
				error = "Please Enter Email \n";
				$(".error_email").html(error);
			}
		}
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE CONFIRM EMAIL
	 */
	function validateConfirmEmail(email, confirmEmail){
		var error = "";

		if(email != confirmEmail){
			error = "Email Doesn't Match";
			$(".error_confirmEmail").show().html(error);
		}
		
		return error;
	}
	
	/**
	 * FUNCTION TO VALIDATE THAT PHONE NUMBER IS ONLY NUMBER
	 */
	function validatePhoneNumber(field){
		var error = "";
		if( typeof(field !== "undefined")){
			if(!field.match("^[0-9]+$")){
				error = "Invalid Type \n";
				$(".error_phoneNumber").html(error);
			}
		}
		return error;
	}
	
	
});
	