$(document).ready(
	function() {
		//1. hide error section
		$("#tpwdError").hide();
		$("#npwdError").hide();
		$("#cpwdError").hide();

		//2. define error variable
		var tpwdError = false;
		var npwdError = false;
		var cpwdError = false;

		//3. validate function
		function validate_tpwd() {
			//validation code here
          var val = $("#tpwd").val();

          var exp = /^[A-Za-z0-9\_\.\@\$]{8,12}$/;
          if (val === "") {
            $("#tpwdError").show();
            $("#tpwdError").html("*Please Enter temporary password");
            $("#tpwdError").css("color", "red");
            tpwdError = false;
          } else if (!exp.test(val)) {
            $("#tpwdError").show();
            $("#tpwdError").html(
              "*Password must be 8-12 characters long, contains only _, $,@"
            );
            $("#tpwdError").css("color", "red");
            tpwdError = false;
          } else {
            $("#tpwdError").hide();
            tpwdError = true;
          }
			return tpwdError;
		}


		function validate_npwd() {
				//validation code here
          var val = $("#npwd").val();

          var exp = /^[A-Za-z0-9\_\.\@\$]{8,12}$/;
          if (val === "") {
            $("#npwdError").show();
            $("#npwdError").html("*Please Enter new password");
            $("#npwdError").css("color", "red");
            npwdError = false;
          } else if (!exp.test(val)) {
            $("#npwdError").show();
            $("#npwdError").html(
              "*Password must be 8-12 characters long, contains only _, $,@"
            );
            $("#npwdError").css("color", "red");
            npwdError = false;
          } else {
            $("#npwdError").hide();
            npwdError = true;
          }
			return npwdError;
		}

		function validate_cpwd() {
			  var val = $("#cpwd").val();

          var exp = /^[A-Za-z0-9\_\.\@\$]{8,12}$/;
          if (val === "") {
            $("#cpwdError").show();
            $("#cpwdError").html("*Please confirm new password");
            $("#cpwdError").css("color", "red");
            cpwdError = false;
          } else if (!exp.test(val)) {
            $("#cpwdError").show();
            $("#cpwdError").html(
              "*Password must be 8-12 characters long, contains only _, $,@"
            );
            $("#cpwdError").css("color", "red");
            cpwdError = false;
          } else {
            $("#cpwdError").hide();
            cpwdError = true;
          }
			return cpwdError;

		}

		//4. link action-event
		$("#tpwd").keyup(function() {
			validate_tpwd();
		});

		$("#npwd").keyup(function() {
			validate_npwd();
		});

		$("#cpwd").keyup(function() {
			validate_cpwd();
		});

	
		//5. on submit
		$("#unlock").submit(function() {
			
			validate_tpwd();
			validate_npwd();
			validate_cpwd();
			if (tpwdError && npwdError && cpwdError)
				return true;
			else
				return false;
		});
	});