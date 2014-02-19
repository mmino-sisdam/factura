<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-1">Factura A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-2">Factura B</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-3">Factura E</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-4">Nota de cr&eacute;dito A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-5">Nota de cr&eacute;dito B</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-6">Nota de cr&eacute;dito E</a></li>
                      <li class="divider"></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-7">Nota de d&eacute;bito A</a></li>
                      <li role="presentation"><a role="menuitem" href="#/factura/nueva/tipo-8">Nota de d&eacute;bito B</a></li>
                    </ul>
                  </div>                   
                </div>

                <table class="table" cellpadding="0" cellspacing="0">
                  <thead>
                    <tr>
                      <th width="2%">&nbsp;</th>
                      <th width="12%">Fecha</th>
                      <th width="13%">N&uacute;mero</th>
                      <th width="10%">Form</th>
                      <th width="18%">Cliente</th>
                      <th width="10%">Monto</th>
                      <th width="10%">Rentabilidad</th>
                      <th width="15%">Responsable</th>
                      <th width="10%">Acciones</th>
                    </tr>
                  </thead>
                  <tbody>
					
					<@ count = 0 @>

                    <@ _.each(invoice, function(i) { @>

                      <tr class="active btn-month" data="<@= i.month @>-<@= i.year @>">
                        <td><span class="glyphicon glyphicon-chevron-down"></span></td>
                        <td><@= i.monthName @>-<@= i.year @></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><@= i.monto @></td>
                        <td><@= i.rentabilidad @></td>
                        <td>&nbsp;</td>
                        <td>
                          &nbsp;
                        </td>                      
                      </tr>

                      <@ _.each(i.list, function(l) { @>
						
						<@ count++ @>

                        <tr class="day month-id-<@= i.month @>-<@= i.year @>">
                          <td><input type="checkbox" /></td>
                          <td><@= l.fecha @></td>
                          <td><@= l.numero @></td>
                          <td><@= l.tipoFactura @></td>
                          <td><@= l.cliente @></td>
                          <td><@= l.importeTotal @></td>
                          <td><@= l.importeRentabilidad @></td>
                          <td><@= l.responsable @></td>
                          <td>
                            <buton type="button" title="Editar factura <@= l.numero @>" class="btn btn-xs btn-primary btn-edit">
                              <i class="glyphicon glyphicon-pencil"></i>
                            </buton>
                            <buton type="button" title="Ver info factura <@= l.numero @>" class="btn btn-xs btn-info" data="<@= l.idTipoFactura @>/<@= l.numero @>">
                              <i class="glyphicon glyphicon-info-sign"></i>
                            </button>
                          </td>
                        </tr>

                      <@ }); @> 


                    <@ }); @> 

                  </tbody>
                </table>
                <div class="panel-data-table left">
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