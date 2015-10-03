var contextRoot = '/timelineds';

$('#loginEmail').click(function() {
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
			} else {
				console.log('로그인 실패');
			}
		}
	});
});

$('#createAcc').click(function() {
	$.ajax(contextRoot + '/json/user/insert.do', {
		method : 'POST',
		dataType : 'json',
		data : {
			email : $('#registerEmail').val(),
			password : $('#registerPass').val(),
		},
		success : function(result) {
			if (result.data == 'success') {
				/*window.location.reload();*/
				loginInfo();
				$('#registerEmail').val('');
				$('#registerPass').val('');
				$('#password_confirmation').val('');
			} else {
				console.log('회원가입 실패');
			}
		}
	});
});

function loginInfo() {
	$.getJSON(contextRoot + '/json/user/loginInfo.do', function(result) {
		console.log('call loginInfo');
		if (result.state == 'yes') { 
			$('#emailInfo').text(result.data.email);
			$('#nameInfo').text(result.data.name);
			$('#mypage').show();
		} else {
			console.log('none');
		}
	});
};
