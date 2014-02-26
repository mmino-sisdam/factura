

window.Client = Backbone.Model.extend({
	urlRoot: "clientes",
	defaults: {
		"id"				: null,
	    "nombre"			: "",
	    "cuit"				: "",
	    "direccion"			: "",
	    "localizacion"		: "",
	    "idTipoIVA"			: "",
	    "idTipoRetencion"	: ""
	  }
});

window.ClientCollection = Backbone.Collection.extend({
	url: "clientes"
});

/*
 * 	Vision total de clientes
 * */

window.ClientsView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-clientes",

	template: _.template( $('#tmpl-list-clients').html() ),

	events: {
		'click .btn-add'		: 'client_add',
		'click .btn-edit'		: 'client_edit'
	},

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {
		
		active(this.active);
		
	    $(this.el).html(this.template(this.model.toJSON()));
	    	    		 
	    return this;

	},
	
	client_add: function(){
		
		app.navigate(URL_CLIENT_ADD, true);
		
	},
	
	client_edit: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_CLIENT_EDIT + id, true);		
		
	}
	
});


/*
 * 	Creacion de cliente
 * */

window.NewClientView = Backbone.View.extend({
	
	el: PATH_LAYOUT,
	
	active:".btn-clientes",

	template: _.template( $('#tmpl-new-client').html() ),

    events: {
        'click .btn-accept': 'accept',
        'click .btn-cancel': 'cancel'
    },

	initialize: function () {
		
		$(this.el).unbind();
		
		this.model.fetch();
		this.model.bind('change', this.render, this);

	}, 

	render: function () {
		
		active(this.active);

		$(this.el).html(this.template(this.model.toJSON()));
	    return this;
	    
	   

	},

	// Btn click Aceptar / Save cliente
    accept: function() {
    	    	    	
    	if( $('#frm-new-client').valid() ){
    		
	    	this.post = new ClientCollection();
	    	
	    	this.post.create({
	    		"id"				: null,
	    	    "nombre"			: $("input[name='nombre']").val(),
	    	    "cuit"				: $("input[name='cuit']").val(),
	    	    "direccion"			: $("input[name='direccion']").val(),
	    	    "idTipoIVA"			: $("select[name='idTipoIVA'] option:selected").val(),
	    	    "idTipoRetencion"	: $("select[name='idTipoRetencion'] option:selected").val()
	    	} , {
				success: function(response) {
					
					var msg = AlertModel.set({
	            		'type': 'success',
	            		'body': 'El cliente se creo correctamente'
	            	});
	            	
	            	new AlertView({model: msg });
				
					app.navigate(URL_CLIENTS, true);
					
				},
	            error : function(err, response) {
	            	
	            	var msg = AlertModel.set({
	            		'type': 'error',
	            		'body': 'Hubo un error al cargar el cliente'
	            	});
	            	
	            	new AlertView({model: msg });       
	        		
	            }
			}); 
    	}else{
  
        	var msg = AlertModel.set({
        		'type': 'error',
        		'body': 'Completa los campos requeridos'
        	});
        	
        	new AlertView({model: msg }); 
        	
    	}
    	
    },
    
    cancel: function(){
    	
    	app.navigate(URL_CLIENTS, true);
    	
    }

});


/*
 * 	Edicion de cliente
 * */

window.EditClientView = Backbone.View.extend({
	
	el: PATH_LAYOUT,
	
	active:".btn-clientes",

	template: _.template( $('#tmpl-new-client').html() ),

    events: {
        'click .btn-accept': 'accept',
        'click .btn-cancel': 'cancel'
    },

	initialize: function () {
		
		$(this.el).unbind();
		
		this.model.fetch();
		this.model.bind('change', this.render, this);

	}, 

	render: function () {
		
		active(this.active);

		$(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},

	// Btn click Aceptar / Save cliente
    accept: function() {

    	if( $('#frm-new-client').valid() ){
    		
	    	this.post = new ClientCollection();
	    	
	    	this.post.create({
	    		"id"				: parseInt($("input[name='id']").val(),10),
	    	    "nombre"			: $("input[name='nombre']").val(),
	    	    "cuit"				: $("input[name='cuit']").val(),
	    	    "direccion"			: $("input[name='direccion']").val(),
	    	    "idTipoIVA"			: parseInt($("select[name='idTipoIVA'] option:selected").val(),10),
	    	    "idTipoRetencion"	: parseInt($("select[name='idTipoRetencion'] option:selected").val(),10)
	    	} , {
				success: function(response) {
					
					var msg = AlertModel.set({
	            		'type': 'success',
	            		'body': 'El cliente se creo correctamente'
	            	});
	            	
	            	new AlertView({model: msg });
				
					app.navigate(URL_CLIENTS, true);
					
				},
	            error : function(err, response) {
	            	
	            	var msg = AlertModel.set({
	            		'type': 'error',
	            		'body': 'Hubo un error al cargar el cliente'
	            	});
	            	
	            	new AlertView({model: msg });       
	        		
	            }
			}); 
    	}else{
  
        	var msg = AlertModel.set({
        		'type': 'error',
        		'body': 'Completa los campos requeridos'
        	});
        	
        	new AlertView({model: msg }); 
        	
    	}    	

    },
    
    cancel: function(){
    	
    	app.navigate(URL_CLIENTS, true);
    	
    }

});
