
window.Inovice = Backbone.Model.extend({
	//urlRoot: "facturas",
	urlRoot: "../../facturacion/resources/json/facturas.json"
});

window.InoviceTable = Backbone.Model.extend({
	defaults: {
		"id"				: null,
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
	
	table: '.table-fc-body',
	
	tableRenderAdd: $('#tmpl-fc-a-item').html(),
	
	tableRender: $('#tmpl-fc-r-item').html(),

    events: {
       'click .btn-table-insert'	: 'insert',
       'click .btn-table-reset'		: 'table_reset',
       'click .btn-delete-line'		: 'delete_line',
       'click .btn-add-line'		: 'add_line',
    },

	template: _.template( $('#tmpl-fc-a-invoice').html() ),

	initialize: function () {

		this.render();

	}, 

	render: function () {

	    $(this.el).html(this.template);
	    
	    $('.form-datepicker').datepicker({
	    	format: "dd/mm/yyyy",
			autoclose: true,
			startDate: '-1d'
	    });
	
	    $(this.table).append( _.template(this.tableRenderAdd) );
	    
	    
	    
	    return this;

	},
	
	insert: function(ev){
		
		//var where = $(ev.currentTarget).attr('data');		
		
		//if(where == 'prepend'){
		// Instert prepend	
		//	$(this.table).prepend( this.tableRenderAdd );
			
		//}else{
		// Instert append
		 $(this.table).append( _.template(this.tableRenderAdd) );
			
		//}
		
	},
	
	table_reset: function(){
		
		$(this.table).html( this.tableRenderAdd );
		
	},
	
	add_line: function(ev){
		
		var i = $(ev.currentTarget).parent().parent();
		
		var tableModel = new InoviceTable();
		
		console.log(tableModel);
		/*
		tableModel.set({
			"numero"			: i.find('.number').text(),
			"descripcion"		: i.find('input[name="descripcion"]').val(),
			"moneda"			: i.find('select[name="moneda"]').val(),
			"precio_unitario"	: i.find('input[name="precio-unitario"]').val(),
			"total"				: i.find('input[name="total"]').val()
		});
		*/
		$(this.table).append( _.template(this.tableRender),{
			"numero"			: i.find('.number').text(),
			"descripcion"		: i.find('input[name="descripcion"]').val(),
			"moneda"			: i.find('select[name="moneda"]').val(),
			"precio_unitario"	: i.find('input[name="precio-unitario"]').val(),
			"total"				: i.find('input[name="total"]').val()
		});
		
		
		
	},
	
	delete_line: function(ev){
		
		$(ev.currentTarget).parent().parent().remove();
		
		row_number--;
		
	}

});
