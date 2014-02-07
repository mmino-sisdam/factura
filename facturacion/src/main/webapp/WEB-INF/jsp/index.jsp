<!DOCTYPE html>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <title>Loyal Admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet/less" type="text/css" href="resources/css/styles.less" />
    <link href="resources/libs/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
  
    <div class="page-containter">
      
      <div class="sidebar-menu">

        <header>
          <div class="logo">
              <a href="#"><img src="resources/images/logo.jpg" alt="Loyal"/></a>
          </div>
        </header>

        <div class="search">
          <form>
            <fieldset>
                <input type="text" name="q" class="search-input" placeholder="Search something..."/>
                <button type="submit">
                  <i class="glyphicon glyphicon-search"></i>
                </button>
            </fieldset>
          </form>
        </div>

        <ul class="main-menu">
          <li><a href="#/" class="btn-menu btn-dashboard"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
          <li><a href="#/facturas" class="btn-menu btn-facturas"><i class="glyphicon glyphicon-list-alt"></i> Facturas</a></li>
          <li><a href="#/usuarios" class="btn-menu btn-usuarios"><i class="glyphicon glyphicon-user"></i> Usuarios</a></li>
        </ul>

      </div>

      <div class="main-content">
        
        <section class="row">
            <div class="col-md-6 col-sm-8 clearfix">Bienvenido Admin</div>
            <div class="col-md-6 col-sm-4 clearfix">
            	<a href=" <c:url value="j_spring_security_logout" /> " class="btn btn-link" title="Logout">Logout</a>
            </div>
        </section>

        <hr>

        <div id="layout"></div>  
        <div id="modal"></div>  

      </div>

    </div>

    <!-- dashboard -->
    <script id="tmpl-dashboard" type="text/template">
      <div id="dashboard" class="main-panel">
        <section class="row margin-bottom">
          <div class="col-md-3 clearfix">

            <div class="boxed boxed-warning">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-exclamation-sign"></i> FACTURACI&Oacute;N PENDIENTE
              </div>
              <div class="boxed-body">
                <span class="boxed-title">$140.000</span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title"><i class="glyphicon glyphicon-circle-arrow-up"></i>50% des de el ultimo mes</span>
              </div>
            </div>

          </div>
          <div class="col-md-3 clearfix">

            <div class="boxed boxed-success">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-flag"></i> FACTURACI&Oacute;N COBRADA
              </div>
              <div class="boxed-body">
                <span class="boxed-title">$40.000</span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title">Febrero 2014</span>
              </div>
            </div>

          </div>
          <div class="col-md-3 clearfix">
            
            <div class="boxed boxed-info">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-chevron-down"></i> VENTAS TOTALES
              </div>
              <div class="boxed-body">
                <span class="boxed-title">
                  <i class="boxed-append">10 ventas</i>
                  $24.000
                </span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title">Febrero 2014</span>
              </div>
            </div>

          </div>
          <div class="col-md-3 clearfix">

            <div class="boxed boxed-primary">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-chevron-down"></i> OTRO ITEM
              </div>
              <div class="boxed-body">
                <span class="boxed-title">
                  $24.000
                </span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title">Febrero 2014</span>
              </div>
            </div>

          </div>
        </section> 

        <section class="row">

         <div class="col-md-6 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Ventas por vendedor
                <span class="panel-right">
                  <div class="dropdown">
                    <a data-toggle="dropdown" href="#" id="datadrop_d01">
                      <span class="glyphicon glyphicon-cog"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="datadrop_d01">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Por ventas [Descendente]</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="1" href="#">Por monto [Descendente]</a></li>
                    </ul>
                  </div>
                  
                </span> 
              </div>
              <div class="panel-body">
                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Vendedor</th>
                      <th>Cant. ventas</th>
                      <th>Monto</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Rafael Gorgori</td>
                      <td>-10</td>
                      <td>$10</td>
                    </tr>
                    <tr>
                      <td>Rafael Gorgori</td>
                      <td>-10</td>
                      <td>$10</td>
                    </tr>
                   <tr>
                      <td>Rafael Gorgori</td>
                      <td>-10</td>
                      <td>$10</td>
                    </tr>
                    <tr>
                      <td>Rafael Gorgori</td>
                      <td>-10</td>
                      <td>$10</td>
                    </tr>
                    <tr>
                      <td>Rafael Gorgori</td>
                      <td>-10</td>
                      <td>$10</td>
                    </tr>
                  </tbody>
                </table>
                <p class="panel-data-table">Mostrando 5 de 28 entradas</p>
              </div>
            </div>

         </div> 

         <div class="col-md-6 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">

                Ventas por imputaci&oacute;n contable

                <span class="panel-right">
                  <div class="dropdown">
                    <a data-toggle="dropdown" href="#" id="datadrop_d02">
                      <span class="glyphicon glyphicon-cog"></span>
                    </a>
                    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="datadrop_d02">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Por ventas [Descendente]</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="1" href="#">Por monto [Descendente]</a></li>
                    </ul>
                  </div>
                  
                </span> 
              </div>
              <div class="panel-body">
                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Periodo</th>
                      <th>Imputaci&oacute;n</th>
                      <th>&nbsp;</th>
                      <th>Monto</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>04/01/14 - 29/01/14</td>
                      <td>Actualizaci&oacute;n</td>
                      <td><span class="label label-primary">Loyal</span></td>
                      <td>$10.002</td>
                    </tr>
                    <tr>
                      <td>04/01/14 - 29/01/14</td>
                      <td>Proyectos Veraz</td>
                      <td><span class="label label-info">Proyectos</span></td>
                      <td>$10.002</td>
                    </tr>
                    <tr>
                      <td>04/01/14 - 29/01/14</td>
                      <td>Licencias</td>
                      <td><span class="label label-primary">Loyal</span></td>
                      <td>$10.002</td>
                    </tr>
                    <tr>
                      <td>04/01/14 - 29/01/14</td>
                      <td>Licencias</td>
                      <td><span class="label label-primary">Loyal</span></td>
                      <td>$10.002</td>
                    </tr>
                    <tr>
                      <td>04/01/14 - 29/01/14</td>
                      <td>Licencias</td>
                      <td><span class="label label-primary">Loyal</span></td>
                      <td>$10.002</td>
                    </tr>
                  </tbody>
                </table>
                <p class="panel-data-table">Mostrando 5 de 28 entradas</p>
              </div>
            </div>
         </div> 

        </section> 

        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Facturaci&oacute;n a vencer
                <span class="panel-right">
                  <div class="dropdown">
                    <a data-toggle="dropdown" href="#" id="datadrop_d01">
                      <span class="glyphicon glyphicon-cog"></span>
                    </a>
                    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="datadrop_d01">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Por fecha [Descendente]</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="1" href="#">Por cliente [Descendente]</a></li>
                    </ul>
                  </div>
                  
                </span> 
              </div>
              <div class="panel-body">

                <div class="btn-group">
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      Items por p&aacute;gina
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#">10</a></li>
                      <li role="presentation"><a role="menuitem" href="#">20</a></li>
                      <li role="presentation"><a role="menuitem" href="#">30</a></li>
                      <li role="presentation"><a role="menuitem" href="#">40</a></li>
                      <li role="presentation"><a role="menuitem" href="#">Todos</a></li>
                    </ul>
                  </div>  
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      Vencen
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#">Esta semana</a></li>
                      <li role="presentation"><a role="menuitem" href="#">En 10 d&iacute;as</a></li>
                      <li role="presentation"><a role="menuitem" href="#">En 15 d&iacute;as</a></li>
                      <li role="presentation"><a role="menuitem" href="#">En 20 d&iacute;as</a></li>
                      <li role="presentation"><a role="menuitem" href="#">Este mes</a></li>
                    </ul>
                  </div>                   
                </div>

                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Fecha emisi&oacute;n</th>
                      <th>Fecha vencimiento</th>
                      <th>Cliente</th>
                      <th>Forma de pago</th>
                      <th>Monto</th>
                      <th>Acciones</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>04/01/14</td>
                      <td>24/01/14</td>
                      <td>Bayer Argentina S.A</td>
                      <td>Cheque</td>
                      <td>$140.210</td>
                      <td>
                        <button type="button" class="btn btn-xs btn-info">
                          <i class="glyphicon glyphicon-info-sign"></i>
                        </button>
                      </td>
                    </tr>
                    <tr>
                      <td>04/01/14</td>
                      <td>24/01/14</td>
                      <td>Bayer Argentina S.A</td>
                      <td>Cheque</td>
                      <td>$140.210</td>
                      <td>
                        <button type="button" class="btn btn-xs btn-info">
                          <i class="glyphicon glyphicon-info-sign"></i>
                        </button>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <p class="panel-data-table">Mostrando 5 de 28 entradas</p>
              </div>
            </div>            
        </section>
      </div>
    </script>

    <!-- listado de usuarios -->
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

                      <tr>
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
                             data-target="#myModal">
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
                <div class="panel-data-table right">
                  <ul class="pagination pagination-sm">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>  
                </div>                  
              </div>
            </div>            
        </section>

      </div>
    </script>

    <!-- nuevo usuario -->
    <script id="tmpl-new-user" type="text/template">
      <div class="panel-usuarios main-panel">

        <ol class="breadcrumb">
          <li><a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
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
                      <div class="col-md-4 clearfix">
                        <div class="form-group">
                          <label for="">Nombre</label>
                          <input type="text" name="nombre" class="form-control" placeholder="Ingesar nombre" value="<@= username @>"/>
                        </div>
                        <div class="form-group">
                          <label for="">Apellido</label>
                          <input type="text" name="apellido" class="form-control" placeholder="Ingesar apellido" value="<@= apellido @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Email</label>
                          <input type="text" name="mail" class="form-control" placeholder="Ingesar email" value="<@= mail @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Tel&eacute;fono</label>
                          <input type="text" name="telefono" class="form-control" placeholder="Ingesar tel&eacute;fono" value="<@= telefono @>" />
                        </div>
                      </div>

                      <!-- columna 2 -->
                      <div class="col-md-4 clearfix">
                        <div class="form-group">
                          <label for="">Usuario</label>
                          <input type="text" name="username" class="form-control" placeholder="Ingesar usuario" value="<@= username @>" />
                        </div>
                        <div class="form-group">
                          <label for="">Contrase&ntilde;a</label>
                          <input type="password" name="password" class="form-control" placeholder="Ingesar contrase&ntilde;a" />
                        </div>
                        <div class="form-group">
                          <label for="">Repetir contrase&ntilde;a</label>
                          <input type="password" class="form-control" placeholder="Repetir contrase&ntilde;a" >
                        </div>
                      </div>

                      <!-- columna 3 -->
                      <div class="col-md-4 clearfix">
                        <div class="form-group">
                          <label for="">Perfil</label>
                          <select class="form-control" name="rol">
                            <option value="1" <@ if(rol.id == 1) { print('selected'); } @> >Usuario</option>
                            <option value="2" <@ if(rol.id == 2) { print('selected'); } @> >Administrador</option>
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
                        <a href="#/usuarios" class="btn btn-right btn-primary">Cancelar</a>
                      </div>
                    </div>
                  </fieldset>
                </form>
                     
              </div>
            </div>            
        </section>

      </div>
    </script>

    <!-- listado de facturas -->
    <script id="tmpl-list-invoice" type="text/template">
      <div class="main-panel">
        <ol class="breadcrumb">
          <li><a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li class="active">Facturas</li>
        </ol>
        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Facturaci&oacute;n
              </div>
              <div class="panel-body">

                <div class="btn-group">
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      Meses por p&aacute;gina
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#">4</a></li>
                      <li role="presentation"><a role="menuitem" href="#">8</a></li>
                      <li role="presentation"><a role="menuitem" href="#">1 a&ntilde;o</a></li>
                      <li role="presentation"><a role="menuitem" href="#">2 a&ntilde;os</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#">Todos</a></li>
                    </ul>
                  </div>  
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      <span class="glyphicon glyphicon-file"></span>
                      Nueva factura
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-A">Factura A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-B">Factura B</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-E">Factura E</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-Nota-de-credito-A">Nota de cr&eacute;dito A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-Nota-de-credito-B">Nota de cr&eacute;dito B</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-Nota-de-credito-E">Nota de cr&eacute;dito E</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-Nota-de-debito-A">Nota de d&eacute;bito A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-Nota-de-debito-B">Nota de d&eacute;bito B</a></li>
                    </ul>
                  </div>                   
                </div>

                <table class="table" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>&nbsp;</th>
                      <th>Fecha</th>
                      <th>N&uacute;mero</th>
                      <th>Form</th>
                      <th>Cliente</th>
                      <th>Monto</th>
                      <th>Rentabilidad</th>
                      <th>Responsable</th>
                      <th>Acciones</th>
                    </tr>
                  </thead>
                  <tbody>

                    <@ _.each(invoice, function(i) { @>

                      <tr class="active">
                        <td><span class="caret"></span></td>
                        <td><@= i.fecha_view @></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><@= i.monto_total @></td>
                        <td><@= i.rentabilidad_total @></td>
                        <td><@= i.responsable @></td>
                        <td>
                          &nbsp;
                        </td>                      
                      </tr>

                      <@ _.each(i.list, function(l) { @>

                        <tr>
                          <td><input type="checkbox" /></td>
                          <td><@= l.fecha @></td>
                          <td><@= l.numero @></td>
                          <td><@= l.form @></td>
                          <td><@= l.cliente @></td>
                          <td><@= l.monto @></td>
                          <td><@= l.rentabilidad @></td>
                          <td><@= l.responsable @></td>
                          <td>
                            <a href="#/factura/editar/<@= l.id @>" class="btn btn-xs btn-primary">
                              <i class="glyphicon glyphicon-pencil"></i>
                            </a>
                            <a href="#/factura/info/<@= l.id @>" class="btn btn-xs btn-info">
                              <i class="glyphicon glyphicon-info-sign"></i>
                            </a>
                          </td>
                        </tr>

                      <@ }); @> 


                    <@ }); @> 

                  </tbody>
                </table>
                <div class="panel-data-table left">
                  <p class="panel-data-table-text">Mostrando 5 de 28 entradas</p>                      
                </div>
                <div class="panel-data-table right">
                  <ul class="pagination pagination-sm">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                  </ul>  
                </div>                  
              </div>
            </div>            
        </section>            
      </div>
    </script>

    <!-- Modal Bootstrap -->
    <script id="tmpl-modal" type="text/template">
      <div class="modal fade bs-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel"><@= title @></h4>
            </div>
            <div class="modal-body">
              <@= body @>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-primary btn-aceptar">Aceptar</button>
            </div>
          </div>
        </div>
      </div>
    </script>

    <script type="text/javascript" src="resources/libs/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="resources/libs/less/less-1.6.1.min.js"></script>
    <script type="text/javascript" src="resources/libs/backbone/underscore-min.js"></script>
    <script type="text/javascript" src="resources/libs/backbone/backbone-min.js"></script>
    <script type="text/javascript" src="resources/libs/bootstrap/js/bootstrap.js"></script>
    
    <!-- Project -->    
    <script type="text/javascript" src="resources/libs/project/utils.js"></script>
    <script type="text/javascript" src="resources/libs/project/config.js"></script>
    <script type="text/javascript" src="resources/libs/project/dashboard.js"></script>
    <script type="text/javascript" src="resources/libs/project/users.js"></script>
    <script type="text/javascript" src="resources/libs/project/invoice.js"></script>
    

  </body>
</html>