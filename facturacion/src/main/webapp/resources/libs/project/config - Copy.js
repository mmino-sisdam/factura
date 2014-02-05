require.config({
	baseUrl: 'libs',
    paths: {
        jquery 			:'jquery-1.11.0.min',
        less 			:'less/less-1.6.1.min',
        bootstrap 		:'bootstrap/js/bootstrap',
        datepicker 		:'bootstrap/datepicker/js/bootstrap-datepicker', 
        datepicker_es	:'bootstrap/datepicker/js/bootstrap-datepicker.es', 
        autocomplete	:'bootstrap/typehead/js/typeahead.min.es', 
        underscore 		:'backbone/underscore',
        backbone 		:'backbone/backbone-min',
        // Project
        utils	 		:'project/utils',
        users	 		:'project/users',
        invoice	 		:'project/invoice'

        
    }
});

require( ['jquery','less', 'bootstrap', 'datepicker', 'underscore', 'backbone', 'utils', 'users', 'invoice'], function( $ ) {

	console.log($);
	
	$(function(){

		var Router = Backbone.Router.extend({

		  routes: {
		    ""								: "dashboard",
		    "facturas"						: "invoice",
		    "factura/nueva/tipo-:tipo"		: "invoice_id",
		    "factura/:id"					: "invoice_id",
		    "usuarios"						: "users",
		    "usuario/nuevo"					: "new_user",
		  },

		  // Seccion Dashboard
		  dashboard: function() {

		  	template.render({
		  		html: 'includes/dashboard/inc.layout.html',
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

		  	/*
		  	template.render({
		  		html: 'includes/facturas/inc.nueva.factura.tipo.a.html',
		  		callback: function(data){
					
					utils.active({item: '.btn-facturas'});
					
					layout.html( data );	

				    $('.form-datepicker').datepicker({
						format: "dd/mm/yyyy",
						autoclose: true,
						startDate: '-1d'
					});
		  		}
		  	});	
			*/

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


});

