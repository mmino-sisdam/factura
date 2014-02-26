<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
	<script id="tmpl-fc-r-item" type="text/template">
		
		<@ 
		
			count = 1;

		_.each(rows, function(i) { @>
 		<tr>
			<td>
				<@= count++ @>
			</td>
			<td>
				<@= i.detalle @>
			</td>
			<td>
				<@= i.importeUnitario @>
			<td>
				<@= i.importeTotal @>
			</td>
		</tr> 
		<@ }); @>  
                    
	</script>