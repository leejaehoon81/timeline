var contextRoot = "/timelineds";
$('#modal_logout').css({ "display": "none" });
$('#modal_join').css({ "display": "none" });
$.getJSON(contextRoot + '/json/user/loginInfo.do', function(result) {
	if (result.state == 'yes') {  
		$('#userName').text(result.data.name);
		$('#userEmail').text(result.data.email);
		$('#modal_trigger').css('display', 'none');
		$('#modal_logout').css('display', '');
	} else {
		$('#modal_trigger').css('display', '');
		$('#modal_logout').css('display', 'none');
	}
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
					//console.log($.session.get('user'));
					//location.href='demo1.html';
//					document.location.reload();
					/* $('#cancelBtn').click(); */
					//close_modal(modal); 
					$('#modal_trigger').css({ "display": "none" });
					$('#modal_logout').css({ "display": "" });
					$('#lean_overlay').css({'display': 'none'});
					$('#modal').css({'display': 'none'});
					$('#userName').text(result.userdata.name);
					$('#userEmail').text(result.userdata.email);
					//alert('aaaa');
					//$('#lean_overlay').css({'display': ''});
					// $('#modal').css({'display': ''});


				} else {
					alert('로그인 실패입니다.');

				}
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

				}else{
					alert('회원 가입에 실패하셨습다.');
				}
			}
		});
	});
	
	$('#modal_logout').click(function(){

		$.getJSON(contextRoot + '/json/user/logout.do', function(result) {
			if(result.data=='yes'){
				$('#userName').text('');
				$('#userEmail').text('');
				$('#modal_trigger').css('display', '');
				$('#modal_logout').css('display', 'none');
			}
		});
	});

	$('#nextBnt').click(function(){
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

