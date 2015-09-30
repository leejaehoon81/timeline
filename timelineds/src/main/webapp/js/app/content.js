define(['jquery',
        'app/common',
        'handlebars',
        'bootstrap',
        'init',
        'hide',
        'load-image',
        'jquery.dropotron.min',
        'jquery.scrollgress.min',
        'skel',
        'util',
        'main'
        ], function($){

	return {
		init: function(){
			$('#timelined').click(function(event){
				alert('aaa');
				event.preventDefault();
				$('#content').load('chronicle/src/index.html');
			});
		}
	};
});













