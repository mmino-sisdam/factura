
	
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
			var get = new InvoiceModel();

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
		  	
		  	//var userList = new UserCollection();

		  }
		  
		});

		var app = new Router();

		Backbone.history.start();

	});





