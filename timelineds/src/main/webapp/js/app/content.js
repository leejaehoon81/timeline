define([ 'jquery' ], function($) {
  return {
    init : function() {
      $('#chronicle').click(function(e) {
        e.preventDefault();
        $('#content').load('chronicle/src/index.html');
      });
    }
  };
});
