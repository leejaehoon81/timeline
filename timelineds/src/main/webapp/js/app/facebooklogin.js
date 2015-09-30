$('#side-profile').click(function () {
	console.log("profile clicked!! ");
	Login();
});

$('#modal_logout').click(function () {
	console.log("logout clicked!! ");

	FB.api("/me/permissions", "DELETE", function (response) {
		console.log("delete");
		console.log(response); //gives true on app delete success 
	});

	FB.logout(function () {
		document.location.reload();
	});
});


window.fbAsyncInit = function () {

	FB.init({
		appId: 928364283894474, // Set YOUR APP ID
		status: true, // check login status
		cookie: true, // enable cookies to allow the server to access the session
		xfbml: true // parse XFBML
	});


	FB.Event.subscribe('auth.authResponseChange', function (response) {
		if (response.status === 'connected') {
			console.log('Connected to Facebook');
			//SUCCESS
			$('#modal_join').css('display', 'none');
			$('#modal_trigger').css('display', 'none');
			$('#modal_my').css('display', '');
			$('#modal_logout').css('display', '');
			
			$('.modal_close').trigger('click');
		} else if (response.status === 'not_authorized') {
			console.log('Failed to Connect');
			//FAILED
		} else {
			console.log('Logged Out');
			//UNKNOWN ERROR
		}
	});

};

function Login() {
	console.log("MY> Login()..Excute..!!");
	FB.login(function (response) {
		if (response.authResponse) {
			getUserInfo();
		} else {
			console.log('User cancelled login or did not fully authorize.');
		}
	}, {
		scope: 'public_profile,email,user_photos,user_friends, user_birthday'
			
	});

}

function insertUserInfo(response) {
	var contextRoot = '/timelineds2';
	$.ajax(contextRoot + '/json/user/insert.do',
		{
		method: 'POST',
		dataType: 'json',
		data: {
			name: response.name,
			email: response.email,
			facebookid: response.id,
			/*imgUrl: response.picture.data.url*/
		},
		success: function(result) {
			if (result.data == 'yes') {
				$('#cancelBtn').click();
				console.log("User Info Input Success..!!");
			} else {
				console.log("User Info Input Fail..!!");
			}
		}
		});
}


function getUserInfo() {
	FB.api('/me?fields=name,email,picture,friends,birthday', function (response) {

		console.log(response);
		//mid-spot Database insert "User Info"
		insertUserInfo(response);
		console.log("정보확인해보자 !!" + response);
		//Change User name, Profile Image
		$('#userName').text(response.name);
		/*$('#side-profile').attr('src', response.picture.data.url);*/

	});
}

function Logout() {
	FB.logout(function () {
		document.location.reload();
	});
}

//Load the SDK asynchronously
(function (d) {;
var js, id = 'facebook-jssdk',
ref = d.getElementsByTagName('script')[0];
if (d.getElementById(id)) {
	return;
}
js = d.createElement('script');
js.id = id;
js.async = true;
js.src = "//connect.facebook.net/en_US/all.js";
ref.parentNode.insertBefore(js, ref)
}(document));


