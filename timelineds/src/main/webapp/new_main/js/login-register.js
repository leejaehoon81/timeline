/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: http://creative-tim.com
 * 
 */
function showRegisterForm(){
    $('.loginBox, .fb_login, .login-footer').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.fb_register').fadeIn('fast');
        $('.register-footer').fadeIn('fast');
        $('.modal-title').html('Register with');
    }); 
    $('.warning').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox, .fb_register, .register-footer').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.fb_login').fadeIn('fast');
        $('.login-footer').fadeIn('fast');    
        $('.modal-title').html('Login with');
    });       
     $('.warning').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}

function loginAjax(){
    /*   Remove this comments when moving to server
    $.post( "/login", function( data ) {
            if(data == 1){
                window.location.replace("/home");            
            } else {
                 shakeModal(); 
            }
        });
    */

/*   Simulate warning message from the server   */
     shakeModal();
}

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.warning').addClass('alert alert-danger').html("Invalid email/password combination");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}

   