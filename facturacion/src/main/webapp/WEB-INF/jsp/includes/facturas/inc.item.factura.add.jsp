<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<script id="tmpl-fc-a-item" type="text/template">
		<tr>
		    <td class="number"><@= row_number++ @></td>
		    <td><input class="form-control input-sm required" name="detalle" type="text" placeholder="Ingresar descripci&oacute;n"></td>
		    <td><input class="form-control input-sm required number" name="importe-unitario" type="text" placeholder="Ingresar precio unitario"></td>
		    <td><input class="form-control input-sm required number" name="importe-total" type="text" placeholder="Ingresar total"></td>
	  	</tr>	
	</script>