requirejs.config({
    baseUrl: 'js',
    paths: {
      'jquery' : 'lib/jquery',
      'bootstrap' : 'lib/bootstrap.min',
      'jquery-easing' : 'lib/jquery.easing.1.3.min',
      'jquery-magnific' : 'lib/jquery.magnific-popup.min',
      'smooth' : 'lib/SmoothScroll',
      'wow' : 'lib/wow.min',
      'main-app' : 'lib/jquery.app',
      'login-register' : 'lib/login-register',
      'facebook' : 'lib/myFacebook',
      'datepicker' : 'lib/bootstrap-datepicker'
    }
});

requirejs(['app/main']);
