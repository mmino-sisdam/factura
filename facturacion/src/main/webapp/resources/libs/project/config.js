
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
		    ""								: "dashboard",
		    "facturas"						: "invoice",
		    "factura/nueva/tipo-:tipo"		: "new_invoice",
		    "factura/:id"					: "invoice_id",
		    "usuarios"						: "users",
		    "usuario/nuevo"					: "new_user",
		  },

		  // Seccion Dashboard
		  dashboard: function() {

		  	template.render({
		  		html: 'resources/includes/dashboard/inc.layout.html',
		  		callback: function(data){
					
					utils.active({item: '.btn-dashboard'});
					
					layout.html( data );	

		  		}
		  	});

		  },

		  // Seccion listado de facturas
		  invoice: function() {

		  	// invoice.js

		  	// Initialize the Model
			var get = new InvoiceModel();

			// Initialize the View, 
			// passing it the model instance
			var view = new InvoiceView({ model: get });

		  },

		  // Seccion nueva factura
		  new_invoice: function(tipo){

		  	// invoice.js

		  	


		  },

		  // Seccion vista de factura por ID
		  invoice_id: function(id){
		  	

		  },

		  // Seccion usuarios
		  users: function(){
		  	
		  	// user.js

		  	// Initialize the Model
			var get = new UsersModel();

			// Initialize the View, 
			// passing it the model instance
			var view = new UsersView({ model: get });

		  },

		  // Seccion nuevo usuario
		  new_user: function(){

		  	// user.js 

		  	// Initialize the View, 
		  	var view = new NewUsuerView();

		  }

		});

		var appRouter = new Router();

		Backbone.history.start();

	});


