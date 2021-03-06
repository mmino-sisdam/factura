
window.Invoice = Backbone.Model.extend({
	urlRoot: "facturas",
	defaults: {
		"id"				: null,
		"idCliente"			: "",
		//"localizacion"		: "",
		"contacto"			: "",
		"idTipoIVA"			: "",
		//"cuit"				: "",
		"idTipoRetencion"	: "",
		"numero"			: "",
		"fecha"				: "",
		"fechaVencimiento"	: "",
		"fechaProbableCobro": "",
		"fechaCobro"		: "",
		//"porcentajeIVA"		: "",
		"idStatus"			: "",
		"importeIVA"		: "",
		"importeTotal"		: "",
		"idTipoComision"	: "",
		"importeComision"	: "",
		"idResponsable"		: "",
		"idLineaProducto"	: "",
		"importeCosto"		: "",
		"importeRentabilidad": "",
		"formaDePago"		: "",
		"remito"			: "",
		"ordenDeCompra"		: "",
		"detalles": [{
			"cantidad"		: "1",
			"detalle"		: "",
			"importeTotal"	: "",
			"importeUnitario": ""
		}]
	}
});

window.InvoiceCollection = Backbone.Collection.extend({
	model: Invoice,
	url: "facturas"
});

window.InvoiceData = Backbone.Model.extend({
	urlRoot: "datos/factura"
});

window.InvoiceDataCollection = Backbone.Collection.extend({
	url: "datos/factura"
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
		'click .btn-print'		: 'invoice_print',
		'click .btn-info'		: 'invoice_info',
		'click .btn-edit'		: 'invoice_edit',
		'click .btn-delete'		: 'invoice_delete',
		'click .btn-month'		: 'invoice_next'
	},
	
	initialize: function () {
		
		$(this.el).unbind();
		
		// Call listado facturas
		this.model.fetch();
		this.model.bind('change', this.render, this); 
		

	}, 

	render: function () {
		
		$('.main-menu').find('a').removeClass('active');
		$(this.active).addClass('active');
		
	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},
	
	invoice_info: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_INFO + id, true);
			
	},	

	invoice_edit: function(ev){

		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_EDIT + id, true);		
			
	},
	
	invoice_delete: function(ev){
		
		var id = $(ev.currentTarget).attr('data');

		var msg = DeleteModel.set({
			'title'	: 'Eliminar Factura', 
			'body'  : '�Confirma la eliminaci&oacute;n de la factura '+ id +'?',
			'id'	: id
		});

		var view = new DeleteInoiceView({ model: msg });
		view.show();		
		
	},
	
	invoice_next: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		var next = $(ev.currentTarget).nextAll('.month-id-' + id);
		
		if( next.is(':hidden') ){
			next.show();
		}else{
			next.hide();
		}
		
	},
	
	invoice_print: function(){
		
		window.print();
		
	}
	
});



/*
 * 	Vista de una nueva factura
 * */
