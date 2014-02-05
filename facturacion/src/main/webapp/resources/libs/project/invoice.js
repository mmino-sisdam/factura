
var InvoiceModel = Backbone.Model.extend({ 
	url: 'json/facturas.json'
});

// Vista del listado de facturas totales
var InvoiceView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-list-invoice').html() ),

	events: {
		'click .btn-danger': 'user_delete'
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