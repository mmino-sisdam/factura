<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <script id="tmpl-password-user" type="text/template">
      <div class="panel-usuarios main-panel">

        <ol class="breadcrumb">
          <li><a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li><a href="#/usuarios">Usuarios</a></li>
          <li class="active">Cambiar contrase&ntilde;a</li>
        </ol>

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Modificar contrase&ntilde;a de <@= nombre @> <@= apellido @>
              </div>
              <div class="panel-body">

                <form role="form" id="frm-password-user">
                  <fieldset>
                    <div class="row">
					  
					  <input type="hidden" name="id" value="<@= id @>"/>

                      <!-- columna 2 -->
                      <div class="col-md-6 clearfix col-2">
                        <div class="form-group">
                          <label for="">Contrase&ntilde;a</label>
                          <input type="password" name="newPassword" class="form-control required" id="username_password" placeholder="Ingesar contrase&ntilde;a" />
                        </div>
                        <div class="form-group">
                          <label for="">Usuario</label>
						  <p><@= username @></p>
                        </div>
                      </div>

                      <!-- columna 3 -->
                      <div class="col-md-6 clearfix col-3">
						<div class="form-group">
                          <label for="">Repetir contrase&ntilde;a</label>
                          <input type="password" name="repeatNewPassword" class="form-control required" equalto="#username_password" placeholder="Repetir contrase&ntilde;a" >
                        </div>
                        <div class="form-group">
                          <label for="">Email</label>
						  <p><@= mail @></p>
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