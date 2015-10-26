requirejs.config({
    baseUrl: 'js',
    paths: {
      'jquery': 'lib/jquery',
      'bootstrap': 'lib/bootstrap.min',
      'handlebars': 'lib/handlebars-v3.0.3',
      'jquery-easing': 'lib/jquery.easing.1.3.min',
      'jquery-magnific': 'lib/jquery.magnific-popup.min',
      'smooth': 'lib/SmoothScroll',
      'wow': 'lib/wow.min',
      'main-app': 'lib/jquery.app',
      'login-register': 'lib/login-register',
      'facebook': 'lib/myFacebook',
      'datepicker': 'lib/bootstrap-datepicker',
      'jquery.ui.widget': '../../js/lib/vendor/jquery.ui.widget',
      'load-image.all': '../../js/lib/load-image.all.min',
      'load-image': '../../js/lib/load-image',
      'load-image-ios': '../../js/lib/load-image-ios',
      'load-image-orientation': '../../js/lib/load-image-orientation',
      'load-image-meta': '../../js/lib/load-image-meta',
      'load-image-exif': '../../js/lib/load-image-exif',
      'load-image-exif-map': '../../js/lib/load-image-exif-map',
      'canvas-to-blob': '../../js/lib/canvas-to-blob.min',
      'jquery.iframe-transport': '../../js/lib/jquery.iframe-transport',
      'jquery.fileupload': '../../js/lib/jquery.fileupload',
      'jquery.fileupload-process': '../../js/lib/jquery.fileupload-process',
      'jquery.fileupload-image': '../../js/lib/jquery.fileupload-image',
      'jquery.fileupload-audio': '../../js/lib/jquery.fileupload-audio',
      'jquery.fileupload-video': '../../js/lib/jquery.fileupload-video',
      'jquery.fileupload-validate': '../../js/lib/jquery.fileupload-validate'
    }
});

requirejs(['app/main2']);
