<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <script id="tmpl-list-user" type="text/template">
      <div id="usuarios" class="main-panel">
        <ol class="breadcrumb">
          <li><a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li class="active">Usuarios</li>
        </ol>

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Usuarios registrados 
              </div>
              <div class="panel-body">

                <div class="btn-group">
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      Usuarios por p&aacute;gina
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#">10</a></li>
                      <li role="presentation"><a role="menuitem" href="#">20</a></li>
                      <li role="presentation"><a role="menuitem" href="#">30</a></li>
                      <li role="presentation"><a role="menuitem" href="#">40</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#">Todos</a></li>
                    </ul>
                  </div>  
                  <div class="btn-group">
                    <a href="#/usuario/nuevo" class="btn btn-primary dropdown-toggle">
                      <span class="glyphicon glyphicon-user"></span>
                      Agregar usuario
                    </a>
                  </div>                   
                </div>

                
                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Usuario</th>
                      <th>Nombre</th>
                      <th>Apellido</th>
                      <th>Email</th>
                      <th>Tel&eacute;fono</th>
                      <th>Perfil</th>
                      <th>Acciones</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                    <@ count = 0 @>

                    <@ _.each(usuarios, function(u) { @>

                      <@ count++ @>

                      <tr id="user-<@= u.id @>">
                        <td><@= u.username @></td>
                        <td><@= u.nombre @></td>
                        <td><@= u.apellido @></td>
                        <td><@= u.mail @></td>
                        <td><@= u.telefono @></td>
                        <td><@= u.rol.descripcion @></td>
                        <td>
                          <a class="btn btn-xs btn-primary" href="#/usuario/editar/<@= u.id @>">
                            <i class="glyphicon glyphicon-pencil"></i>
                          </a>
                          <button class="btn btn-xs btn-danger"
                             data="<@= u.id @>" 
                             data-usuario="<@= u.nombre @> <@= u.apellido @>" 
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
                

                <div class="panel-data-table left">
                  <p class="panel-data-table-text">Mostrando <@= count @> de <@= usuarios.length @>  entradas</p>                      
                </div>
                <!--div class="panel-data-table right">
                  <ul class="pagination pagination-sm">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>  
                </div-->                  
              </div>
            </div>            
        </section>

      </div>
      </script>