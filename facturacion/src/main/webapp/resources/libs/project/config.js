
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
		    ""								: "dashboard",
		    "facturas"						: "invoice",
		    "factura/:nueva/tipo-:tipo"		: "invoice_form",
		    "factura/:evento/:id/:numero"	: "invoice_form",
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
		  /*
		  // Seccion nueva factura
		  new_invoice: function(tipo){

		  	//if(tipo == '1'){
		  		
		  		// Initialize the Model
				//var get = new InvoiceData();
				
		  		new NewInvoiceView({ id: tipo });

		  	//}

		  },
		  */
		  // Seccion edicion de factura por numero
		  invoice_form: function(evento, tipo, numero){
			 
			// factura nueva 
		  	if(evento == 'nueva'){
		  		
		  		var get = new Invoice();
		  		
		  		new NewInvoiceView({ model: get, id: tipo });
		  		
		  	}else if(evento == 'editar'){
		  	// factura editar	
		  		
		  		var get = new Invoice({"id": tipo + '-' + numero});
		  		
		  		new NewInvoiceView({ model: get, id: tipo });
		  		
		  	}else if(evento == 'info'){
		  	// factura info
		  		
		  		var get = new Invoice({"id": tipo + '-' + numero});
				  
				new NewInvoiceInfoView({model: get});
				
		  	}else{}
		  	
		  },

/*
		  invoice_info: function(tipo, numero){
		  
			  // Id corresponde al tipo de factura
			  // Numero corresponde al numero de factura
			  var get = new Invoice({"id": tipo + '-' + numero});
			  
			  new NewInvoiceInfoView({model: get});
			  
		  },
*/
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





