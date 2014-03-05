<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

  <script id="tmpl-dashboard" type="text/template">
      <div id="dashboard" class="main-panel">

		<section class="row margin-bottom">
 		  <div class="col-md-12 clearfix">

			<div>
				<p>
					<button type="button" class="btn btn-sm btn-primary btn-change-data" >
						<span class="glyphicon glyphicon-calendar"></span>
					</button>
					<strong>Fecha desde:</strong> <@= indicadores[0].desde @> | 
					<strong>Fecha hasta:</strong> <@= indicadores[0].hasta @>
				</p>
			</div>
<!--
			<div class="form-inline">
  				<div class="form-group">
    				<label>Fecha desde</label>
    				<input type="text" class="form-control" placeholder="" />
  				</div>
  				<div class="form-group">
    				<label>Fecha hasta</label>
    				<input type="text" class="form-control" placeholder="" />
  				</div>	
				<button type="button" class="btn btn-sm btn-primary">Buscar</button>		
			</div>
	-->		
		  </div>			
		</section>

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

            <div class="boxed boxed-primary">
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

            <div class="boxed boxed-danger">
              <div class="boxed-heading">
                <i class="glyphicon glyphicon-chevron-down"></i> FACTURACI&Oacute;N VENCIDA
              </div>
              <div class="boxed-body">
                <span class="boxed-title">
                  <@= indicadores[0].resultado.pendiente[0].importeTotal @>
                </span>
              </div>
              <div class="boxed-footer">
                <span class="boxed-title"><@= indicadores[0].desde @> - <@= indicadores[0].hasta @></span>
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
              <div class="panel-body" id="dashboard-facturas">

                <!-- START TABLE FACTURAS -->
        				<div class="table-responsive">
                        <table class="table table-striped" cellpadding="0" cellspacing="0">
                          <thead>
                            <tr>
        					  <th>N&uacute;mero</th>
                              <th>Fecha emisi&oacute;n</th>
                              <th>Fecha vencimiento</th>
        					  <th>Status</th>
                              <th>Cliente</th>
                              <th>Forma de pago</th>
                              <th>Monto</th>
                              <th>Rentabilidad</th>
                              <th>Acciones</th>
                            </tr>
                          </thead>
                          <tbody>
        			<@ pages_facturas = invoice[0].vencimiento.resultado.length @>
                 	<@ _.each(invoice[0].vencimiento.resultado, function(r){ @>
                            <tr>
                              <td><@= r.numero @></td>
                              <td><@= r.fecha @></td>
                              <td><@= r.fechaVencimiento @></td>
                              <td><@= r.status @></td>
                              <td><@= r.cliente @></td>
                              <td><@= r.formaDePago @></td>
                              <td><@= r.importeTotal @></td>
                              <td><@= r.importeRentabilidad @></td>
                              <td>
                                <button type="button" class="btn btn-xs btn-info" data="<@= r.idTipoFactura @>/<@= r.numero @>">
                                  <i class="glyphicon glyphicon-info-sign"></i>
                                </button>
                              </td>
                            </tr>
          			 <@ }); @>
                          </tbody>
                        </table>
        				</div>
                <p class="panel-data-table">Mostrando <@= pages_facturas @> de <@= pages_facturas @> entradas</p>	

                <!-- END TABLE FACTURAS -->
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
                  <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="datadrop_d01">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Por ventas [Descendente]</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="1" href="#">Por monto [Descendente]</a></li>
                  </ul>
                </div>
              </span> 
            </div>
            <div class="panel-body" id="dashboard-vendedor">

              <!-- START TABLE VENDEDOR -->

        		  <div class="table-responsive">
                <table class="table table-striped" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Vendedor</th>
                      <th>Ventas</th>
                      <th>Monto</th>
          			<th>Rentabilidad</th>	
                    </tr>
                  </thead>
                  <tbody>
          			<@ pages_vendedor = vendedor[0].vendedor.resultado.length @>
                   	<@ _.each(vendedor[0].vendedor.resultado, function(r){ @>
              				<tr>
                       			<td><@= r.nombre @></td>
                        			<td><@= r.cantidad @></td>
                        			<td><@= r.importeTotal @></td>
                        			<td><@= r.importeRentabilidad @></td>
              				</tr>
            			 <@ }); @>
                  </tbody>
                </table>
              </div>
              <p class="panel-data-table">Mostrando <@= pages_vendedor @> de <@= pages_vendedor @> entradas</p>    

              <!-- END TABLE VENDEDOR -->

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

              <div class="panel-body" id="dashboard-producto">

                <!-- START TABLE VENDEDOR -->  

                <div class="table-responsive">
                    <table class="table table-striped" cellpadding="0" cellspacing="0">
                        <thead>
                          <tr>
                          <th>Periodo</th>
                          <th>Imputaci&oacute;n</th>
                          <th>Monto</th>
                          </tr>
                        </thead>
                        <tbody>
                		
                		<@ pages_producto = producto[0].producto.resultado.length @>

                        <@ _.each(producto[0].producto.resultado, function(r){ @>
                          <tr>
                            <td><@= producto[0].producto.desde @> - <@= producto[0].producto.hasta @></td>
                            <td>
                				<@= r.nombre @> <span class="label label-<@ ((r.descripcion == 'Loyal') ? print('primary') : print('warning') ) @>"><@= r.descripcion @></span>
                			</td>
                            <td><@= r.importeTotal @></td>
                          </tr>
                        <@ }); @>

                        </tbody>
                      </table>
                </div>
                <p class="panel-data-table">Mostrando <@= pages_producto @> de <@= pages_producto @> entradas</p>   
   
                <!-- END TABLE PRODUCTO -->

              </div>
            </div>           
        </div> 

        </section> 

      </div>
    </script>
 
  