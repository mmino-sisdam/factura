<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		          Creaci&oacute;n de factura tipo A
		        </div>
		        <div class="panel-body">
		          <form role="form" id="form-invoice">
		            <fieldset>
						
						<input type="hidden" name="idTipoFactura" value="1"/>
		              <div class="row">
		
		                <!-- columna nro. 1 -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="idCliente">Cliente</label>
		                    <input name="idCliente" type="text" class="form-control form-type-client" placeholder="Buscar cliente...">
		                  </div>
		                  <div class="form-group">
		                    <label>Localizaci&oacute;n / Sucursal</label>
		                    <input type="text" class="form-control" placeholder="Ingresar sucursal"/>
		                  </div>
		                  <div class="form-group">
		                    <label for="contacto">Contacto</label>
		                    <input name="contacto" type="text" class="form-control" placeholder="Ingresar contacto"/>
		                  </div>
		                  <div class="form-group">
		                    <label for="idTipoIVA">Situaci&oacute;n ante el IVA</label>
		                    <select name="idTipoIVA" class="form-control">
		                      <option value="1">Responsable inscripto</option>
		                      <option value="2">No inscripto</option>
		                      <option value="3">Excento</option>
		                      <option value="4">Consumidor final</option>
		                    </select>
		                  </div>
		                  <div class="form-group">
		                    <label for="">CUIT</label>
		                    <input type="text" class="form-control" placeholder="Ingresar CUIT"/>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Retenci&oacute;n</label>
		                    <select class="form-control">
		                      <@ _.each(tipo_retencion, function(r){ @>

		                      		<option value="<@= r.id @>"><@= r.nombre @></option>

							  	<@ }); @>
		                    </select>
		                  </div>
		                </div>
		
		                <!-- columna nro. 2 -->
		                <div class="col-md-4 clearfix">
						  <div class="form-group">
		                    <label for="">N&uacute;mero factura</label>
		                    <input name="numero" type="text" class="form-control" />
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha</label>
		                    <div class="input-group">
		                      <input name="fecha" type="text" class="form-control form-datepicker input-fecha-emision" />
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha vencimiento</label>
		                    <div class="input-group">
		                      <input name="fechaVencimiento" type="text" class="form-control form-datepicker input-fecha-vencimiento" name="fecha_vencimiento"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha probable de cobro</label>
		                    <div class="input-group">
		                      <input name="fechaProbableCobro" type="text" class="form-control form-datepicker">
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha cobro</label>
		                    <div class="input-group">
		                      <input name="fechaCobro" type="text" class="form-control form-datepicker">
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>
		                </div>
		
		                <!-- columna nro. 3 -->
		                <div class="col-md-4 clearfix">
		                   <div class="form-group">
		                      <label for="status">Status</label>
		                      <select name ="idStatus" class="form-control select-status">

		                        <@ _.each(status, function(s){ @>

		                      		<option value="<@= s.id @>"><@= s.nombre @></option>

							  	<@ }); @>

		                      </select>
		                    </div>  
		                    <div class="form-group">
		                      <label for="importeSubtotal">Sub Total</label>
		                      <input name="importeSubtotal" type="text" class="form-control" placeholder="Ingresar sub total">
		                    </div> 
		                    <div class="form-group">
		                      <label for="importeIVA">IVA</label>
		                      <input name="importeIVA" type="text" class="form-control" placeholder="Ingresar IVA">
		                    </div>  
		                    <div class="form-group">
		                        <label for="importeTotal">Total</label>
		                        <div class="input-group">
		                          <input name="importeTotal" type="text" class="form-control"/>
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
		                    <span class="label label-success label-xs label-emision">-</span>
		                  </p>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Fecha de Vencimiento:</label> 
		                    <span class="label label-success label-xs label-vencimiento">-</span>
		                  </p>
		                </div>
		
		                <!-- comision -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">% Comisi&oacute;n FF</label>
		                    <select class="form-control">
		                      <option>0</option>
		                      <option>1.0</option>
		                      <option>2.0</option>
		                      <option>3.0</option>
		                      <option>4.0</option>
		                      <option>5.0</option>
		                      <option>6.0</option>
		                      <option>7.0</option>
		                      <option>8.0</option>
		                      <option>9.0</option>
		                      <option>10.0</option>
		                      <option>3.5</option>
		                    </select>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Comisi&oacute;n</label>
		                    <input name="importeComision" type="text" class="form-control" placeholder="Ingesar comisi&oacute;n"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="cobrado">Cobrado FF</label>
		                    <select name="cobrado" class="form-control">
		                      <option>No</option>
		                      <option>Si</option>
		                    </select>
		                  </div>
		                </div>
						
