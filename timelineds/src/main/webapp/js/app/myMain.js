define([ 'jquery', 'handlebars' ], function($, handlebars) {
  return {
    init : function() {
      $.getJSON('mainList.do', function(result) {
        var source = $('#chroTemplate').html();
        var template = handlebars.compile(source, {
          ignoreStandalone : true
        });
        var content = template(result);
        $('.haveBox').html(content);
      });
    } // end of init
  }
});
