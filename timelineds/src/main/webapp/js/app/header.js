define(['jquery',
        'app/common',
        'leanmodal',
        'handlebars',
        'bootstrap',
        'flip',
        'facebooklogin',
        'init',
        'hide',
        'load-image',
        'jquery.dropotron.min',
        'jquery.scrollgress.min',
        'skel',
        'util',
        'main'
        ], function($) {
	
	return {
		loadLoginInfo: function() {
			$.getJSON(contextRoot + '/json/user/loginInfo.do', function(result) {
				//alert(result.state);
				if (result.state == 'yes') {  
					$('#userEmail').text(result.data.email);
					$('#userName').text(result.data.name);
					//$('#userInfo').show();
					$('#mypage').show();
					$('#modal_trigger').css({ "display": "none" });
					$('#logOut').show();
					
				} else {
					$('#userName').text('');
					$('#userEmail').text('');
					$('#userInfo').css('display', 'none');
					$('#modal_my').css('display', 'none');
					$('#logOut').css('display', 'none');
					/*$('#modal_join').css('display', '');*/
					$('#modal_trigger').css('display', '');
					$('#mypage').css('display', 'none');
				}
			});
		    },
		init: function(){
			 var moduleObj = this;
			 moduleObj.loadLoginInfo();
			 $('#logOut').css('display', 'none');
			 $('#userInfo').css('display', 'none');
			 $('#mypage').css('display', 'none');
			 $("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".modal_close" });
			 $("#home").click(function(){
				 event.preventDefault();
				// $('#content').load('index1.html');
			 });
			 $("#login_form").click(function(){
				 $(".social_login").hide();
				 $(".user_login").show();
				 return false;
			 });
			 
			 // Calling Register Form
			 $("#register_form").click(function(){
				 $(".social_login").hide();
				 $(".user_register").show();
				 $(".header_title").text('Register');
				 return false;
			 });
			 
			 // Going back to Social Forms
			 $(".back_btn").click(function(){
				 $(".user_login").hide();
				 $(".user_register").hide();
				 $(".social_login").show();
				 $(".header_title").text('Login');
				 return false;
			 });
			 
			 
			 $('#loginBtn').click(function(event) {
				 event.preventDefault();
				 $('#content').load('sub/auth.html');
			 });
			 
			 $('#logoutBtn').click(function(event) {
				 event.preventDefault();
				 $.getJSON(contextRoot + '/json/auth/logout.do', function(result) {
					 $(document).trigger('logout.success');
				 });
			 });
			 
			 $('#submit').click(function () {

					console.log("submit btn click..!!");

					$.ajax(contextRoot + '/json/user/login.do',
							{
						method: 'POST',
						dataType: 'json',
						data: {
							email: $('#loginEmail').val(),
							password: $('#loginPass').val(),
						},
						success: function(result) {
							console.log(result)
							if (result.data == 'yes') {
								$('.modal_close').trigger('click');
								$('#userEmail').text(result.userdata.email);
								$('#userName').text(result.userdata.name);
								//$('#userInfo').show();
								$('#mypage').show();
								$('#modal_trigger').css({ "display": "none" });
								$('#logOut').show();
								
								//$('#modal_logout').css({ "display": "" });
								//$('#lean_overlay').css({'display': 'none'});
								//$('#modal').css({'display': 'none'});
								//$('#userName').text(result.userdata.name);
								//$('#userEmail').text(result.userdata.email);
								$('#loginPass').val('');
								$('#loginEmail').val('');
								$(document).trigger('login.success');
								
							} else {
								alert('로그인 실패입니다.');
								$('#loginPass').val('');
								$('#loginPass').focus();
							}
						}
							});

				});

			 $('#logOut').click(function(){
				 event.preventDefault();
				
				$.getJSON(contextRoot + '/json/user/logout.do', function(result) {
					 if(result.face=='yes'){
						 FB.api("/me/permissions", "DELETE", function (response) {
								console.log("delete");
								console.log(response); //gives true on app delete success 
						});
						 
						 FB.logout(function () {
								document.location.reload();
							});
					}
					 if(result.data=='yes'){
						 $(document).trigger('logout.success');
						 $('#userName').text('');
						 $('#userEmail').text('');
						 $('#userInfo').css({ "display": "none" });
						 $('#modal_my').css({ "display": "none" });
						 $('#logOut').css({ "display": "none" });
						 /*$('#modal_join').css('display', '');*/
						 $('#modal_trigger').css({ "display": "" });
						 $('#mypage').css({ "display": "none" });
					 }
				});
			});
			 
				$('#createAcc').click(function() {
					$.ajax(contextRoot + '/json/user/insert.do', {
						method : 'POST',
						dataType : 'json',
						data: {
							email : $('#email1').val(),
							password : $('#password1').val(),
						},
						success : function(result) {
							console.log(result);
							if(result.data == 'success') {
								alert('회원가입이 성공하셨습니다.');
								$('.modal_close').trigger('click');

							}else{
								alert('회원 가입에 실패하셨습다.');
								$('#loginPass').val('');
								$('#loginPass').focus();
							}
						}
					});
				});

				
		}
	};

});


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




