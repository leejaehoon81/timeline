	$(function(){
		
		$("#register_form").click(function(){
			$("#loginform").hide();
			$(".user_register").show();
			return false;
		});

		
		$(".back_btn").click(function(){
		
			$(".user_register").hide();
			$("#loginform").show();
			return false;
		});

	})

