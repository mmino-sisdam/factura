
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
		'click .btn-info'		: 'invoice_info'
	},
	
	initialize: function () {
		
		// Indicadores dashboard
		this.indicadores = new ReportesIndicadoresCollection();
		this.indicadores.create({ "desde": "01/02/2014", "hasta": "28/02/2014"});
		
		// Facturas vencidas
		this.facturas = new ReportsInvoiceCollection();
		this.facturas.create({ "desde": "01/02/2014", "hasta": "28/02/2014"});
		
		// Vendedor
		this.vendedor = new ReportesVendedorCollection();
		this.vendedor.create({ "desde": "01/02/2014", "hasta": "28/02/2014"});		

		// Productos
		this.producto = new ReportesProductoCollection();
		this.producto.create({ "desde": "01/02/2014", "hasta": "28/02/2014"});	
		
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
				
		return this;
	    
	},
	
	invoice_info: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_INFO + id, true);
			
	}	

});


