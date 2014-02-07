
var InvoiceModel = Backbone.Model.extend({ 
	url: 'json/facturas.json'
});

// Vista del listado de facturas totales
var InvoiceView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-list-invoice').html() ),

	events: {
		//'click .btn-danger': 'user_delete'
	},

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {

	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	}

});


// Vista de una nueva factura tipo A
var NewInvoiceView_A = Backbone.View.extend({

	el: PATH_LAYOUT,

    events: {
       // 'click .btn-aceptar': 'accept'
    },

	template: _.template( $('#tmpl-fc-a-invoice').html() ),

	initialize: function () {

		this.render();

	}, 

	render: function () {

	    $(this.el).html(this.template);
	    return this;

	}

});