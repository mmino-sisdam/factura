<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<script id="tmpl-fc-a-item" type="text/template">
		<tr>
		    <td class="number"><@= row_number++ @></td>
		    <td><input class="form-control input-sm" name="descripcion" type="text" placeholder="Ingresar descripci&oacute;n"></td>
		    <td>
		      <select class="form-control input-sm" name="moneda">
		        <option>$</option>
		        <option>u$s</option>
		      </select>
		    </td>
		    <td><input class="form-control input-sm" name="precio-unitario" type="text" placeholder="Ingresar precio unitario"></td>
		    <td><input class="form-control input-sm" name="total" type="text" placeholder="Ingresar total"></td>
		    <td>
		      	<button type="button" class="btn btn-xs btn-success btn-add-line">
		       		<i class="glyphicon glyphicon-ok"></i>
		      	</button>
				<button type="button" class="btn btn-xs btn-danger btn-delete-line">
		      		<i class="glyphicon glyphicon-remove"></i>
		      	</button>
		    </td>
	  	</tr>	
	</script>