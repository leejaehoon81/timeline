define([ 'jquery' ], function($) {
  
  return {
    
    init : function() {
      $('#chronicle').click(function(e) {
        e.preventDefault();
        $.getJSON(contextRoot + '/json/user/loginInfo.do', function(result) {
          if (result.state == 'yes') {
            //$('#content').load('chronicle/src/index.html');
        	  openMyChronicleModal();
          } else {
            openLoginModal();
          }
        });
        
      });
    } // end of init
  
  }
});
