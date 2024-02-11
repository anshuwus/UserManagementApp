$(document).ready(
	function() {
		//1. hide error section
		$("#fNameError").hide();
		$("#lNameError").hide();
		$("#emailError").hide();
		$("#phnoError").hide();

		//2. define error variable
		var fNameError = false;
		var lNameError = false;
		var emailError = false;
		var phnoError = false;

		//3. validate function
		function validate_fName() {
			var val = $("#fName").val();
			var exp = /^[A-Za-z\s]{3,60}$/;
			if (val == "") {
				$("#fNameError").show();
				$("#fNameError").html("*Please enter your first name");
				$("#fNameError").css("color", "red");
				fNameError = false;
			} else if (!exp.test(val)) {
				$("#fNameError").show();
				$("#fNameError").html("*Please enter your first name");
				$("#fNameError").css("color", "red");
				fNameError = false;
			} else {
				$("#fNameError").hide();
				fNameError = true;
			}

			return fNameError;
		}


		function validate_lName() {
			var val = $("#lName").val();
			var exp = /^[A-Za-z\s]{3,60}$/;
			if (val == "") {
				$("#lNameError").show();
				$("#lNameError").html("*Please enter your last name");
				$("#lNameError").css("color", "red");
				lNameError = false;
			} else if (!exp.test(val)) {
				$("#lNameError").show();
				$("#lNameError").html("*Please enter your last name");
				$("#lNameError").css("color", "red");
				lNameError = false;
			} else {
				$("#lNameError").hide();
				lNameError = true;
			}

			return lNameError;
		}




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
					$.ajax({
					type: "GET",
					url: "/checkEmail",
					data: {
						"email": $("#email").val()
					},
					success: function(result) {
						if (result != '') {
							$("#emailError").show();
							$("#emailError").html('*' + result);
							$("#emailError").css('color', 'red');
							emailError = false;
						}//if
						else {
							$("#emailError").hide();
							emailError = true;
						}//else
					},//success function
					error: function(result) {
						alert('error' + result);
					}
				});
			}

			return emailError;
		}


		function validate_phno() {
			var val = $("#phno").val();
			var exp = /^(0|91)?[6-9][0-9]{9}$/;
			if (val == "") {
				$("#phnoError").show();
				$("#phnoError").html(
					"*Please enter valid 10 digit mobile no.");
				$("#phnoError").css("color", "red");
				phnoError = false;
			} else if (!exp.test(val)) {
				$("#phnoError").show();
				$("#phnoError").html(
					"*Please enter valid 10 digit mobile no.");
				$("#phnoError").css("color", "red");
				phnoError = false;
			} else {
				$("#phnoError").hide();
				phnoError = true;
			}

			return phnoError;
		}

		//4. link action-event
		$("#fName").keyup(function() {
			validate_fName();
		});

		$("#lName").keyup(function() {
			validate_lName();
		});

		$("#email").keyup(function() {
			validate_email();
		});

		$("#phno").keyup(function() {
			validate_phno();
		});

		//dependent dropdown
		$("#country").on("change", function() {
			$.ajax({
				type: "GET",
				url: "/stateDropdown",
				data: { counId: $("#country").val() },
				success: function(result) {
					$("#stIcon").hide();
					$("#state").hide();
					$("#stLabel").hide();
					$("#div").hide();
					$("#stateDrop").html(result);
				},
				error: function(result) {
					alert('error');
				}
			})
		});
		
		$("#state").on("change", function() {
			$.ajax({
				type: "GET",
				url: "/cityDropdown",
				data: { stateId: $("#state").val() },
				success: function(result) {
					$("#cIcon").hide();
					$("#city").hide();
					$("#cLabel").hide();
					$("#div").hide();
					$("#cityDrop").html(result);
					//alert('state success');
				},
				error: function(result) {
					alert('error');
				}
			})
		});
		
		$("#city").on("change", function() {
			$.ajax({
				type: "GET",
				url: "/cityId",
				data: { cityId: $("#city").val() },
				success: function(result) {
					
					//alert('city success');
				},
				error: function(result) {
					alert('error');
				}
			})
		});

		//5. on submit
		$("#userForm").submit(function() {
			
			validate_fName();
			validate_lName();
			validate_email();
			validate_phno();
			if (fNameError && lNameError && emailError
				&& phnoError)
				return true;
			else
				return false;
		});
	});