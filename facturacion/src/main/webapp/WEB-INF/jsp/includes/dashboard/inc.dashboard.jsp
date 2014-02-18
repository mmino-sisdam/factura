<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <script id="tmpl-dashboard" type="text/template">
      <div id="dashboard" class="main-panel">
        <section class="row margin-bottom">
          <div class="col-md-3 clearfix">

            <div class="boxed boxed-warning">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-exclamation-sign"></i> FACTURACI&Oacute;N PENDIENTE
              </div>
              <div class="boxed-body">
                <span class="boxed-title"><@= indicadores[0].resultado.pendiente[0].importeTotal @></span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title"><@= indicadores[0].desde @> - <@= indicadores[0].hasta @></span>
              </div>
            </div>

          </div>
          <div class="col-md-3 clearfix">

            <div class="boxed boxed-success">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-flag"></i> FACTURACI&Oacute;N COBRADA
              </div>
              <div class="boxed-body">
                <span class="boxed-title"><@= indicadores[0].resultado.cobrado[0].importeTotal @></span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title"><@= indicadores[0].desde @> - <@= indicadores[0].hasta @></span>
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
                  <i class="boxed-append"><@= indicadores[0].resultado.ventas[0].cantidad @> ventas</i>
                  <@= indicadores[0].resultado.ventas[0].importeTotal @>
                </span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title"><@= indicadores[0].desde @> - <@= indicadores[0].hasta @></span>
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

         <div class="col-md-6 clearfix" id="dashboard-vendedor"></div> 

         <div class="col-md-6 clearfix" id="dashboard-producto">
           
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
    
    
    <script id="tmpl-dashboard-vendedor" type="text/template">
      <div class="panel panel-default">
        <div class="panel-heading">
          Ventas por vendedor
          <span class="panel-right">
            <div class="dropdown">
              <a data-toggle="dropdown" href="#" id="datadrop_d01">
                <span class="glyphicon glyphicon-cog"></span>
              </a>
              <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="datadrop_d01">
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

              		<@ _.each(vendedor[0].vendedor.resultado, function(r){ @>
    					<tr>
               			<td><@= r.nombre @> <@= r.apellido @></td>
                			<td><@= r.cantidad @></td>
                			<td><@= r.importeSubtotal @></td>
    					</tr>
    				<@ }); @>

            </tbody>
          </table>
          <p class="panel-data-table">Mostrando 5 de 28 entradas</p>
        </div>
      </div>    
    </script>

    <script id="tmpl-dashboard-producto" type="text/template">
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

					<@ _.each(producto[0].producto.resultado, function(r){ @>
    					<tr>
               				<td>Periodo FF</td>
                			<td><@= r.nombre @></td>
							<td><span class="label label-primary">Loyal</span></td>
                			<td><@= r.importeTotal @></td>
    					</tr>
    				<@ }); @>

                  </tbody>
                </table>
                <p class="panel-data-table">Mostrando 5 de 28 entradas</p>
              </div>
            </div>   
    </script>    