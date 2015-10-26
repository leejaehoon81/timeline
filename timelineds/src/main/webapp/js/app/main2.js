define([ 'jquery','app/common' ], function($) {
	
	    	var QueryString = function () {
	  		  // This function is anonymous, is executed immediately and 
	  		  // the return value is assigned to QueryString!
	  		  var query_string = {};
	  		  var query = window.location.search.substring(1);
	  		  query = decodeURIComponent(query);
	  		  console.log(query);
	  		  var vars = query.split("&");
	  		  for (var i=0;i<vars.length;i++) {
	  		    var pair = vars[i].split("=");
	  		        // If first entry with this name
	  		    if (typeof query_string[pair[0]] === "undefined") {
	  		      query_string[pair[0]] = decodeURIComponent(pair[1]);
	  		        // If second entry with this name
	  		    } else if (typeof query_string[pair[0]] === "string") {
	  		      var arr = [ query_string[pair[0]],decodeURIComponent(pair[1]) ];
	  		      query_string[pair[0]] = arr;
	  		        // If third or later entry with this name
	  		    } else {
	  		      query_string[pair[0]].push(decodeURIComponent(pair[1]));
	  		    }
	  		  } 
	  		  console.log(query_string);
	  		  console.log(query_string.no);
	  		  console.log(query_string.mainNo);
	  		    return query_string;
	  		}();
	  		$.ajax(contextRoot + '/json/user/getChro.do', {
	  			method : 'POST',
	  			dataType : 'json',
	  			data : {
	  				mno : QueryString.no,
	  				mainNo : QueryString.mainNo
	  			},
	  			success : function(result) {
	  				if (result.data == 'yes') {
	  					$('#content').load('chronicle/src/index2.html');
	  					
		  			}else{
		  				window.location.href='index.html';
		  			}
	  			}
	  		});
	  
	
});
