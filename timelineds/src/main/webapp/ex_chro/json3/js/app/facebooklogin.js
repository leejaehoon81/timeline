define(['jquery','app/common'], function($) {
  $('#logoutBtn').click(function(event) {
    event.preventDefault();
    $(document).trigger('logout.success');
  });
  
  return {
    loadLoginInfo: function() {
      $.getJSON(contextRoot + '/json/auth/loginInfo.do', function(result) {
        if (result.state == 'yes') {  
          $('#loginBtn').css('display', 'none');
          $('#userInfo').css('display', '');
        } else {
          $('#loginBtn').css('display', '');
          $('#userInfo').css('display', 'none');
        }
      });
    }
  };
});


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




