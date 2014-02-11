
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
		    ""								: "dashboard",
		    "facturas"						: "invoice",
		    "factura/nueva/tipo-:tipo"		: "new_invoice",
		    "factura/editar/:id"			: "invoice_edit",
		    "factura/info/:id"				: "invoice_info",
		    "usuarios"						: "users",
		    "usuario/nuevo"					: "new_user",
		    "usuario/editar/:id"			: "edit_user"
		  },

		  // Seccion Dashboard
		  dashboard: function() {
			  
			// Initialize the View, 
		  	var view = new DashboardView();

		  },

		  // Seccion listado de facturas
		  invoice: function() {

		  	// invoice.js

		  	// Initialize the Model
			var get = new Inovice();

			// Initialize the View, 
			// passing it the model instance
			var view = new InvoiceView({ model: get });

		  },

		  // Seccion nueva factura
		  new_invoice: function(tipo){

		  	if(tipo == 'A'){

		  		var view = new NewInvoiceView_A();

		  	}

		  },

		  invoice_info: function(id){

		  	console.log(id);

		  },

		  // Seccion vista de factura por ID
		  invoice_edit: function(id){
		  	
		  	console.log(id);

		  },

		  // Seccion usuarios
		  users: function(){
			
		  	// Initialize the Model
			var get = new User();
			
			// Initialize the View, 
			// passing it the model instance
			var view = new UsersView({ model: get });

		  },

		  // Seccion nuevo usuario	
		  new_user: function(){
			
			var get = new User();
			
		  	// Initialize the View, 
		  	var view = new NewUsuerView({ model: get });
		  	
		  },
		  
		  edit_user: function(id){
			  
			 var get = new User({"id": id});
			 
			 var view = new EditUserView({ model: get });
			  
		  }
		  
		});

		window.app = new Router();

		Backbone.history.start();

	});





