

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



window.DeleteModel = new Backbone.Model({ 
	title		: '', 
	body		: '',
	modal_id	: 'modal'
});

window.ChangeModel = new Backbone.Model({ 
	id			: ''
});

window.AlertModel = new Backbone.Model({ 
	'type'		: '', 
	'body'		: ''
});


window.UserCollection = Backbone.Collection.extend({
	url: "personas"
});

window.PasswordCollection = Backbone.Collection.extend({
	url: "password"
});


/*
 * 	Vision total de usuarios
 * */

window.UsersView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-usuarios",

	template: _.template( $('#tmpl-list-user').html() ),

	events: {
		'click .btn-add'		: 'user_add',
		'click .btn-delete'		: 'user_delete',
		'click .btn-edit'		: 'user_edit',
		'click .btn-password'	: 'user_password'
	},

	initialize: function () {

		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {
		
		active(this.active);
		
	    $(this.el).html(this.template(this.model.toJSON()));
	    	    		 
	    return this;

	},
	
	user_add: function(ev){
		
		app.navigate(URL_USER_ADD, true);
		
	},
	
	user_edit: function(ev){
		
		var id = $(ev.currentTarget).attr('data');
		
		app.navigate(URL_USER_EDIT + id, true);
		
	},
	
	user_password: function(ev){
		
		var id = $(ev.currentTarget).attr('data');	
		
		app.navigate(URL_USER_PASS + id, true);
		
	},

	user_delete: function(ev){

		var id = $(ev.currentTarget).attr('data');
		var usuario = $(ev.currentTarget).attr('data-usuario');

		var msg = DeleteModel.set({
			'title'	: 'Eliminar Usuario', 
			'body'  : '¿Confirma la eliminaci&oacute;n de '+ usuario +'?',
			'id'	: id
		});

		var view = new DeleteUserView({ model: msg });
		view.show();

	}     
});


/*
 * 	Creacion de usuario
 * */

window.FormUsuerView = Backbone.View.extend({
	
	el: PATH_LAYOUT,
	
	active:".btn-usuarios",

	template: _.template( $('#tmpl-new-user').html() ),

    events: {
        'click .btn-accept': 'accept',
        'click .btn-cancel': 'cancel'
    },

	initialize: function(options) {
			
		$(this.el).unbind();
		
		this.model.fetch();
		this.model.bind('change', this.render, this);

	}, 

	render: function (options) {
		
		active(this.active);
		
	    $(this.el).html(this.template(this.model.toJSON()));
	
	    
	    // Remove a la columna de usuario y contraseña
	    if(this.model.toJSON().id != null){
	    	
	    	$(this.el).find('.col-2').remove();
	    	$(this.el).find('.col-1, .col-3').removeClass('col-md-4').addClass('col-md-6');
	    	
	    }
	    
	    return this;

	},

	// Btn click Aceptar / Save usuario
    accept: function() {
    	    	    	
    	if( $('#frm-new-user').valid() ){
    		
	    	this.post = new UserCollection();
	    	var data = $('#frm-new-user').serializeObject();
	    	var result = _.extend(data, {
	    								"enabled": parseInt( $('.select-enabled option:selected').val(), 10 ),
	    								 "rol": {
	    									 "id": $('.select-rol option:selected').val() 
	    								  }
	    								});

	    	this.post.create(result, {
				success: function(response) {
					
					var msg = AlertModel.set({
	            		'type': 'success',
	            		'body': MSG_SUCCESS
	            	});
	            	
	            	new AlertView({model: msg });
				
					app.navigate(URL_USERS, true);
					
				},
	            error : function(err, response) {
	            	
	            	var msg = AlertModel.set({
	            		'type': 'error',
	            		'body': MSG_ERROR
	            	});
	            	
	            	new AlertView({model: msg });       
	        		
	            }
			}); 
    	}else{
  
        	var msg = AlertModel.set({
        		'type': 'error',
        		'body': 'Completa los campos requeridos'
        	});
        	
        	new AlertView({model: msg }); 
        	
    	}
    	
    	
    },
    
    cancel: function(){
    	
    	app.navigate(URL_USERS, true);
    	
    }

});


/*
 * 	Edicion password de usuario
 * */

window.EditUserPassView = Backbone.View.extend({

	el: PATH_LAYOUT,
	
	active:".btn-usuarios",

	template: _.template( $('#tmpl-password-user').html() ),

	events: {
		'click .btn-accept': 'accept',
		'click .btn-cancel': 'cancel'
	},

	initialize: function () {
		
		$(this.el).unbind();
		
		this.model.fetch();
		this.model.bind('change', this.render, this); 

	}, 

	render: function () {
		
		active(this.active);
		
	    $(this.el).html(this.template(this.model.toJSON()));
	    return this;

	},

	// Btn click Aceptar / Save password usuario
    accept: function() {
    	
    	if( $('#frm-password-user').valid() ){
    		
	    	var password = new PasswordCollection();
		    		
	    	password.create({
	    		"id"					: $("input[name='id']").val(),
	    	    "newPassword"			: $("input[name='newPassword']").val(),
	    	    "repeatNewPassword"		: $("input[name='repeatNewPassword']").val()
	    	} , {
				success: function() {
	
					var msg = AlertModel.set({
	            		'type': 'success',
	            		'body': MSG_USER_PASS_SUCCES
	            	});
	            	
	            	new AlertView({model: msg });
	            	
					app.navigate(URL_USERS, true);
					
				},
	            error : function(err) {
	            	
	            	var msg = AlertModel.set({
	            		'type': 'error',
	            		'body': MSG_USER_PASS_ERROR
	            	});
	            	
	            	new AlertView({model: msg });             	
	            	
	            }
			}); 
    	}
    	
    },
    
    cancel: function(){
    	
    	app.navigate(URL_USERS, true);
    	
    }		
	
});


/*
 * 	Eliminacion de usuario
 * */

window.DeleteUserView = Backbone.View.extend({

	el: PATH_MODAL,
	
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
    
    hide: function(){
    	$('#modal').modal('hide');
    },

    accept: function() {
    	
    	this.hide();
    	
    	var id = this.model.attributes.id;
    	
    	var user = new User({"id":id});
    	    	
    	user.destroy({
    		success: function(response) {
				
				var msg = AlertModel.set({
            		'type': 'success',
            		'body': MSG_SUCCESS
            	});
            	
            	new AlertView({model: msg });
            	
            	$('#user-' + id).remove();
							
			},
            error : function(err, response) {
            	
            	var msg = AlertModel.set({
            		'type': 'error',
            		'body': MSG_ERROR
            	});
            	
            	new AlertView({model: msg });       
        		
            }
    	});	
    	    	
    }
       
});