<!--
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Fecha comprobante entregable</label>
		                    <div class="input-group">
		                      <input name="fechaComprobableEntregable" type="text" class="form-control form-datepicker"/>
		                      <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                      </span>
		                    </div>
		                  </div>                          
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="tipoFactura">Tipo de comprobante entregable</label>
		                    <select name="tipoFactura" class="form-control">
		                      <option value="1">Factura A</option>
		                      <option>Factura A</option>
		                    </select>
		                  </div>
		                </div>
-->	
		                <div class="col-md-12 clearfix">
		                  <label>Responsble por Loyal</label>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="idUsuario">Nombre</label>
		                    <input name="idUsuario" type="text" class="form-control" placeholder="Buscar nombre..."/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix"></div>
		
		                <div class="col-md-12 clearfix"></div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Linea de producto</label>
		                    <select class="form-control">
							  <@ _.each(linea_producto, function(l){ @>

		                      	<option value="<@= l.id @>"><@= l.nombre @></option>

							  <@ }); @>
		                    </select>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="importeCosto">Costo</label>
		                    <input name="importeCosto" type="text" class="form-control" placeholder="Ingresar costo"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="importeRentabilidad">Rentabilidad</label>
		                    <input name="importeRentabilidad" type="text" class="form-control" placeholder="Ingresar rentabilidad"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="formaDePago">Forma de pago</label>
		                    <input name="formaDePago" type="text" class="form-control" placeholder="Ingresar forma de pago"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="remito">Remito</label>
		                    <input name="remito" type="text" class="form-control" placeholder="Ingresar remito"/>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="ordenDeCompra">Orden de compra</label>
		                    <input name="ordenDeCompra" type="text" class="form-control" placeholder="Ingresar orden de compra">
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
		                  </div>                           
		                
		
		                <div class="col-md-12 clearfix">
		                  <table class="table" cellpadding="0" cellspacing="0">
		                    <thead>
		                      <tr>
		                        <th width="3%">#</th>
		                        <th width="33%">Descripci&oacute;n</th>
		                        <th width="10%">Moneda</th>
		                        <th width="20%">Precio unitario</th>
		                        <th width="20%">Total</th>
		                        <th width="10%">Acciones</th>
		                      </tr>
		                    </thead>
		                    <tbody class="table-fc-body">

								<@ row_number = 1 @>	                   
		
		                    </tbody>
		                  	</table>
							
							<!-- resultado -->
							<table class="table" cellpadding="0" cellspacing="0">
								<tbody>
		                      		<tr>
		                      			<td colspan="3" width="48%">&nbsp;</td>
		                        		<td width="21%"><strong>Sub total</strong></td>
		                        		<td class="label-sub-total">00.000</td>
		                        		<td>&nbsp;</td>
		                     		 </tr>
		                      		<tr>
		                        		<td colspan="3">&nbsp;</td>
		                        		<td><strong>IVA [21%]</strong></td>
		                        		<td class="label-iva">00.000</td>
		                        		<td>&nbsp;</td>
		                      		</tr>
		                      		<tr>
		                       			<td colspan="3">&nbsp;</td>
		                        		<td><strong>Total</strong></td>
		                        		<td class="label-total">00.000</td>
		                        		<td>&nbsp;</td>
		                      		</tr>
								</tbody>
							</table>
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