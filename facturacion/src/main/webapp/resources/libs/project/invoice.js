
window.Inovice = Backbone.Model.extend({
	urlRoot: "facturas",
	//urlRoot: "../../facturacion/resources/json/facturas.json"
});

window.Clients = Backbone.Model.extend({
	//urlRoot: "facturas",
	urlRoot: "../../facturacion/resources/json/clientes.json"
});

window.InoviceTableModel = Backbone.Collection.extend({
	defaults: {
		"id"				: null,
		"numero"			: "",
		"descripcion"		: "",
		"moneda"			: "",
		"precio_unitario"	: "",
		"total"				: ""
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
	tableRenderAdd: $('#tmpl-fc-a-item').html(),
	
	// Table render
	tableRender: _.template( $('#tmpl-fc-r-item').html() ),
	
    events: {
       'click .btn-cancel'			: 'cancel',
       'click .btn-table-insert'	: 'add_line',
       'click .btn-table-reset'		: 'table_reset',
       'click .btn-delete-line'		: 'delete_line',
       'click .btn-add-line'		: 'confirm_line',
       'change .select-status'		: 'change_status'
    },

	initialize: function () {

		this.render();

	}, 

	render: function () {
		
		
		var t = this;
		
		active(t.active);
		
	    $(this.el).html(this.template);
	    
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
	    
	    // Inizialize table
	    $(this.table).append( _.template(this.tableRenderAdd) );
	    
	    window.model = new InoviceTableModel();
	    	    
	    return this;

	},
	
	cancel: function(){
		
		app.navigate('facturas', true);
		
	},
	
	change_status: function(ev){
		
		$(this.clases.label_status).html( $(ev.currentTarget).val() );
		
	},
	
	// Buton -- insertar fila
	add_line: function(ev){
		
		$(this.table).append( _.template(this.tableRenderAdd) );
		
	},
	
	// Buton -- reiniciar tabla
	table_reset: function(){
		
		row_number = 1;
		
		$(this.table).html( _.template(this.tableRenderAdd) );
		
	},
	
	// Buton -- confirmar una fila
	confirm_line: function(ev){
		
		var line = $(ev.currentTarget).parent().parent();
		
		model.add({
			"id"				: line.find('.number').text(),
			"descripcion"		: line.find('input[name="descripcion"]').val(),
			"moneda"			: line.find('select[name="moneda"]').val(),
			"precio_unitario"	: line.find('input[name="precio-unitario"]').val(),
			"total"				: line.find('input[name="total"]').val()
		});
				
		$(this.table).html( this.tableRender( {"rows": model.toJSON()} ) );
		
		//console.log(model.toJSON());
		
		
		// Suma de valores
		var subtotal = 0;
		var iva = 0;
		var total = 0;	
		
		model.each(function(m) {
			
			console.log(m.toJSON().total.replace(/\./g,''));
			// Replace de puntos por vacio para sumar el total
			subtotal += parseInt(m.toJSON().total.replace(/\./g,''));			
			
		}, this);		
		
		// Calculo el IVA
		iva = (subtotal * PATH_IVA) / 100;	
		
		// Calculo el total
		total = subtotal - iva;		
		
		// 
		subtotal = subtotal.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
		subtotal = subtotal.split('').reverse().join('').replace(/^[\.]/,'');
		
		iva = iva.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
		iva = iva.split('').reverse().join('').replace(/^[\.]/,'');
		
		total = total.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
		total = total.split('').reverse().join('').replace(/^[\.]/,'');
		
		//console.log(subtotal);

		$(this.clases.label_sub_total).html(subtotal);
		$(this.clases.label_iva).html(iva);
		$(this.clases.label_total).html(total);
		
		/*
		var subtotal = 0;
		var iva = 0;
		var total = 0;
		
		model.each(function(m) {
		  
			subtotal += m.toJSON().total;
			
			console.log(m.toJSON());
			
		}, this);
		
		iva = (subtotal * PATH_IVA) / 100;	
		total = subtotal - iva;
		
		$(this.clases.label_sub_total).html(subtotal);
		$(this.clases.label_iva).html(iva);
		$(this.clases.label_total).html(total);
		*/
		
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


