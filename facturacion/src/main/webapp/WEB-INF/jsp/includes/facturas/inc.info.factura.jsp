<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <script id="tmpl-fc-info-invoice" type="text/template">
		<div id="factura-info" class="main-panel">
		
		  <ol class="breadcrumb">
		    <li><a href="#/dashboard"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
		    <li><a href="#/facturas">Facturas</a></li>
		    <li class="active">Info</li>
		  </ol>
		
		  <section class="row">
		   <div class="col-md-12 clearfix">
		      <div class="panel panel-default">
		        <div class="panel-heading">
		          Informaci&oacute;n de factura n&uacute;mero <@= numero @>
		        </div>
		        <div class="panel-body">	

                	 <div class="btn-group out-print">
                     	<button type="button" class="btn btn-primary btn-print">
							<span class="glyphicon glyphicon-print"></span>
							Imprimir
						</button>                     
                	 </div>
				
		              <div class="row">
						<div class="col-md-12 clearfix out-print"><hr></div>
		                <!-- columna nro. 1 -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Cliente</label>
		                    <p><@= cliente @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Localizaci&oacute;n / Sucursal</label>
		                    <p>Dr. Ricardo Rojas 401 FF</p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Contacto</label>
		                    <p><@= contacto @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Situaci&oacute;n ante el IVA</label>
							<p>Responsable inscripto FF</p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">CUIT</label>
		                    <p>30-2545246-9 FF</p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Retenci&oacute;n</label>
							<p><@= idTipoRetencion @></p>
		                  </div>
		                </div>
		
		                <!-- columna nro. 2 -->
		                <div class="col-md-4 clearfix">
						  <div class="form-group">
		                    <label for="">N&uacute;mero</label>
		                    <p><@= numero @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha</label>
		                    <p><@= fecha @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha vencimiento</label>
		                    <p><@= fechaVencimiento @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha probable de cobro</label>
		                    <p><@= fechaProbableCobro @></p>
		                  </div>
		                  <div class="form-group">
		                    <label for="">Fecha cobro</label>
		                    <p><@= fechaCobro @></p>
		                  </div>
		                </div>
		
		                <!-- columna nro. 3 -->
		                <div class="col-md-4 clearfix">
		                   <div class="form-group">
		                     <label for="">Tipo de comprobante entregable</label>
		                     <p><@= tipoFactura @></p>
		                   </div>
		                   <div class="form-group">
		                      <label for="">Status</label>
		                      <p><@= status @></p>
		                    </div>  
		                    <div class="form-group">
		                      <label for="">Sub Total</label>
		                      <p><@= importeSubtotal @></p>
		                    </div> 
		                    <div class="form-group">
		                      <label for="">IVA</label>
		                      <p><@= importeIVA @></p>
		                    </div>  
		                    <div class="form-group">
		                      <label for="">Total</label>
		                      <p><@= importeTotal @></p>                                                    
		                    </div>                                                     
		                </div>
		
		                <div class="col-md-12 clearfix">
		                  <hr>
		                </div>
		
		                <!-- labels -->
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Status Cobro:</label> 
		                    <span class="label label-success label-xs label-status"><@= status @></span>
		                  </p>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Fecha Provista de Emision:</label> 
		                    <span class="label label-success label-xs label-emision"><@= fecha @></span>
		                  </p>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <p>
		                    <label>Fecha de Vencimiento:</label> 
		                    <span class="label label-success label-xs label-vencimiento"><@= fechaVencimiento @></span>
		                  </p>
		                </div>
		
		                <!-- comision -->
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">% Comisi&oacute;n</label>
							<p><@= idTipoComision @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Comisi&oacute;n</label>
		                  	<p><@= importeComision @></p> 
		                  </div>
		                </div>
		
		                <div class="col-md-12 clearfix"></div>
						
<!--
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Fecha comprobante entregable</label>
		                    <p><@= fechaComprobableEntregable @></p>
		                  </div>                          
		                </div>
-->
		
		                <div class="col-md-12 clearfix">
		                  <label>Responsble por Loyal</label>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Nombre</label>
		                    <p><@= responsable @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-12 clearfix"></div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Linea de producto</label>
		                    <p><@= idLineaProducto @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Costo</label>
		                    <p><@= importeCosto @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Rentabilidad</label>
		                    <p><@= importeRentabilidad @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Forma de pago</label>
		                    <p><@= formaDePago @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Remito</label>
		                    <p><@= remito @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-4 clearfix">
		                  <div class="form-group">
		                    <label for="">Orden de compra</label>
		                    <p><@= ordenDeCompra @></p>
		                  </div>
		                </div>
		
		                <div class="col-md-12 clearfix">
		                  <hr>
		                </div>                    
		                		
		                <div class="col-md-12 clearfix">
		                  <table class="table" cellpadding="0" cellspacing="0">
		                    <thead>
		                      <tr>
		                        <th width="3%">#</th>
		                        <th width="53%">Descripci&oacute;n</th>
		                        <th width="20%">Precio unitario</th>
		                        <th width="20%">Total</th>
		                      </tr>
		                    </thead>
		                    <tbody class="table-fc-body">
								
		                    	<@ _.each(detalles, function(d) {@>

								<tr>
									<td><@= d.cantidad @></td>
									<td><@= d.detalle @></td>
									<td><@= d.importeUnitario @></td>
									<td><@= d.importeTotal @></td>
									<td>&nbsp;</td>
								</tr>									                   

								<@ }); @>
		
		                    </tbody>
		                  	</table>
							<!-- resultado -->
							<table class="table" cellpadding="0" cellspacing="0">
								<tbody>
		                      		<tr>
		                      			<td colspan="3" width="56%">&nbsp;</td>
		                        		<td width="21%"><strong>Sub total</strong></td>
		                        		<td class="label-sub-total"><@= importeSubtotal @></td>
		                        		<td>&nbsp;</td>
		                     		 </tr>
		                      		<tr>
		                        		<td colspan="3">&nbsp;</td>
		                        		<td><strong>IVA</strong></td>
		                        		<td class="label-iva"><@= importeIVA @></td>
		                        		<td>&nbsp;</td>
		                      		</tr>
		                      		<tr>
		                       			<td colspan="3">&nbsp;</td>
		                        		<td><strong>Total</strong></td>
		                        		<td class="label-total"><@= importeTotal @></td>
		                        		<td>&nbsp;</td>
		                      		</tr>
								</tbody>
							</table>
		                </div>

                      <div class="col-md-12 clearfix out-print">
                        <hr>
                      </div>
                      <div class="col-md-12 clearfix out-print">
                        <button type="button" class="btn btn-right btn-primary btn-accept">Aceptar</button>
                        <button type="button" class="btn btn-right btn-primary btn-edit" data="<@= idTipoFactura @>/<@= numero @>">Editar</button>
                      </div>
		              </div>

		        </div>
		      </div>            
		  </section>              
		</div>
	</script>