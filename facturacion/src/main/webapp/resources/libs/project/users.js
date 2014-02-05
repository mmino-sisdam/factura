
// Modelo Usuarios

var UsersModel = Backbone.Model.extend({ 
	url: 'personas/list.do'
});

// Vista del listado de usuarios totales
var UsersView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-list-user').html() ),

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

	},

	user_delete: function(ev){

		var id = $(ev.currentTarget).attr('data');
		var usuario = $(ev.currentTarget).attr('data-usuario');

		var msg = ModelDelete.set({'title': 'Eliminar Usuario', 'body': '¿Confirma la eliminacion del usuario '+ usuario +'?'});

		var view = new ModalView({ model: msg });
		view.show();

	}     
});


var NewUsuerView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-new-user').html() ),

	initialize: function () {

		this.render();

	}, 

	render: function () {

	    $(this.el).html(this.template);
	    return this;

	}

});



// Modelo Modal

var ModelDelete = new Backbone.Model({ 

	title: '', 
	body: '' 

});

var ModalView = Backbone.View.extend({

	el: '#modal',

    events: {
        'click .btn-aceptar': 'accept'
    },

    initialize: function() {
        this.template = _.template($('#tmpl-modal').html());
    },

    render: function() {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    },

    show: function() {
        $(document.body).append(this.render().el);                
    },

    accept: function() {
        console.log('aceptado...');
    }
       
});

