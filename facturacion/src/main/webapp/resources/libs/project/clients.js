

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
		'click .btn-edit'		: 'client_edit',
		'click .btn-delete'		: 'client_delete'
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
		
	},

	client_delete: function(ev){

		var id = $(ev.currentTarget).attr('data');
		var client = $(ev.currentTarget).attr('data-client');

		var msg = DeleteModel.set({
			'title'	: 'Eliminar Cliente', 
			'body'  : '¿Confirma la eliminaci&oacute;n de '+ client +'?',
			'id'	: id
		});

		var view = new DeleteClientView({ model: msg });
		view.show();

	}
	
});


/*
 * 	Creacion de cliente
 * */

window.FormClientView = Backbone.View.extend({
	
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
	    	    "localizacion"		: $("input[name='localizacion']").val(),
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
 * 	Eliminacion de cliente
 * */

window.DeleteClientView = Backbone.View.extend({

	el: PATH_MODAL,
	
    events: {
        'click .btn-aceptar': 'accept'
    },

    initialize: function() {
        this.template = _.template($('#tmpl-modal').html());
    },

    render: function() {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    },

    show: function() {
        $(document.body).append(this.render().el);
    },
    
    hide: function(){
    	$('#modal').modal('hide');
    },

    accept: function() {
    	
    	this.hide();
    	
    	var id = this.model.attributes.id;
    	
    	$('#client-' + id).remove();
    	
    	var client = new Client({"id":id});
    	    	
    	client.destroy();	
    	    	    	
    }
       
});
