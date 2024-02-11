$(document).ready(
	function() {
		//1. hide error section
		$("#emailError").hide();

		//2. define error variable
		var emailError = false;
	

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

		//4. link action-event
		$("#email").keyup(function() {
			validate_email();
		});

		//5. on submit
		$("#forgot").submit(function() {

			validate_email();
			if (emailError)
				return true;
			else
				return false;
		});
	});