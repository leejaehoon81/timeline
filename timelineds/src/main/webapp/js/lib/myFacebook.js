(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id))
    return;
  js = d.createElement(s);
  js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

window.fbAsyncInit = function() {
  FB.init({
    appId : 421279661404306,
    cookie : true, // enable cookies to allow the server to access
    // the session
    xfbml : true, // parse social plugins on this page
    version : 'v2.3' // use version 2.3
  });

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
};

// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {

  if (response.status === 'connected') {
    // Logged into your app and Facebook.
    // we need to hide FB login button
    $('#fblogin').hide();
    // fetch data from facebook
    getUserInfo();
  } else if (response.status === 'not_authorized') {
    // The person is logged into Facebook, but not your app.
    $('#status').html('Please log into this app.');
  } else {
    // The person is not logged into Facebook, so we're not sure if
    // they are logged into this app or not.
    $('#status').html('Please log into facebook');
  }
}

// This function is called when someone finishes with the Login
// Button. See the onlogin handler attached to it in the sample code below.
function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}

function FBLogin() {
  FB.login(function(response) {
    if (response.authResponse) {
      getUserInfo(); // Get User Information.
      $('#loginBtn').hide();
      $('.close').click();
    } else {
      alert('Authorization failed.');
    }
  }, {
    scope : 'public_profile,email'
  });
}

function FBLogout() {
  FB.logout(function(response) {
    
  });
}



function getUserInfo() {
  FB.api('/me?fields=name,email,picture,friends,birthday', function (response) {
    console.log(response);
    /*insertUserInfo(response);*/ 
    $('#emailInfo').text(response.email);
    $('#loginBtn').hide();
    $('#mypage').show();
    
    $('#infoPic').html("<img src='" + response.picture.data.url + "'/>");
    $('#infoEmail').text(response.email);
    $('#infoName').text(response.name);
  });
}

function insertUserInfo(response) {
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




/*function getUserInfo() {
  FB.api('/me', function(response) {
    $.ajax({
      type : "POST",
      dataType : 'json',
      data : response,
       url: 'check_user.php', 
      success : function(msg) {
        console.log(msg);
        if (msg.error == 1) {
          alert('Something Went Wrong!');
        } else {
          $('#fbstatus').show();
          $('#fblogin').hide();
          $('#fbname').text("Name : " + msg.name);
          $('#fbemail').text("Email : " + msg.email);
          $('#fbfname').text("First Name : " + msg.first_name);
          $('#fblname').text("Last Name : " + msg.last_name);
          $('#fbid').text("Facebook ID : " + msg.id);
          $('#fbimg').html(
              "<img src='http://graph.facebook.com/" + msg.id
                  + "/picture'>");
        }
      }
    });

  });
}*/