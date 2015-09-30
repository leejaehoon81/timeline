define(['jquery',
        'app/common'
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













