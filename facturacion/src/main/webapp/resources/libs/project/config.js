
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
			""								: "dashboard",
		    "dashboard"						: "dashboard",
		    "facturas"						: "invoice",
		    "factura/:nueva/tipo-:tipo"		: "invoice_form",
		    "factura/:evento/:tipo/:numero"	: "invoice_form",
		    
		    "usuarios"						: "users",
		    "usuario/:evento"				: "user_form",
		    "usuario/:evento/:id"			: "user_form",
		    "usuario/editar-contrasena/:id"	: "edit_password",
		    
			"clientes"						: "clients",
		    "cliente/:evento"				: "client_form",
			"cliente/:evento/:id"			: "client_form"
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

		  // Seccion facturas
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

		  // Seccion usuarios
		  users: function(){
			
		  	// Initialize the Model
			var get = new User();
			
			// Initialize the View, 
			// passing it the model instance
			new UsersView({ model: get });

		  },

		  // Seccion nuevo usuario	
		  user_form: function(evento, id){
			
			if(evento == 'nuevo'){
				
				var get = new User();
				
			  	// Initialize the View
			  	new FormUsuerView({ model: get });	
			  	
			}else if(evento == 'editar'){
				
				var get = new User({"id": id});
				
				// Initialize the View
				new FormUsuerView({ model: get, 'evento': evento });	
				 
			}else{}	
		  	
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
		  client_form: function(evento, id){
			
			if(evento == 'nuevo'){
				  
				var get = new Client();
					  
				// Initialize the View, 
				new FormClientView({model: get});				  
				  
			}else if(evento == 'editar'){
				
				 var get = new Client({"id": id});
				 
				 // Initialize the View 
				 new FormClientView({ model: get });				
				
			}
	
		  }
		  
		});

		window.app = new Router();

		Backbone.history.start();
		
		$('.toggle-menu').click(function(){
			
			if( $('.main-menu').is(':hidden') ){
				
				$('.main-menu').show().addClass('mobile-open');
				
			}else{
				
				$('.main-menu').hide().removeClass('mobile-open');
				
			}
			
		});
		
		
		$('.main-menu li a').click(function(){
			
			if( $('.main-menu').hasClass('mobile-open') ){
			
				$('.main-menu').hide();
			
			}
			
		});		
		
	});
	
	/*	window resize 
	 * *********************************/
	$( window ).resize(function() {
		
		 var screen = window.outerWidth;
		 console.log(screen);
		 if(screen >= '1024'){
			 
			 $('.main-menu').show().removeClass('mobile-open');
			 
		 }else{
			 
			 $('.main-menu').hide().removeClass('mobile-open'); 
			 
		 }
  
	});





