
	
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
		    "usuario/editar/:id"			: "edit_user",
		    "usuario/editar-contrasena/:id"	: "edit_password",
			"clientes"						: "clients",
		    "cliente/nuevo"					: "client_new",
			"cliente/editar/:id"			: "client_edit"
		  },

		  // Seccion Dashboard
		  dashboard: function() {
			
			// Initialize the View, 
		  	new DashboardView();

		  },

		  // Seccion listado de facturas
		  invoice: function() {

		  	// invoice.js

		  	// Initialize the Model
			var get = new Invoice();

			// Initialize the View, 
			// passing it the model instance
			new InvoiceView({ model: get});

		  },

		  // Seccion nueva factura
		  new_invoice: function(tipo){

		  	//if(tipo == '1'){
		  		
		  		// Initialize the Model
				//var get = new InvoiceData();
				
		  		new NewInvoiceView({ id: tipo });

		  	//}

		  },

		  invoice_info: function(tipo, numero){
		  
			  // Id corresponde al tipo de factura
			  // Numero corresponde al numero de factura
			  var get = new Invoice({"id": tipo + '-' + numero});
			  
			  new NewInvoiceInfoView({model: get});
			  
		  },

		  // Seccion edicion de factura por numero
		  invoice_edit: function(tipo, numero){
		  	
			var get = new Invoice({"id": tipo + '-' + numero});
		  	
		  	new EditInvoiceView({model: get, id: tipo});
		  	
		  },

		  // Seccion usuarios
		  users: function(){
			
		  	// Initialize the Model
			var get = new User();
			
			// Initialize the View, 
			// passing it the model instance
			new UsersView({ model: get });

		  },

		  // Seccion nuevo usuario	
		  new_user: function(){
			
			var get = new User();
			
		  	// Initialize the View, 
		  	new NewUsuerView({ model: get });
		  	
		  },
		  
		  edit_user: function(id){
			  
			 var get = new User({"id": id});
			 
			 new EditUserView({ model: get });
			  
		  },
		  
		  edit_password: function(id){
			  
			  var get = new User({"id": id});
			  
			  new EditUserPassView({ model: get });
			  
		  },
		  
		  // Seccion clientes
		  clients: function(){
				
			// Initialize the Model
			var get = new Client();
				
			// Initialize the View, 
			// passing it the model instance
			new ClientsView({ model: get });

		  },

		  // Seccion nuevo usuario	
		  client_new: function(){
			
			var get = new Client();
			  
		  	// Initialize the View, 
		  	new NewClientView({model: get});
		  	
		  },
		  
		  client_edit: function(id){
			  
			 var get = new Client({"id": id});
			 
			 new EditClientView({ model: get });
			  
		  },
		  
		});

		window.app = new Router();

		Backbone.history.start();

	});





