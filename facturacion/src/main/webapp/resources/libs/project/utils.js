// Template Settings for Underscore
// Change <% %> for <@ @>

  _.templateSettings = {
    evaluate    : /<@([\s\S]+?)@>/g,
    interpolate : /<@=([\s\S]+?)@>/g,
    escape      : /<@-([\s\S]+?)@>/g
  };

// Variables globales
/* ------------------------------ */

var PATH_LAYOUT 	= '#layout';
var PATH_MODAL 		= '#layout-modal';
var PATH_POPOVER	= '#layout-popover';
var PATH_ALERT 		= '#msg-alert';
var PATH_D_VENDEDOR = '#dashboard-vendedor';
var PATH_D_PRODUCTO = '#dashboard-producto';
var PATH_D_INVOICE  = '#dashboard-facturas';

var PATH_INVOICE_ID = {"2": true, "3": true, "5": true, "6": true, "8": true};	


// Routing
/* ------------------------------ */
var URL_DASHBOARD 		= 'dashboard';

var URL_FACTURAS 		= 'facturas';
var URL_INVOICE_EDIT 	= 'factura/editar/';
var URL_INVOICE_INFO 	= 'factura/info/';

var URL_USERS 		= 'usuarios';
var URL_USER_ADD 	= 'usuario/nuevo';
var URL_USER_EDIT 	= 'usuario/editar/';
var URL_USER_PASS 	= 'usuario/editar-contrasena/';

var URL_CLIENTS		= 'clientes';
var URL_CLIENT_ADD 	= 'cliente/nuevo';
var URL_CLIENT_EDIT = 'cliente/editar/';

// Messages
/* ------------------------------ */

var MSG_USER_PASS_SUCCES = 'La contrase&ntilde;a del usuario se modific&oacute; correctamente';
var MSG_USER_PASS_ERROR = 'Hubo un error al modificar la contrase&ntilde;a del usuario';

// Inovice
var MSG_INVOICE_SAVE_SUCCESS = 'La factura se cargo correctamente';
var MSG_INVOICE_SAVE_ERROR = 'Hubo un error al cargar la factura';
var MSG_CLIENT_SELECTED_ERROR = 'Debes seleccionar un cliente en la parte superior';

// Active
/* ------------------------------ */
function active(x){
	$('.main-menu').find('a').removeClass('active');
	$(x).addClass('active');
};

function convertToDecimal(x){
	x = x.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
	x = x.split('').reverse().join('').replace(/^[\.]/,'');	
	return x;
};

window.AlertView = Backbone.View.extend({
	
	el: PATH_ALERT,	
	
	template: _.template('<p class="<@= type @>"><@= body @></p>'),
	
    initialize: function() {
    	
        this.render();
    
    },

    render: function() {
    	
    	$(this.el).html(this.template(this.model.toJSON())).show().delay(4000).fadeOut('fast');
	    return this; 
	    
    }   
    
});

/*
tpl = {

    // Hash of preloaded templates for the app
    templates: {},

    // Recursively pre-load all the templates for the app.
    // This implementation should be changed in a production environment. All the template files should be
    // concatenated in a single file.
    loadTemplates: function(names, callback) {

        var that = this;

        var loadTemplate = function(index) {
            var name = names[index];
            console.log('Loading template: ' + name);
            $.get('resurces/includes/' + name + '.html', function(data) {
                that.templates[name] = data;
                index++;
                if (index < names.length) {
                    loadTemplate(index);
                } else {
                    callback();
                }
            });
        }

        loadTemplate(0);
    },

    // Get template by name from hash of preloaded templates
    get: function(name) {
        return this.templates[name];
    }

};

*/
(function($){
    $.fn.serializeObject = function(){

        var self = this,
            json = {},
            push_counters = {},
            patterns = {
                "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
                "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
                "push":     /^$/,
                "fixed":    /^\d+$/,
                "named":    /^[a-zA-Z0-9_]+$/
            };


        this.build = function(base, key, value){
            base[key] = value;
            return base;
        };

        this.push_counter = function(key){
            if(push_counters[key] === undefined){
                push_counters[key] = 0;
            }
            return push_counters[key]++;
        };

        $.each($(this).serializeArray(), function(){

            // skip invalid keys
            if(!patterns.validate.test(this.name)){
                return;
            }

            var k,
                keys = this.name.match(patterns.key),
                merge = this.value,
                reverse_key = this.name;

            while((k = keys.pop()) !== undefined){

                // adjust reverse_key
                reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

                // push
                if(k.match(patterns.push)){
                    merge = self.build([], self.push_counter(reverse_key), merge);
                }

                // fixed
                else if(k.match(patterns.fixed)){
                    merge = self.build([], k, merge);
                }

                // named
                else if(k.match(patterns.named)){
                    merge = self.build({}, k, merge);
                }
            }

            json = $.extend(true, json, merge);
        });

        return json;
    };
})(jQuery);

