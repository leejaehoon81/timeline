define(['jquery',
        'app/common',
        'leanmodal',
        'handlebars',
        'bootstrap',
        'flip',
        'facebooklogin',
        'init',
        'hide',
        'load-image',
        'jquery.dropotron.min',
        'jquery.scrollgress.min',
        'skel',
        'util',
        'main'
        ], function($) {
  $('#page-wrapper > header').load('header.html');
  $('#content').load('index1.html');
/*
  $('#boardMenu').click(function(event) {
    event.preventDefault();
    $('#content').load('sub/board.html');
  });

  $('#memberMenu').click(function(event) {
    event.preventDefault();
    $('#content').load('sub/member.html');
  });
*/
 
  $(document).on('login.success', function(event) {
	  
    //특정 모듈만 가져오기
	  var header = require('app/header');
    header.loadLoginInfo();
    //$('#content').load('sub/board.html');
  });

  $(document).on('logout.success', function(event) {
    //$('#content').load('sub/auth.html');
	  var header = require('app/header');
    header.loadLoginInfo();
  });

  
});











