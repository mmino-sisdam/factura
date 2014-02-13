<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<script id="tmpl-fc-r-item" type="text/template">
		
		<@ 
		_.each(rows, function(i) { @>
 		<tr>
			<td><@= i.id @></td>
			<td><@= i.descripcion @></td>
			<td><@= i.moneda @></td>
			<td><@= i.precio_unitario @></td>
			<td><@= i.total @></td>
			<td>
			  <button type="button" class="btn btn-xs btn-primary">
			    <i class="glyphicon glyphicon-edit"></i>
			  </button>
			  <button type="button" class="btn btn-xs btn-danger btn-delete-line" data="<@= i.id @>">
			    <i class="glyphicon glyphicon-remove"></i>
			  </button>
			</td>
		</tr> 
		<@ }); @>                      
	</script>