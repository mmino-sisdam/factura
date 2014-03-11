
// Model
window.ReportesVendedorCollection = Backbone.Collection.extend({
	url: "reportes/vendedor"
});

window.ReportesProductoCollection = Backbone.Collection.extend({
	url: "reportes/producto"
});

window.ReportesIndicadoresCollection = Backbone.Collection.extend({
	url: "reportes/indicadores"
});

window.ReportsInvoiceCollection = Backbone.Collection.extend({
	url: "reportes/vencimiento"
});

var DashboardView = Backbone.View.extend({

	el: PATH_LAYOUT,
		
	active:".btn-dashboard",

	template: _.template( $('#tmpl-dashboard').html() ),

	events: {
		'click .btn-info'		: 'invoice_info',
		'click .btn-change-data': 'invoice_data',
		'click .btn-find-date': 'invoice_find'
	},
	
	initialize: function(options) {
		
		$(this.el).unbind();
		
		// Indicadores dashboard
		this.indicadores = new ReportesIndicadoresCollection();
		this.indicadores.create({'desde': options.desde, 'hasta': options.hasta});
		
		// Facturas vencidas
		this.facturas = new ReportsInvoiceCollection();
		this.facturas.create({'desde': options.desde, 'hasta': options.hasta});
		
		// Vendedor
		this.vendedor = new ReportesVendedorCollection();
		this.vendedor.create({'desde': options.desde, 'hasta': options.hasta});		

		// Productos
		this.producto = new ReportesProductoCollection();
		this.producto.create({'desde': options.desde, 'hasta': options.hasta});	
		
		this.listenTo(this.indicadores, 'change', this.render);
		
	}, 

	render: function () {
		
		active(this.active);
							
		$(this.el).html(this.template({
			
			"indicadores": this.indicadores.toJSON(),
			
			"invoice": this.facturas.toJSON(),
			
			"vendedor": this.vendedor.toJSON(),
			
			"producto": this.producto.toJSON()
			
		}));	
		
		this.popover_date();
				
		return this;
	    
	},
	
	invoice_info: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_INFO + id, true);
			
	},
	
	invoice_data: function(ev){
		
		if( $(ev.currentTarget).hasClass('popover-open') ){
			
			$('.btn-change-data').popover('hide').removeClass('popover-open');
			
		}else{
			
			$('.btn-change-data').popover('show').addClass('popover-open');
			
			$('.form-datepicker').datepicker({
				format: "dd/mm/yyyy",
				autoclose: true
			});
			
		}
		
		
	},
	
	invoice_find: function(){

		var start = $('[name="fecha-desde"]').val();
		var end   = $('[name="fecha-hasta"]').val();
		
		if(start != '' && end != ''){
			
			app.navigate(URL_DASHBOARD + '/' + start.replace(/\//gi, "-") + '/' + end.replace(/\//gi, "-"), true);
			
		}else{
			
        	msg = AlertModel.set({
        		'type': 'error',
        		'body': MSG_DASHBOARD_DATE_ERROR
        	});
        	
        	new AlertView({model: msg });  			
			
		}

		
		
		
	},
	
	popover_date: function(){
		
		$('.btn-change-data').popover({
			html: true,
			trigger: 'manual',
			content: '<div class="form-group">\
						<label>Fecha desde</label>\
						<input type="text" name="fecha-desde" class="form-control form-datepicker" placeholder="" />\
					  </div>\
					  <div class="form-group">\
						<label>Fecha hasta</label>\
						<input type="text" name="fecha-hasta" class="form-control form-datepicker" placeholder="" />\
					  </div>\
					  <button type="button" class="btn btn-sm btn-primary btn-find-date">Buscar</button>'
		});

	}

});


