

var DashboardView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-dashboard",

	template: _.template( $('#tmpl-dashboard').html() ),

	initialize: function () {

		this.render();

	}, 

	render: function () {
		
		active(this.active);

	    $(this.el).html(this.template);
	    return this;

	}

});


