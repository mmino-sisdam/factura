

var DashboardView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-dashboard').html() ),

	initialize: function () {

		this.render();

	}, 

	render: function () {

	    $(this.el).html(this.template);
	    return this;

	}

});


