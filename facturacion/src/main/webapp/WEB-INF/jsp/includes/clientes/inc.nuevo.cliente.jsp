<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <script id="tmpl-new-client" type="text/template">
      <div class="panel-usuarios main-panel">

        <ol class="breadcrumb">
          <li><a href="#/dashboard"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li><a href="#/clientes">Clientes</a></li>
          <li class="active">Nuevo</li>
        </ol>

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Creaci&oacute;n de usuario 
              </div>
              <div class="panel-body">

                <form role="form" id="frm-new-client">
                  <fieldset>
                    <div class="row">
					  <@ if(id){ print('<input type="hidden" name="id" value="'+ id +'"/>') } @>
                      <!-- columna 1 -->
                      <div class="col-md-6 clearfix col-1">
                        <div class="form-group">
                          <label for="">Nombre</label>
                          <input type="text" name="nombre" class="form-control required" placeholder="Ingesar nombre" value="<@= nombre @>"/>
                        </div>
                        <div class="form-group">
                          <label for="">Direcci&oacute;n</label>
                          <input type="text" name="direccion" class="form-control required" placeholder="Ingesar direcci&oacute;n" value="<@= direccion @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Localizaci&oacute;n</label>
                          <input type="text" name="localizacion" class="form-control required" placeholder="Ingesar localizaci&oacute;n" value="<@= localizacion @>" />
                        </div>
                      </div>

                      <!-- columna 2 -->
                      <div class="col-md-6 clearfix col-2">
                        <div class="form-group">
                          <label for="">Cuit</label>
                          <input type="text" name="cuit" maxlength="15" class="form-control required" placeholder="Ingesar cuit" value="<@= cuit @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Tipo IVA</label>
								<select name="idTipoIVA" class="form-control cliente-retencion">
		                      		<option value="1">Responsable inscripto</option>
									<option value="2">No inscripto</option>
									<option value="3">Exento</option>
									<option value="4">Consumidor final</option>
								</select>                       
						</div>
                        <div class="form-group">
                          <label for="">Tipo Retenci&oacute;n</label>
								<select name="idTipoRetencion" class="form-control cliente-retencion">
		                      		<option value="1">Sin retención</option>
									<option value="2">80%</option>
									<option value="3">50%</option>
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