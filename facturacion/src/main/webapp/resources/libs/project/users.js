

// Model

window.User = Backbone.Model.extend({
	urlRoot: "personas",
	defaults: {
		"id"		: null,
	    "nombre"	: "",
	    "apellido"	: "",
	    "mail"		: "",
	    "telefono"	: "",
	    "username"	: "",
	    "password"	: "",
	    "rol"		: {
	    	"id"	: ""
	    },
	    "enabled"	: ""
	  }
});

//window.UserCollection = Backbone.Model.extend({});

window.UserCollection = Backbone.Collection.extend({
	model: User,
	url: "personas"
});


/*
var UsersModel = Backbone.Model.extend({ 
	url: 'personas'
});
*/

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

		var msg = ModelDelete.set({
			'title'	: 'Eliminar Usuario', 
			'body'  : '¿Confirma la eliminacion del usuario '+ usuario +'?',
			'id'	: id
		});

		var view = new ModalView({ model: msg });
		view.show();

	}     
});


var NewUsuerView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-new-user').html() ),

    events: {
        'click .btn-accept': 'accept'
    },

	initialize: function () {

		this.render();

	}, 

	render: function () {

	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},

	// Btn click Aceptar / Save usuario
    accept: function() {
    	
    	var u = new UserCollection();
	    		
    	u.create({
    		"id"			: null,
    	    "nombre"		: $("input[name='nombre']").val(),
    	    "apellido"		: $("input[name='apellido']").val(),
    	    "mail"			: $("input[name='mail']").val(),
    	    "telefono"		: $("input[name='telefono']").val(),
    	    "username"		: $("input[name='username']").val(),
    	    "password"		: $("input[name='password']").val(),
    	    "rol"			: {
    	    	"id"		: $("select[name='rol'] option:selected").val()
    	    },
    	    "enabled"		: parseInt( $("select[name='enabled'] option:selected").val(), 10 )
    	} , {
			success: function() {
				console.log('ok');
			}
		}); 	
    	
    }	

});


// Editar

var EditUserView = Backbone.View.extend({

	el: PATH_LAYOUT,

	template: _.template( $('#tmpl-new-user').html() ),

	events: {
		'click .btn-accept': 'accept'
	},

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {

	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},

	// Btn click Aceptar / Save usuario
    accept: function() {
    	
    	var u = new UserCollection();
	    		
    	u.create({
    		"id"			: $("input[name='id']").val(),
    	    "nombre"		: $("input[name='nombre']").val(),
    	    "apellido"		: $("input[name='apellido']").val(),
    	    "mail"			: $("input[name='mail']").val(),
    	    "telefono"		: $("input[name='telefono']").val(),
    	    "username"		: $("input[name='username']").val(),
    	    "password"		: $("input[name='password']").val(),
    	    "rol"			: {
    	    	"id"		: $("select[name='rol'] option:selected").val()
    	    },
    	    "enabled"		: parseInt( $("select[name='enabled'] option:selected").val(), 10 )
    	} , {
			success: function() {
				
				//app.navigate('usuarios');
				
			}
		}); 	
    	
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
    	
    	console.log(this.model.attributes.id);
    	
    	var a = new UserCollections();
    	
    	a.destroy({
    		"id": this.model.attributes.id
    	}, {
			success: function() {
				console.log('ok');
			}
		});
    	
    }
       
});

