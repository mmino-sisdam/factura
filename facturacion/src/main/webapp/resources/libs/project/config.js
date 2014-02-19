
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
		    ""								: "dashboard",
		    "facturas"						: "invoice",
		    "factura/nueva/tipo-:tipo"		: "new_invoice",
		    "factura/editar/:id/:numero"	: "invoice_edit",
		    "factura/info/:id/:numero"		: "invoice_info",
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
			var get = new Invoice();
			
			

			// Initialize the View, 
			// passing it the model instance
			var view = new InvoiceView({ model: get});

		  },

		  // Seccion nueva factura
		  new_invoice: function(tipo){

		  	if(tipo == '1'){
		  		
		  		// Initialize the Model
				var get = new InvoiceData();
				
		  		var view = new NewInvoiceView_A({ model: get });

		  	}

		  },

		  invoice_info: function(id, numero){
		  
			  // Id corresponde al tipo de factura
			  // Numero corresponde al numero de factura
			  var get = new Invoice({"id": id + '-' + numero});
			  
			  var view = new NewInvoiceInfoView({model: get});
			  
		  },

		  // Seccion vista de factura por ID
		  invoice_edit: function(id, numero){
		  	
		  	var data = new Invoice({"id": id + '-' + numero});
		  	
		  	new NewInvoiceEditView({model: data});
		  	
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
		  	new NewUsuerView({ model: get });
		  	
		  },
		  
		  edit_user: function(id){
			  
			 var get = new User({"id": id});
			 
			 var view = new EditUserView({ model: get });
			  
		  }
		  
		});

		window.app = new Router();

		Backbone.history.start();

	});





