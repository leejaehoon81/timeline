define([ 'jquery', 'handlebars' ], function($, handlebars) {
  return {
    init : function() {
    	 $('#chronicle').click(function(e) {
    	        e.preventDefault();
      $.getJSON('mainList.do', function(result) {
        var source = $('#chroTemplate').html();
        var template = handlebars.compile(source);
        var content = template(result);
        $('.haveBox').html(content);
      });
    	 });
    	 $('#mychro').click(function(e) {
    		 e.preventDefault();
    		 $.getJSON('mainList.do', function(result) {
    			 var source = $('#chroTemplate').html();
    			 var template = handlebars.compile(source);
    			 var content = template(result);
    			 $('.haveBox').html(content);
    		 });
    	 });
    } // end of init
  }
});
