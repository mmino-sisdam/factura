
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
		
	}

});