var NewInvoiceView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-facturas",
	
	template: _.template( $('#tmpl-fc-invoice').html() ),
	
	// Clases
	table			: '.table-fc-body',
	
	clases: {
		form_invoice		: '#form-invoice',
		label_status		: '.label-status',
		label_vencimiento	: '.label-vencimiento',
		label_emision		: '.label-emision', 
		label_total			: '.label-total', 
		label_iva			: '.label-iva', 
		label_sub_total		: '.label-sub-total', 

		input_total			: '.input-total', 
		input_iva			: '.input-iva', 
		input_sub_total		: '.input-sub-total', 
		input_rentabilidad	: '.input-rentabilidad', 
		
		input_cliente_sucursal	: '.cliente-sucursal', 
		input_cliente_contacto	: '.cliente-contacto',  
		input_cliente_cuit		: '.cliente-cuit',
		
		select_cliente_iva		: '.cliente-iva', 
		select_cliente_retencion: '.cliente-retencion', 
		
		btn_table_insert		: '.btn-table-insert',
		//btn_table_confirm		: '.btn-table-confirm',
		btn_calculate			: '.btn-calculate',
		btn_accept				: '.btn-accept',
		
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
       //'click .btn-delete-line'		: 'delete_line',
       //'click .btn-table-confirm'	: 'confirm_line',
       'click .btn-calculate'    	: 'confirm_line',
       'change .select-status'		: 'change_status',
       'change .select-client'		: 'find_client'     
    },

	initialize: function () {
		
		//this.model 	= new Invoice();
		this.data 	= new InvoiceData();
	
		// Request
		this.model.fetch();
		this.data.fetch();
		
		this.data.bind('change', this.render, this);
		this.model.bind('change', this.render, this);
		
		/* 
		 * si al final queda en false NO aplica iva, 
		 * si esta en true lo aplica. 
		*/
		this.condition_iva = true;

	},	

	render: function () {
		
		var t = this;
		
		active(t.active);
		
		$(this.el).html(this.template({
			
			// Modelo factura
			"factura": this.model.toJSON(),
			
			// Id del tipo de factura a crear
			"idTipoFactura": this.id,
			
			// Modelo datos
			"datos": this.data.toJSON()
			
		}));		
		
		/* 
		| Si el id de la factura a crear o editar
		| corresponde con los ids de PATH_INVOICE_ID es sin IVA
		| Factura b, Factura e, Nota de credito b, Nota de credito e, Nota de debito b 
		*/
		
		if( (this.id in PATH_INVOICE_ID) ){
			
			// Factura sin IVA
			this.condition_active();
			
		}
		
		/*
		| Si el numero de la factura es distinto de vacio
		| quiere decir que esta editando, readonly al campo numero de factura
		*/
		
		if(this.model.toJSON().numero != ''){
			
			$('[name="numero"]').attr('readonly','readonly');
			
		}
					    
	    // datepicker class form-datepicker
	    $('.form-datepicker').datepicker({
	    	format: "dd/mm/yyyy",
			autoclose: true
			//startDate: '-1d'
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
    
	    return this;
  
	},
	
	condition_active: function(){
		
		// Remove a los campos correspondientes al IVA
		$('.form-iva').remove();
				
		// NO aplica iva
		this.condition_iva = false;
		
	},
	
	accept: function(){
		
		if( $('[name="idCliente"]').find('option:selected').val() != '-1' ){
					
			if( $(this.clases.form_invoice).valid() ){
				
				var post = new InvoiceCollection();
				var msg;
				
				var data = $(this.clases.form_invoice).serializeObject();
				var result = _.extend(data, {"detalles": Table.toJSON()} );
				
				// Request POST
		    	post.create(result, {
					success: function(response) {

						/*
						| Success
						| La factura se guardo correctamente
						| * Mensaje success
						| * Navigate app listado de facturas
						*/
						
						msg = AlertModel.set({
		            		'type': 'success',
		            		'body': MSG_INVOICE_SAVE_SUCCESS
		            	});
		            	
		            	new AlertView({model: msg });
					
						app.navigate(URL_FACTURAS, true);				
						
					},
		            error : function(err, response) {

		    			/*
		    			| Error
		    			| Hubo un error al cargar la factura
		    			*/
		            	
		            	msg = AlertModel.set({
		            		'type': 'error',
		            		'body': MSG_INVOICE_SAVE_ERROR
		            	});
		            	
		            	new AlertView({model: msg });  
			
		            }
		    	}); 
		    	
			}else{
				
				/*
				| Error
				| Si el formulario no valida los campos
				*/
				
	        	msg = AlertModel.set({
	        		'type': 'error',
	        		'body': MSG_INVOICE_FORM_ERROR
	        	});
	        	
	        	new AlertView({model: msg });
	        	
			}
			
		}else{
			
			/*
			| Error
			| No selecciono ningun cliente en combo
			*/
			
        	msg = AlertModel.set({
        		'type': 'error',
        		'body': MSG_CLIENT_SELECTED_ERROR
        	});
        	
        	new AlertView({model: msg });
        	
        	$('html, body').animate({scrollTop:0}, '500');
        	
		}
		
	},	
	
	confirm_line: function(ev){
		
		/*
		| Valido los campos del formulario
		| para calcular los valores que estan en readonly 
		*/
		
		if( $(this.clases.form_invoice).valid() ){	
		
			window.Table = new InvoiceTableModel();
			
			var path_iva = $('.iva-value').val();
	
			_.each( $('.table-fc-body').find('tr'), function(line){
				
				var detalle = $(line).find('input[name="detalle"]');
				var importeUnitario = $(line).find('input[name="importe-unitario"]');
				var importeTotal = $(line).find('input[name="importe-total"]');
				
				/*
				| Valido si detalle no esta vacio
				| Importe unitario y total vacio y es un numero
				*/
				
				if(
						detalle.val() != '' && 
						(importeUnitario.val() != '' && !isNaN(importeUnitario.val() ) ) &&
						(importeTotal.val() != '' &&  !isNaN(importeTotal.val() ) ) 
				){
					
					Table.add({
						"detalle"			: detalle.val(),
						"importeUnitario"	: importeUnitario.val(),
						"importeTotal"		: importeTotal.val()
					});
					
				}
				
				
			} );
			
			/*
			| Si la tabla detalle tiene al menos 1 registro
			*/
			
			if(Table.length > 0){
				
				$(this.table).html( this.tableRender( {"rows": Table.toJSON()} ) );	
		
				// Suma de valores
				var subtotal = $('[name="importeSubtotal"]').val();
				var iva = 0;
				var total = 0;	
				
				// Calculo valores con iva
				if(this.condition_iva){
					
					// Calculo el IVA
					//iva = (subtotal * path_iva) / 100;	
					iva = ( ( Math.round((subtotal * path_iva)*10)/10 ) / 100 ).toFixed(2);	
					
					// Calculo el total
					//total = subtotal + iva;	
					total = parseFloat(subtotal) + parseFloat(iva);	
					
					/* 
					| Rentabilidad	
					| (total x ingresos brutos) - costo
					*/
					var rentabilidad = (total * parseFloat(PATH_IIBB) ) - parseFloat( $('[name="importeCosto"]').val() );				
					
					//subtotal = convertToDecimal(subtotal);
					//iva = convertToDecimal(iva);
					//total = convertToDecimal(total);
					
					// Inserto valores en labels
					$(this.clases.label_sub_total).html( subtotal );
					$(this.clases.label_iva).html( parseFloat(iva).toFixed(2) );
					$(this.clases.label_total).html( parseFloat(total).toFixed(2) );
					
					// Inserto valores en inputs
					//	$(this.clases.input_sub_total).val(subtotal);
					$(this.clases.input_iva).val( parseFloat(iva).toFixed(2) );
					$(this.clases.input_total).val( parseFloat(total).toFixed(2) );
					
					$(this.clases.input_rentabilidad).val( parseFloat(rentabilidad).toFixed(2) );
					
					
			
				}else{
				// Calculo valores sin iva	
					
					// Calculo el total, pasando a decimales
					//total = convertToDecimal(subtotal);
					
					/* 
					| Rentabilidad	
					| (subtotal x ingresos brutos) - costo
					*/
					var rentabilidad = (subtotal * parseFloat(PATH_IIBB) ) - parseFloat( $('[name="importeCosto"]').val() );
					
					$(this.clases.label_total).html( Math.round(subtotal) );
					$(this.clases.input_rentabilidad).val( Math.round(rentabilidad) );
					
				}
				
				// Oculto botones
				$(this.clases.btn_table_insert).hide();
				$(this.clases.btn_table_confirm).hide();
				
				$(this.clases.btn_calculate).hide();
				$(this.clases.btn_accept).show();
				
			}else{
				
	        	msg = AlertModel.set({
	        		'type': 'error',
	        		'body': MSG_INVOICE_FORM_ERROR
	        	});
	        	
	        	new AlertView({model: msg });  
				
			}
		}else{
			
			/*
			| Error
			| Si el formulario no valida los campos
			*/
			
        	msg = AlertModel.set({
        		'type': 'error',
        		'body': MSG_INVOICE_FORM_ERROR
        	});
        	
        	new AlertView({model: msg });
        	
		}
		
	},	
	
	cancel: function(){
		
		app.navigate('facturas', true);
		
	}, 
	
	find_client: function(ev){
		
		var op = $(ev.currentTarget).find('option:selected');
		
		$(this.clases.input_cliente_sucursal).val( op.attr('data-direccion') );
		$(this.clases.input_cliente_contacto).val( op.attr('data-contacto') );
		$(this.clases.input_cliente_cuit).val( op.attr('data-cuit') );
		
		$(this.clases.select_cliente_iva).find('option[value="'+ op.attr('data-iva') +'"]').attr('selected','selected');
		$(this.clases.select_cliente_retencion).find('option[value="'+ op.attr('data-retencion') +'"]').attr('selected','selected');
		
	},	
	
	change_status: function(ev){
		
		$(this.clases.label_status).html( $(ev.currentTarget).find('option:selected').text() );
		
	},
	
	// Buton -- insertar fila
	add_line: function(ev){
		
		$(this.table).append( this.tableRenderAdd );
		
	},
	
	// Buton -- reiniciar tabla
	table_reset: function(){
		
		row_number = 1;
		
		// Reinicio las filas
		$(this.table).html( this.tableRenderAdd );
		
		// Reinicio los valores subtotal / iva / total
		$(this.clases.label_sub_total).html('');
		$(this.clases.label_iva).html('');
		$(this.clases.label_total).html('');
		
		// Muestro botones
		$(this.clases.btn_table_insert).show();
		$(this.clases.btn_table_confirm).show();		
		
	}

});


/*
 * 	Vista de info factura
 * */
var NewInvoiceInfoView = Backbone.View.extend({
	
	el: PATH_LAYOUT,
	
	active:".btn-facturas",

	template: _.template( $('#tmpl-fc-info-invoice').html() ),

	events: {
		'click .btn-print'		: 'invoice_print',
		'click .btn-accept'		: 'accept',
		'click .btn-edit'		: 'invoice_edit'
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
		
	},
	
	invoice_edit: function(ev){

		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_EDIT + id, true);		
			
	},
	
	invoice_print: function(){
		
		window.print();
		
	}	
	
});


/*
 * 	Eliminacion de cliente
 * */

window.DeleteInoiceView = Backbone.View.extend({

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
    	
    	$('#invoice-' + id).remove();
    	
    	var invoice = new Invoice({"id":id});
    	    	
    	invoice.destroy({
            success: function() {
            	
	        	msg = AlertModel.set({
	        		'type': 'success',
	        		'body': MSG_SUCCESS
	        	});
	        	
	        	new AlertView({model: msg });
	        	
            }
    	});	
    	    	    	
    }
       
});


