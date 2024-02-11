$(document).ready(
	function() {
		//1. hide error section
		$("#emailError").hide();
		$("#pwdError").hide();

		//2. define error variable
		var emailError = false;
		var pwdError = false;


		function validate_email() {
			var val = $("#email").val();
			var exp = /^([a-zA-Z0-9_\.\-\+])+\@gmail.com+$/;
			if (val == "") {
				$("#emailError").show();
				$("#emailError").html("*Please enter your email id");
				$("#emailError").css("color", "red");
				emailError = false;
			} else if (!exp.test(val)) {
				$("#emailError").show();
				$("#emailError").html("*Please enter your valid email id");
				$("#emailError").css("color", "red");
				emailError = false;
			} else {
				$("#emailError").hide();
				emailError = true;
			}

			return emailError;
		}

		function validate_pwd() {
			//validation code here
			var val = $("#pwd").val();

			var exp = /^[A-Za-z0-9\_\.\@\$]{8,12}$/;
			if (val === "") {
				$("#pwdError").show();
				$("#pwdError").html("*Please Enter password");
				$("#pwdError").css("color", "red");
				pwdError = false;
			} else if (!exp.test(val)) {
				$("#pwdError").show();
				$("#pwdError").html(
					"*Password must be 8-12 characters long, contains only _, $,@"
				);
				$("#pwdError").css("color", "red");
				pwdError = false;
			} else {
				$("#pwdError").hide();
				pwdError = true;
			}
			return pwdError;
		}
		//4. link action-event
		$("#email").keyup(function() {
			validate_email();
		});
$("#pwd").keyup(function() {
			validate_pwd();
		});
		//5. on submit
		$("#signIn").submit(function() {

			validate_email();
			validate_pwd();
			if (emailError && pwdError)
				return true;
			else
				return false;
		});
	});