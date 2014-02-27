<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

 <script id="tmpl-fc-a-invoice" type="text/template">
		<div id="factura-nueva" class="main-panel">
		
		  <ol class="breadcrumb">
		    <li><a href="#"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
		    <li><a href="#facturas">Facturas</a></li>
		    <li class="active">Nueva</li>
		  </ol>
		
		  <section class="row">
		   <div class="col-md-12 clearfix">
		      <div class="panel panel-default">
		        <div class="panel-heading">
		          Creaci&oacute;n de factura
		        </div>
		        <div class="panel-body">
		          <form role="form" id="form-invoice">
		            <fieldset>

					  <@ if(factura.numero){ print('<input type="hidden" name="id" value="'+ idTipoFactura + '-'+ factura.numero  +'"/>') } @>

					  <input type="hidden" name="idTipoFactura" value="<@= idTipoFactura @>"/>

		              <div class="row">
		
		                <!-- columna nro. 1 -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="idCliente">Cliente</label>
							<select name="idCliente" class="form-control select-client required">
								<option value="-1">Seleccionar Cliente...</option>
								<@ _.each(datos.clientes, function(cliente){ @>

		                      		<option <@ if(factura.idCliente == cliente.id) { print('selected'); } @>
											data-iva="<@= cliente.idTipoIVA @>" 
											data-retencion="<@= cliente.idTipoRetencion @>" 
											data-cuit="<@= cliente.cuit @>" 
											data-direccion="<@= cliente.direccion @>" 
											value="<@= cliente.id @>"> <@= cliente.nombre @>
									</option>

							  	<@ }); @>
							</select>
		                  </div>
		                  <div class="form-group">
		                    <label>Localizaci&oacute;n / Sucursal</label>
		                    <input type="text" class="form-control cliente-sucursal" placeholder="Ingresar sucursal"/>
		                  </div>
		                  <div class="form-group">
		                    <label for="contacto">Contacto</label>
		                    <input name="contacto" type="text" class="form-control cliente-contacto" placeholder="Ingresar contacto"/>
		                  </div>
		                  <div class="form-group">
		                    <label for="idTipoIVA">Situaci&oacute;n ante el IVA</label>
		                    <select name="idTipoIVA" class="form-control cliente-iva">
		                      <@ _.each(datos.tipo_iva, function(i){ @>

		                      		<option <@ if(factura.idTipoIVA == i.id) { print('selected'); } @> value="<@= i.id @>"><@= i.nombre @></option>

							  <@ }); @>
		                    </select>
		                  </div>

		                  <div class="form-group">
		                    <label for="">CUIT</label>
		                    <input type="text" class="form-control cliente-cuit" placeholder="Ingresar CUIT" value"<@= factura.cuit @>" />
		                  </div>

		                  <div class="form-group">
		                    <label for="">Retenci&oacute;n</label>
		                    <select name="idTipoRetencion" class="form-control cliente-retencion">
		                      <@ _.each(datos.tipo_retencion, function(r){ @>

		                      	<option <@ if(factura.idTipoRetencion == r.id) { print('selected'); } @> value="<@= r.id @>"><@= r.nombre @></option>

							  <@ }); @>
		                    </select>
		                  </div>

		                </div>
		
		                <!-- columna nro. 2 -->
		                <div class="col-md-4 clearfix">

						  <div class="form-group">
		                    <label for="">N&uacute;mero factura</label>
		                    <input name="numero" type="text" class="form-control required" value="<@= factura.numero @>"/>
		                  </div>

		                  <div class="form-group">
		                    <label for="">Fecha</label>
		                    <div class="input-group">
		                      <input name="fecha" type="text" class="form-control form-datepicker input-fecha-emision required"  value="<@= factura.fecha @>"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>

		                  <div class="form-group">
		                    <label for="">Fecha vencimiento</label>
		                    <div class="input-group">
		                      <input name="fechaVencimiento" type="text" class="form-control form-datepicker input-fecha-vencimiento required"  value="<@= factura.fechaVencimiento @>"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>

		                  <div class="form-group">
		                    <label for="">Fecha probable de cobro</label>
		                    <div class="input-group">
		                      <input name="fechaProbableCobro" type="text" class="form-control form-datepicker required"  value="<@= factura.fechaProbableCobro @>"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>

		                  <div class="form-group">
		                    <label for="">Fecha cobro</label>
		                    <div class="input-group">
		                      <input name="fechaCobro" type="text" class="form-control form-datepicker required"  value="<@= factura.fechaCobro @>"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>

		                </div>
		
		                <!-- columna nro. 3 -->
		                <div class="col-md-4 clearfix"> 
 
		                   <div class="form-group form-iva">
		                      <label for="importeTotal">Valor IVA actual</label>
		                      <div class="input-group">
		                        <input type="text" class="form-control iva-value" value="21"/>
		                        <span class="input-group-addon">%</span>
		                      </div>                                                     
		                   </div> 

		                   <div class="form-group">
		                      <label for="status">Status</label>
		                      <select name ="idStatus" class="form-control select-status">

		                        <@ _.each(datos.status, function(s){ @>

		                      		<option <@ if(factura.idStatus == s.id) { print('selected'); } @> value="<@= s.id @>"><@= s.nombre @></option>

							  	<@ }); @>

		                      </select>
		                    </div>  

		                    <div class="form-group form-iva">
		                      <label for="importeSubtotal">Sub Total</label>
		                      <input name="importeSubtotal" type="text" class="form-control" placeholder="Ingresar sub total required" value="<@= factura.importeSubtotal @>" />
		                    </div> 

		                    <div class="form-group form-iva">
		                      <label for="importeIVA">IVA</label>
		                      <input name="importeIVA" type="text" class="form-control required" placeholder="Ingresar IVA" value="<@= factura.importeIVA @>" />
		                    </div> 
 
		                    <div class="form-group">
		                        <label for="importeTotal">Total</label>
		                        <div class="input-group">
		                          <input name="importeTotal" type="text" class="form-control required" value="<@= factura.importeTotal @>"/>
		                          <span class="input-group-addon">
		                            %
		                          </span>
		                        </div>                                                     
		                    </div> 
                                                    
		                </div>
		
		                <div class="col-md-12 clearfix">
		                  <hr>
		                </div>
		
		                <!-- labels -->
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Status Cobro:</label> 
		                    <span class="label label-success label-xs label-status">A cobrar</span>
		                  </p>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Fecha Provista de Emision:</label> 
		                    <span class="label label-success label-xs label-emision"><@= factura.fecha @></span>
		                  </p>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Fecha de Vencimiento:</label> 
		                    <span class="label label-success label-xs label-vencimiento"><@= factura.fechaVencimiento @></span>
		                  </p>
		                </div>
		
		                <!-- comision -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">% Comisi&oacute;n</label>
		                    <select name="idTipoComision" class="form-control">

		                      <@ _.each(datos.tipo_comision, function(c){ @>

		                      	<option <@ if(factura.idTipoComision == c.id) { print('selected'); } @> value="<@= c.id @>"><@= c.nombre @></option>

							  <@ }); @>

		                    </select>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Comisi&oacute;n</label>
		                    <input name="importeComision" type="text" class="form-control" placeholder="Ingesar comisi&oacute;n" value="<@= factura.importeComision @>"/>
		                  </div>
		                </div>

		                <div class="col-md-12 clearfix">
		                  <label>Responsble por Loyal</label>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="idResponsable">Nombre</label>
							<select name="idResponsable" class="form-control">
								<@ _.each(datos.responsables, function(responsable){ @>

		                      		<option <@ if(factura.idResponsable == responsable.id) { print('selected'); } @> value="<@= responsable.id @>"><@= responsable.nombre + ' ' + responsable.apellido @></option>

							  	<@ }); @>
							</select>
		                  </div>
		                </div>
				
		                <div class="col-md-12 clearfix"></div>
		
		                <div class="col-md-4 clearfix">
		                  <div name="idLineaProducto" class="form-group">
		                    <label for="">Linea de producto</label>
		                    <select name="idLineaProducto" class="form-control">
							  <@ _.each(datos.linea_producto, function(l){ @>

		                      	<option <@ if(factura.idLineaProducto == l.id) { print('selected'); } @> value="<@= l.id @>"><@= l.nombre @></option>

							  <@ }); @>
		                    </select>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="importeCosto">Costo</label>
		                    <input name="importeCosto" type="text" class="form-control" placeholder="Ingresar costo" value="<@= factura.importeCosto @>"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="importeRentabilidad">Rentabilidad</label>
		                    <input name="importeRentabilidad" type="text" class="form-control" placeholder="Ingresar rentabilidad" value="<@= factura.importeRentabilidad @>"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="formaDePago">Forma de pago</label>
		                    <input name="formaDePago" type="text" class="form-control" placeholder="Ingresar forma de pago" value="<@= factura.formaDePago @>"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="remito">Remito</label>
		                    <input name="remito" type="text" class="form-control" placeholder="Ingresar remito" value="<@= factura.remito @>"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="ordenDeCompra">Orden de compra</label>
		                    <input name="ordenDeCompra" type="text" class="form-control" placeholder="Ingresar orden de compra" value="<@= factura.ordenDeCompra @>" />
		                  </div>
		                </div>
		
		                <div class="col-md-12 clearfix">
		                  <hr>
		                </div>
		
		                <div class="col-md-12 clearfix">
							<button type="button" class="btn btn-primary btn-table-insert" data="append">
		                    	<span class="glyphicon glyphicon-th-list"></span>
		                       	Insertar fila
		                    </button> 
		                    <button type="button" class="btn btn-primary btn-table-reset">
		                       <span class="glyphicon glyphicon-remove-sign"></span>
		                       Reiniciar tabla
		                    </button> 
		                    <button type="button" class="btn btn-primary btn-table-confirm">
		                       <span class="glyphicon glyphicon-plus"></span>
		                       Calcular valores
		                    </button>                   
		                </div>                           
		                
		
		                <div class="col-md-12 clearfix">
		                  <table class="table" cellpadding="0" cellspacing="0">
		                    <thead>
		                      <tr>
		                        <th width="3%">#</th>
		                        <th width="53%">Detalle (*)</th>
		                        <th width="20%">Precio unitario (*)</th>
		                        <th width="20%">Total (*)</th>
		                      </tr>
		                    </thead>
		                    <tbody class="table-fc-body">

								<@ row_number = (factura.detalles.length + 1) @>	

		                    	<@ _.each(factura.detalles, function(d) {@>
								
									<tr>
										<td><@= d.cantidad @></td>
										<td><input class="form-control input-sm required" name="detalle" type="text" placeholder="Ingresar descripci&oacute;n" value="<@= d.detalle @>"/></td>
										<td><input class="form-control input-sm required number" name="importe-unitario" type="text" placeholder="Ingresar precio unitario" value="<@= d.importeUnitario @>"/></td>
										<td><input class="form-control input-sm required number" name="importe-total" type="text" placeholder="Ingresar total" value="<@= d.importeTotal @>"/></td>
									</tr>									                   

								<@ }); @>                   
		
		                    </tbody>
		                  	</table>
							
							<!-- resultado -->
							<table class="table" cellpadding="0" cellspacing="0">
								<tbody>
		                      		<tr class="form-iva">
		                      			<td colspan="3" width="58%">&nbsp;</td>
		                        		<td width="21%"><strong>Sub total</strong></td>
		                        		<td class="label-sub-total"><@= factura.importeSubtotal @></td>
		                        		<td>&nbsp;</td>
		                     		 </tr>
		                      		<tr class="form-iva">
		                        		<td colspan="3">&nbsp;</td>
		                        		<td><strong>IVA</strong></td>
		                        		<td class="label-iva"><@= factura.importeIVA @></td>
		                        		<td>&nbsp;</td>
		                      		</tr>
		                      		<tr>
		                       			<td colspan="3" width="58%">&nbsp;</td>
		                        		<td width="21%"><strong>Total</strong></td>
		                        		<td class="label-total"><@= factura.importeTotal @></td>
		                        		<td>&nbsp;</td>
		                      		</tr>
								</tbody>
							</table>
		                </div>

                      	<div class="col-md-12 clearfix"><hr> </div>

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