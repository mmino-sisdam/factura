<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <script id="tmpl-list-invoice" type="text/template">
      <div class="main-panel">
        <ol class="breadcrumb">
          <li><a href="#/dashboard"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
          <li class="active">Facturas</li>
        </ol>
        <section class="row">
         <div class="col-md-12 clearfix">
            <div class="panel panel-default">
              <div class="panel-heading">
                Facturaci&oacute;n
              </div>
              <div class="panel-body">

                <div class="btn-group out-print">
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary btn-print">
					  <span class="glyphicon glyphicon-print"></span>
                      Imprimir
                    </button>
                  </div>  
                  <div class="btn-group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      <span class="glyphicon glyphicon-file"></span>
                      Nueva factura
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-1">Factura A <span class="badge pull-right">1</span></a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-2">Factura B <span class="badge pull-right">2</span></a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-3">Factura E <span class="badge pull-right">3</span></a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-4">Nota de cr&eacute;dito A <span class="badge pull-right">4</span></a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-5">Nota de cr&eacute;dito B <span class="badge pull-right">5</span></a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-6">Nota de cr&eacute;dito E <span class="badge pull-right">6</span></a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-7">Nota de d&eacute;bito A <span class="badge pull-right">7</span></a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-8">Nota de d&eacute;bito B <span class="badge pull-right">8</span></a></li>
                    </ul>
                  </div>                   
                </div>
				
				<div class="row">
					<div class="col-md-12 clearfix"><hr></div>
				</div>
				<div class="table-responsive">
                <table class="table" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th width="2%" class="out-print">&nbsp;</th>
                      <th width="10%">Fecha</th>
                      <th width="13%">N&uacute;mero</th>
                      <th width="10%">Form</th>
                      <th width="18%">Cliente</th>
                      <th width="10%">Monto</th>
                      <th width="10%">Rentabilidad</th>
                      <th width="15%">Responsable</th>
                      <th width="12%" class="out-print">Acciones</th>
                    </tr>
                  </thead>
                  <tbody>
					
					<@ count = 0 @>

                    <@ _.each(invoice, function(i) { @>

                      <tr class="active btn-month" data="<@= i.month @>-<@= i.year @>">
                        <td class="out-print"><span class="glyphicon glyphicon-chevron-down"></span></td>
                        <td><@= i.monthName @>-<@= i.year @></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><@= i.monto @></td>
                        <td><@= i.rentabilidad @></td>
                        <td>&nbsp;</td>
                        <td class="out-print">
                          &nbsp;
                        </td>                      
                      </tr>

                      <@ _.each(i.list, function(l) { @>
						
						<@ count++ @>

                        <tr class="day month-id-<@= i.month @>-<@= i.year @>" id="invoice-<@= l.idTipoFactura @>-<@= l.numero @>">
                          <td class="out-print"><input type="checkbox" /></td>
                          <td><@= l.fecha @></td>
                          <td><@= l.numero @></td>
                          <td><@= l.tipoFactura @></td>
                          <td><@= l.cliente @></td>
                          <td><@= l.importeTotal @></td>
                          <td><@= l.importeRentabilidad @></td>
                          <td><@= l.responsable @></td>
                          <td class="out-print">
                            <button type="button" title="Editar factura <@= l.numero @>" class="btn btn-xs btn-primary btn-edit" data="<@= l.idTipoFactura @>/<@= l.numero @>">
                              <i class="glyphicon glyphicon-pencil"></i>
                            </button>
                            <button type="button" title="Ver info factura <@= l.numero @>" class="btn btn-xs btn-info" data="<@= l.idTipoFactura @>/<@= l.numero @>">
                              <i class="glyphicon glyphicon-info-sign"></i>
                            </button>
							<button type="button" title="Eliminar factura <@= l.numero @>" class="btn btn-xs btn-danger btn-delete" data-toggle="modal" data-target="#modal" data="<@= l.idTipoFactura @>-<@= l.numero @>">
                              <i class="glyphicon glyphicon-remove"></i>
                            </button>
                          </td>
                        </tr>

                      <@ }); @> 


                    <@ }); @> 

                  </tbody>
                </table>
				</div>
                <div class="panel-data-table left out-print">
                  <p class="panel-data-table-text">Mostrando <@= count @> de <@= count @>  entradas</p>                    
                </div>
				<!--
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
				-->                 
              </div>
            </div>            
        </section>            
      </div>
    </script>