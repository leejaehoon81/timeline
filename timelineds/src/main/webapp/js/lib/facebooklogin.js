// This function is called when someone finishes with the Login
// Button.  See the onlogin handler attached to it in the sample
// code below.



function checkLoginState() {
	FB.getLoginStatus(function (response) {
		statusChangeCallback(response);
	});
}

window.fbAsyncInit = function () {
	FB.init({
		appId: '928364283894474',
		cookie: true, // enable cookies to allow the server to access 
		// the session
		xfbml: true, // parse social plugins on this page
		version: 'v2.2' // use version 2.2
	});

	// Now that we've initialized the JavaScript SDK, we call 
	// FB.getLoginStatus().  This function gets the state of the
	// person visiting this page and can return one of three states to
	// the callback you provide.  They can be:
	//
	// 1. Logged into your app ('connected')
	// 2. Logged into Facebook, but not your app ('not_authorized')
	// 3. Not logged into Facebook and can't tell if they are logged into
	//    your app or not.
	//
	// These three cases are handled in the callback function.

	FB.getLoginStatus(function (response) {
		FB.getLoginStatus(function (response) {
			if (response.status === 'connected') {

				FB.api('/me?fields=name,email,picture,friends', function (response) {
					console.log(response);
					if (response) {
						$.ajax(contextRoot + '/json/user/facebooklogin.do', {
							method:'POST',
							dataType:'json',
							data: {
								email:response.email,
								fbID:response.id,
								name:response.name
							},
							success:function(result){
							if(result.data == 'yes'){
								$('#userEmail').text(response.email);
								$('#userName').text(response.name);
								$('#mypage').show();
								$('#modal_trigger').css({ "display": "none" });
								$('#logOut').show();
							}else{
								$.ajax(contextRoot+'/json/user/facebookInsert.do',{
									method:'POST',
									dataType:'json',
									data: {
										email:response.email,
										fbID:response.id,
										name:response.name
									},
									success:function(result){
										if(result.data=='success'){
											$('#userEmail').text(result.userdata.email);
											$('#userName').text(result.userdata.name);
											$('#mypage').show();
											$('#modal_trigger').css({ "display": "none" });
											$('#logOut').show();
										}else{
											console.log(result);
										}
									}
								});
							}
							}
						});
//						var image = document.getElementById('image');
//						image.src = 'http://graph.facebook.com/' + response.id + '/picture';
//						var name = document.getElementById('name');
//						name.innerHTML = response.name
							/*var url = '../../demo1.html';   
													 	$(location).attr('href',url);*/

					}
				});

				console.log('connected');

				
			
				/* loginBtn.css('display', 'none');
				$('#userInfo').css('display', 'none');
				$('#logoutBtn').css('display', ''); */

//				url = "demo1.html";
//				$(location).attr("href", url);

			} else if (response.status === 'not_authorized') {

			} else {
				console.log('logout');

				/* $('#loginBtn').css('display', ''); */

			}
		});


		FB.Event.subscribe('auth.login', function (response) {
			document.location.reload();
		});
		FB.Event.subscribe('auth.logout', function (response) {
			document.location.reload();
		});

	});
	$('#logOut').click(function () {
		console.log("logout clicked!! ");

		FB.api("/me/permissions", "DELETE", function (response) {
			console.log("delete");
			console.log(response); //gives true on app delete success 
		});

		$.getJSON(contextRoot + '/json/user/logout.do', function(result) {
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
};

// Load the SDK asynchronously
(function (d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));