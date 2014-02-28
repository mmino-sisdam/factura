<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <script id="tmpl-list-clients" type="text/template">
      <div id="usuarios" class="main-panel">
        <ol class="breadcrumb">
          <li><a href="#/dashboard"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li class="active">Clientes</li>
        </ol>

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Clientes registrados 
              </div>
              <div class="panel-body">

                <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle btn-add">
                      <span class="glyphicon glyphicon-briefcase"></span>
                      Agregar cliente
                    </button>                                 
                </div>

 				<div class="row">
					<div class="col-md-12 clearfix"><hr></div>
				</div>

				<div class="table-responsive">               
                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Nombre</th>
                      <th>Cuit</th>
                      <th>Direcci&oacute;n</th>
                      <th>Localizaci&oacute;n</th>
                      <th>Acciones</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                    <@ count = 0 @>

                    <@ _.each(clientes, function(c) { @>

                      <@ count++ @>

                      <tr id="client-<@= c.id @>">
                        <td><@= c.nombre @></td>
                        <td><@= c.cuit @></td>
                        <td><@= c.direccion @></td>
                        <td><@= c.localizacion @></td>
                        <td>
                          <button type="button" title="Editar a <@= c.nombre @>" class="btn btn-xs btn-primary btn-edit" data="<@= c.id @>">
                            <i class="glyphicon glyphicon-pencil"></i>
                          </button>
                          <button type="button" class="btn btn-xs btn-danger btn-delete" 
								  title="Eliminar a <@= c.nombre @>"
                             	  data="<@= c.id @>"
                             	  data-client="<@= c.nombre @>"
                             	  data-toggle="modal" 
                             	  data-target="#modal">
                             	  <i class="glyphicon glyphicon-remove"></i>
                          </button>
                        </td>
                      </tr>

                    <@ }); @>    

                    </tr>
                  </tbody>
                </table>
                </div>

                <div class="panel-data-table left">
                  <p class="panel-data-table-text">Mostrando <@= count @> de <@= clientes.length @>  entradas</p>                      
                </div>                
              </div>
            </div>            
        </section>

      </div>
      </script>
  
