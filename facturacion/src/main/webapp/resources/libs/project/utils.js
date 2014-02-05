// Template Settings for Underscore
// Change <% %> for <@ @>

_.templateSettings = {
  evaluate    : /<@([\s\S]+?)@>/g,
  interpolate : /<@=([\s\S]+?)@>/g,
  escape      : /<@-([\s\S]+?)@>/g
};


// Variables globales
/* ------------------------------ */

PATH_LAYOUT = $('#layout');

/*
var utils = {

  active: function(options){

    var configuracion = {
      item: ''
    };

    var opts = $.extend({}, configuracion, options);  

    // remove actives
    $('.btn-menu').removeClass('active');

    // add active
    $(opts.item).addClass('active');

  }

};

var template = {

  render: function(options){

    var configuracion = {
      html: '',
      response: '',
      callback: function() {}
    };

    var opts = $.extend({}, configuracion, options);  

    $.get(opts.html, function( data ) {
        
      PATH_LAYOUT.html(  _.template( data, opts.response ) );  
      
      opts.callback(data);

    });

  } 

};


var template = {

  render: function(options){

    var configuracion = {
      html: '',
      callback: function() {}
    };

    var opts = $.extend({}, configuracion, options);  

    $.get(opts.html, function( data ) {
        
      opts.callback(data);

    });

  } 

};

var service = {

  get: function(options){

    var configuracion = {
      url: '',
      type: 'GET',
      data: '',
      callback: function(){}
    };

    var opts = $.extend({}, configuracion, options); 

    $.ajax({
      type: opts.type,
      dataType:"json",
      data: opts.data,
      url: opts.url,
      async: true,
      success: function (response){
        opts.callback(response);
      },
      cache:false,
      error: function (request, status, error){

      },
      beforeSend: function(){

      },
      complete: function(){
        
      }
    });

  }

};
*/