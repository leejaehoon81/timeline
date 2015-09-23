$('#modal_logout').css({ "display": "none" });
$('#modal_join').css({ "display": "none" });
$('#submit').click(function () {
	console.log("submit btn click..!!");

	var contextRoot = "/timelineds";

	$.ajax(contextRoot + '/json/user/checkUser.do',
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
				console.log(result.userdata.name);
				$('#userEmail').text(result.userdata.name);
				//location.href='demo1.html';
//				document.location.reload();
				/* $('#cancelBtn').click(); */
				//close_modal(modal); 
				$('#modal_trigger').css({ "display": "none" });
				$('#modal_logout').css({ "display": "" });
				$('#lean_overlay').css({'display': 'none'});
				console.log($('#lean-overlay'));
				 $('#modal').css({'display': 'none'});
				
				 
			} else {
				alert('로그인 실패입니다.');

			}
		}
			});

});

$('#createAcc').click(function() {
	var contextRoot = "/timelineds";
	alert($('#email1').val());
	alert($('#password1').val());
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
				 
			}else{
				alert('회원 가입에 실패하셨습다.');
			}
		}
	});
});

$('#nextBnt').click(function(){
	var contextRoot="/timelineds";
	$.ajax(contextRoot+'/json/user/insertName.do',{
		method : 'POST',
		dataType : 'json',
		data: {
			name : $('#name').val(),
			year : $('#year').val(),
			month:$('#month').val(),
			day: $('#day').val(),
		},
		success: function(result) {
			if(result.data == 'success'){
				alert('감사합니다.');
			}else{
				alert('다시 입력해주세요.');
			}
		}
	});
});