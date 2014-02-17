
window.Invoice = Backbone.Model.extend({
	urlRoot: "facturas"
});

window.InvoiceCollection = Backbone.Collection.extend({
	model: Invoice,
	url: "facturas"
});

window.InvoiceData = Backbone.Model.extend({
	urlRoot: "datos/factura"
});

window.InvoiceTableModel = Backbone.Collection.extend({
	defaults: {
		"detalle"			: "",
		"importeUnitario"	: "",
		"importeTotal"		: ""
	}	
});

/*
 * 	Vision total de facturas
 * */

window.InvoiceView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-facturas",

	template: _.template( $('#tmpl-list-invoice').html() ),

	events: {
		'click .btn-month': 'invoice_next'
	},

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this); 
		
		$('.btn-month').unbind('click');

	}, 

	render: function () {
		
		$('.main-menu').find('a').removeClass('active');
		$(this.active).addClass('active');
		
	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},
	
	invoice_next: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		var next = $(ev.currentTarget).nextAll('.month-id-' + id);
		
		if( next.is(':hidden') ){
			next.show();
		}else{
			next.hide();
		}
		
	}
	
});



/*
 * 	Vista de una nueva factura tipo A
 * */
var NewInvoiceView_A = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-facturas",
	
	template: _.template( $('#tmpl-fc-a-invoice').html() ),
	
	// Clases
	table			: '.table-fc-body',
	
	clases: {
		label_status		: '.label-status',
		label_vencimiento	: '.label-vencimiento',
		label_emision		: '.label-emision', 
		label_total			: '.label-total', 
		label_iva			: '.label-iva', 
		label_sub_total		: '.label-sub-total', 
		
		// Class sin punto, se usa para hasClass
		input_emision		: 'input-fecha-emision',
		input_vencimiento	: 'input-fecha-vencimiento'
	},
	
	// Table line inputs
	tableRenderAdd: _.template( $('#tmpl-fc-a-item').html() ),
	
	// Table render
	tableRender: _.template( $('#tmpl-fc-r-item').html() ),
	
    events: {
       'click .btn-cancel'			: 'cancel',
       'click .btn-accept'			: 'accept',
       'click .btn-table-insert'	: 'add_line',
       'click .btn-table-reset'		: 'table_reset',
       'click .btn-delete-line'		: 'delete_line',
       'click .btn-add-line'		: 'confirm_line',
       'change .select-status'		: 'change_status',
       'focus .form-type-client'	: 'find_client',
    },

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this);

		
		window.Table = new InvoiceTableModel();

	}, 
	
	find_client: function(ev){


		
	},	

	render: function () {
		
		var t = this;
		
		active(t.active);
		
		$(this.el).html(this.template(this.model.toJSON()));
	    
	    // datepicker class form-datepicker
	    $('.form-datepicker').datepicker({
	    	format: "dd/mm/yyyy",
			autoclose: true,
			startDate: '-1d'
	    }).on('changeDate', function(ev){
	    	
	    	var that = $(ev.currentTarget);
	    	
	    	if( that.hasClass( t.clases.input_emision) ){
	    		// Si el input tiene la clase de input emision 
		    	// Imprimo la fecha en label emision
	    		$(t.clases.label_emision).html( that.val() );
	    		
	    	}else if( that.hasClass( t.clases.input_vencimiento) ){
	    		// Si el input tiene la clase de input vencimiento 
		    	// Imprimo la fecha en label vencimiento
	    		$(t.clases.label_vencimiento).html( that.val() );
	    		
	    	}else{}
	
	    });

		
		// Clientes
		//var clients = new Clients();
		  //  clients.fetch();
		
		
  
	    
	    // Inizialize table
	    $(this.table).html( this.tableRenderAdd );
    
	    return this;
  
	},
	
	accept: function(){
		
		var post = new InvoiceCollection();
		var alert, msg;
		
		var data = $('#form-invoice').serializeObject();
		var result = $.extend(data, {"detalles": Table.toJSON()} );
		
    	post.create(result , {
			success: function(response) {
				
				msg = AlertModel.set({
            		'type': 'success',
            		'body': 'La factura se cargo correctamente'
            	});
            	
            	alert = new AlertView({model: msg });
			
				app.navigate(URL_FACTURAS, true);				
				
			},
            error : function(err, response) {
 
            	msg = AlertModel.set({
            		'type': 'error',
            		'body': 'Hubo un error al cargar la factura'
            	});
            	
            	alert = new AlertView({model: msg });  
            	      
        		
            }
		}); 		
		
		
		
	},	
	
	cancel: function(){
		
		app.navigate('facturas', true);
		
	},
	
	change_status: function(ev){
		
		$(this.clases.label_status).html( $(ev.currentTarget).val() );
		
	},
	
	// Buton -- insertar fila
	add_line: function(ev){
		
		$(this.table).append( this.tableRenderAdd );
		
	},
	
	// Buton -- reiniciar tabla
	table_reset: function(){
		
		row_number = 1;
		
		$(this.table).html( this.tableRenderAdd );
		
	},
	
	// Buton -- confirmar una fila
	confirm_line: function(ev){
		
		var line = $(ev.currentTarget).parent().parent();
		var detalle = line.find('input[name="detalle"]');
		var importeUnitario = line.find('input[name="importe-unitario"]');
		var importeTotal = line.find('input[name="importe-total"]');
		
		if( !isNaN(importeUnitario) && !isNaN(importeTotal) ){
			
			
			Table.add({
				"detalle"			: detalle.val(),
				"importeUnitario"	: importeUnitario.val(),
				"importeTotal"		: importeTotal.val()
			});
					
			$(this.table).html( this.tableRender( {"rows": Table.toJSON()} ) );
			
			//console.log(model.toJSON());
			
			
			// Suma de valores
			var subtotal = 0;
			var iva = 0;
			var total = 0;	
			
			Table.each(function(m) {
				
				console.log(m.toJSON().importeTotal.replace(/\./g,''));
				// Replace de puntos por vacio para sumar el total
				subtotal += parseInt(m.toJSON().importeTotal.replace(/\./g,''));			
				
			}, this);		
			
			// Calculo el IVA
			iva = (subtotal * PATH_IVA) / 100;	
			
			// Calculo el total
			total = subtotal - iva;		
			
			subtotal = convertToDecimal(subtotal);
			iva = convertToDecimal(iva);
			total = convertToDecimal(total);
			
			/*
			subtotal = subtotal.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
			subtotal = subtotal.split('').reverse().join('').replace(/^[\.]/,'');
			
			iva = iva.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
			iva = iva.split('').reverse().join('').replace(/^[\.]/,'');
			
			total = total.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
			total = total.split('').reverse().join('').replace(/^[\.]/,'');
			*/
			//console.log(subtotal);
	
			$(this.clases.label_sub_total).html(subtotal);
			$(this.clases.label_iva).html(iva);
			$(this.clases.label_total).html(total);
		}else{
			console.log('error');
		}
		
	},
	
	delete_line: function(ev){
		
		//$(ev.currentTarget).parent().parent().remove();
		
		//row_number--;
		
		var id = $(ev.currentTarget).attr('data');
		
		//var g = model.get(id);
		
	}

});


/*
 * 	Vista de una nueva factura tipo A
 * */
var NewInvoiceInfoView = Backbone.View.extend({
	
	el: PATH_LAYOUT,
	
	active:".btn-facturas",

	template: _.template( $('#tmpl-fc-info-invoice').html() ),

	events: {
		'click .btn-accept': 'accept'
	},

	initialize: function () {
		
		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {
		
		// Active menu
		active(this.active);
		
		$(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},
	
	accept: function(){
		
		app.navigate(URL_FACTURAS, true);
		
	}
	
});


