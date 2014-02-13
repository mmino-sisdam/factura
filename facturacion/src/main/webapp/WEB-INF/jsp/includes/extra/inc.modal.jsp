<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <script id="tmpl-modal" type="text/template">
      <div class="modal fade bs-modal-sm" id="<@= modal_id @>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel"><@= title @></h4>
            </div>
            <div class="modal-body">
              <@= body @>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-primary btn-aceptar">Aceptar</button>
            </div>
          </div>
        </div>
      </div>
    </script>