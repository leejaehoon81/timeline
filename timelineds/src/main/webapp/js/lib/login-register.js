/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: http://creative-tim.com
 * 
 */

var contextRoot = '/timelineds';

function showRegisterForm(){
    $('.loginBox, .fb_login, .login-footer').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.fb_register').fadeIn('fast');
        $('.register-footer').fadeIn('fast');
        $('.modal-title').html('Register with');
    }); 
    $('.warning').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox, .fb_register, .register-footer').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.fb_login').fadeIn('fast');
        $('.login-footer').fadeIn('fast');    
        /*$('.modal-title').html('Login with');*/
    });       
     $('.warning').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
}

function openInfoModal(){
  showLoginForm();
  setTimeout(function(){
      $('#infoModal').modal('show');    
  }, 230);
}

function openAlert(){
  showLoginForm();
  setTimeout(function(){
    $('#alertModal').modal('show');    
  }, 230);
}

function openMyChronicleModal(){
  showLoginForm();
  setTimeout(function(){
    $('#myChronicleModal').modal('show');    
  }, 230);
}

function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
}

function loginAjax(){
	$.ajax(contextRoot + '/json/user/login.do', {
		method : 'POST',
		dataType : 'json',
		data : {
			email : $('#userEmail').val(),
			password : $('#userPass').val()
		},
		success : function(result) {
			if (result.data == 'yes') {
				window.location.reload();
				loginInfo();
				$('#loginPass').val('');
				$('#loginEmail').val('');
			} else {
				shakeModal();
			}
		}
	});
}

function loginInfo() {
	$.getJSON(contextRoot + '/json/user/loginInfo.do', function(result) {
		if (result.state == 'yes') {
			$('#emailInfo').text(result.data.email);
			$('.infoEmail').text(result.data.email);
			$('.infoName').text(result.data.name);
			/*$('#nameInfo').text(result.data.name);*/
			$('#loginBtn').hide();
			$('#mypage').show();
			
			sessionStorage.setItem('mkey', result.data.mno);
			if (result.loding == 'loding') {
         $('#content').load('chronicle/src/index.html');
      }
		} else {
			/*getUserInfo();*/
		}
	});
}

$('#createAcc').click(function() {
	sessionStorage.setItem('email', $('#registerEmail').val());
	sessionStorage.setItem('password', $('#registerPass').val());
	$.ajax(contextRoot + '/json/user/insert.do', {
		method : 'POST',
		dataType : 'json',
		data : {
			email : $('#registerEmail').val(),
			password : $('#registerPass').val()
		},
		success : function(result) {
			
			if (result.data == 'success') {
				$.ajax(contextRoot + '/json/user/login.do', {
					method : 'POST',
					dataType : 'json',
					data : {
						email : sessionStorage.getItem('email'),
						password : sessionStorage.getItem('password') 
					},
					success: function(result) {
						if (result.data == 'yes') {
							window.location.reload();
							loginInfo();
							$('#loginPass').val('');
							$('#loginEmail').val('');
						} else {
							shakeModal();
						}
					}
				});
				
				$('#registerEmail').val('');
				$('#registerPass').val('');
				$('#password_confirmation').val('');
				$('.close').click();
			} else {
				console.log('회원가입 실패');
			}
		}
	});
});

$('#logout').click(function(event) {
	 event.preventDefault();
	 FBLogout();
	 $.getJSON(contextRoot + '/json/auth/logout.do', function(result) {
		 /*$(document).trigger('logout.success');*/
		 window.location.reload();
		 FBlogout();
	 });
});

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.warning').addClass('alert alert-danger').html("이메일과 비밀번호를 확인해 주세요");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}


$('#sample1').on('click', function(e) {
  e.preventDefault();
  $.ajax(contextRoot + '/json/user/login.do', {
    method : 'POST',
    dataType : 'json',
    data : {
      email : 'steven',
      password : 1111
    },
    success : function(result) {
      if (result.data == 'yes') {        
        console.log('main open');
        $.chronicle.getMain(16);
      } else {
        console.log('샘플 실패');
      }
    }
  });
});

$('#sample2').on('click', function(e) {
  e.preventDefault();
  $.ajax(contextRoot + '/json/user/login.do', {
    method : 'POST',
    dataType : 'json',
    data : {
      email : 'steven',
      password : 1111
    },
    success : function(result) {
      if (result.data == 'yes') {        
        console.log('main open');
        $.chronicle.getMain(21);
      } else {
        console.log('샘플 실패');
      }
    }
  });
});

   