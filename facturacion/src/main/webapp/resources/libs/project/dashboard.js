
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

// Indicadores por vendedor
window.IndicadoresVendedorView = Backbone.View.extend({
	
	el: PATH_D_VENDEDOR,
	template: _.template( $('#tmpl-dashboard-vendedor').html() ),
	initialize: function () {

		// Tabla vendedor
		this.model = new ReportesVendedorCollection();
		this.model.create();
		
		this.model.bind('change', this.render, this);
		
	},
	render: function () {
					
		$(this.el).html( this.template( {"vendedor": this.model.toJSON()} ) );
	    return this;
	    
	}	
}); 

//Indicadores por producto
window.IndicadoresProductoView = Backbone.View.extend({
	
	el: PATH_D_PRODUCTO,
	template: _.template( $('#tmpl-dashboard-producto').html() ),
	initialize: function () {

		// Tabla vendedor
		this.model = new ReportesProductoCollection();
		this.model.create();
		
		this.model.bind('change', this.render, this);
		
	},
	render: function () {
		
		console.log({"producto": this.model.toJSON()});
					
		$(this.el).html( this.template( {"producto": this.model.toJSON()} ) );
	    return this;
	    
	}	
}); 

//Indicadores por vencimiento
window.IndicatorsInvoiceView = Backbone.View.extend({
	
	el: PATH_D_INVOICE,
	
	template: _.template( $('#tmpl-dashboard-facturas').html() ),
	
	events: {
		'click .btn-info'		: 'invoice_info',
	},	
	
	initialize: function () {

		// Tabla vendedor
		this.model = new ReportsInvoiceCollection();
		this.model.create();
		
		this.model.bind('change', this.render, this);
		
	},
	
	render: function () {
		//console.log({"invoice": this.model.toJSON()});
		$(this.el).html( this.template( {"invoice": this.model.toJSON()} ) );
	    return this;
	    
	},
	
	invoice_info: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_INVOICE_INFO + id, true);
			
	}
}); 

var DashboardView = Backbone.View.extend({

	el: PATH_LAYOUT,
		
	active:".btn-dashboard",

	template: _.template( $('#tmpl-dashboard').html() ),
	
	initialize: function () {
					
		this.indicadores = new ReportesIndicadoresCollection();
		this.indicadores.create();
		
		this.indicadores.bind('change', this.render, this);
		
	}, 

	render: function () {
		
		active(this.active);
							
		$(this.el).html( this.template( {"indicadores": this.indicadores.toJSON()} ) );
	    
		setTimeout(this.afterRender,1000);
		
		return this;
	    
	},
	
	afterRender: function() {
		
		new IndicadoresVendedorView();
		new IndicadoresProductoView();
		new IndicatorsInvoiceView();
		
	}

});


