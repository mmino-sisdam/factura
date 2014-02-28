<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <script id="tmpl-new-user" type="text/template">
      <div class="panel-usuarios main-panel">

        <ol class="breadcrumb">
          <li><a href="#/dashboard"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li><a href="#/usuarios">Usuarios</a></li>
          <li class="active">Nuevo</li>
        </ol>

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Creaci&oacute;n de usuario 
              </div>
              <div class="panel-body">

                <form role="form" id="frm-new-user">
                  <fieldset>
                    <div class="row">
					  
					  <@ if(id){ print('<input type="hidden" name="id" value="'+ id +'"/>') } @>

	
                      <!-- columna 1 -->
                      <div class="col-md-4 clearfix col-1">
                        <div class="form-group">
                          <label for="">Nombre</label>
                          <input type="text" name="nombre" class="form-control required" placeholder="Ingesar nombre" value="<@= nombre @>"/>
                        </div>
                        <div class="form-group">
                          <label for="">Apellido</label>
                          <input type="text" name="apellido" class="form-control required" placeholder="Ingesar apellido" value="<@= apellido @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Email</label>
                          <input type="email" name="mail" class="form-control required email" placeholder="Ingesar email" value="<@= mail @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Tel&eacute;fono</label>
                          <input type="text" name="telefono" class="form-control" placeholder="Ingesar tel&eacute;fono" value="<@= telefono @>" />
                        </div>
                      </div>

                      <!-- columna 2 -->
                      <div class="col-md-4 clearfix col-2">
                        <div class="form-group">
                          <label for="">Usuario</label>
                          <input type="text" name="username" class="form-control required" placeholder="Ingesar usuario" value="<@= username @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Contrase&ntilde;a</label>
                          <input type="password" name="password" class="form-control required" id="username_password" placeholder="Ingesar contrase&ntilde;a" />
                        </div>
                        <div class="form-group">
                          <label for="">Repetir contrase&ntilde;a</label>
                          <input type="password" class="form-control required" equalto="#username_password" placeholder="Repetir contrase&ntilde;a" >
                        </div>
                      </div>

                      <!-- columna 3 -->
                      <div class="col-md-4 clearfix col-3">
                        <div class="form-group">
                          <label for="">Perfil</label>
                          <select class="form-control" name="rol">
                            <option value="2" <@ if(rol.id == 2) { print('selected'); } @> >Administrador</option>
                            <option value="1" <@ if(rol.id == 1) { print('selected'); } @> >Usuario</option>
                          </select>
                        </div>
                        <div class="form-group">
                          <label for="">Activo</label>
                          <select class="form-control" name="enabled">
                            <option value="1" <@ if(enabled) { print('selected'); } @> >Si</option>
							<option value="0" <@ if(!enabled) { print('selected'); } @> >No</option>
                          </select>
                        </div>
                      </div>

                      <div class="col-md-12 clearfix">
                        <hr>
                      </div> 

                      <div class="col-md-12 clearfix">
                        <button type="button" class="btn btn-right btn-primary btn-accept">Aceptar</button>
                        <button type="button" class="btn btn-right btn-primary btn-cancel">Cancelar</button>
                      </div>
                    </div>
                  </fieldset>
                </form>
                     
              </div>
            </div>            
        </section>

      </div>
    </script>