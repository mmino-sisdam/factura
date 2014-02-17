<!DOCTYPE html>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <title>Loyal Admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet/less" type="text/css" href="resources/css/styles.less" />
    <link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/libs/bootstrap/datepicker/css/datepicker3.css" />
   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
  
    <div class="page-containter">
      
      <div id="msg-alert"></div>
      
      <div class="sidebar-menu">

        <header>
          <div class="logo">
              <a href="#"><img src="resources/images/logo.jpg" alt="Loyal"/></a>
          </div>
        </header>

        <div class="search">
          <form>
            <fieldset>
                <input type="text" name="q" class="search-input" placeholder="Search something..."/>
                <button type="submit">
                  <i class="glyphicon glyphicon-search"></i>
                </button>
            </fieldset>
          </form>
        </div>

        <ul class="main-menu">
          <li><a href="#/" class="btn-menu btn-dashboard"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
          <li><a href="#/facturas" class="btn-menu btn-facturas"><i class="glyphicon glyphicon-list-alt"></i> Facturas</a></li>
          <li><a href="#/usuarios" class="btn-menu btn-usuarios"><i class="glyphicon glyphicon-user"></i> Usuarios</a></li>
        </ul>

      </div>

      <div class="main-content">
        
        <section class="row">
            <div class="col-md-6 col-sm-8 clearfix">Bienvenido Admin</div>
            <div class="col-md-6 col-sm-4 clearfix">
            	<a href=" <c:url value="j_spring_security_logout" /> " class="btn btn-link" title="Logout">Logout</a>
            </div>
        </section>

        <hr>

        <div id="layout"></div>  
        <div id="layout-modal"></div>  

      </div>

    </div>
    

    <!-- dashboard -->
    <jsp:include page="includes/dashboard/inc.dashboard.jsp"></jsp:include>

    <!-- listado de usuarios -->
    <jsp:include page="includes/usuarios/inc.lista.usuarios.jsp"></jsp:include> 

    <!-- nuevo usuario -->
    <jsp:include page="includes/usuarios/inc.nuevo.usuario.jsp"></jsp:include>

    <!-- listado de facturas -->
	<jsp:include page="includes/facturas/inc.listado.facturas.jsp"></jsp:include>
	<jsp:include page="includes/facturas/inc.info.factura.jsp"></jsp:include>
	
	<!-- facturas tipo A -->
	<jsp:include page="includes/facturas/inc.nueva.factura.tipo.a.jsp"></jsp:include>
	<jsp:include page="includes/facturas/inc.item.factura.add.jsp"></jsp:include>
	<jsp:include page="includes/facturas/inc.item.factura.confirm.jsp"></jsp:include>
	
    <!-- Modal Bootstrap -->
 	<jsp:include page="includes/extra/inc.modal.jsp"></jsp:include>

    <script type="text/javascript" src="resources/libs/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="resources/libs/less/less-1.6.1.min.js"></script>
    <script type="text/javascript" src="resources/libs/backbone/underscore-min.js"></script>
    <script type="text/javascript" src="resources/libs/backbone/backbone-min.js"></script>
    <script type="text/javascript" src="resources/libs/bootstrap/js/bootstrap.js"></script>
    
    <script type="text/javascript" src="resources/libs/bootstrap/datepicker/js/bootstrap-datepicker.js"></script>
    
    <!-- Project -->    
    <script type="text/javascript" src="resources/libs/project/utils.js"></script>
    <script type="text/javascript" src="resources/libs/project/config.js"></script>
    <script type="text/javascript" src="resources/libs/project/dashboard.js"></script>
    <script type="text/javascript" src="resources/libs/project/users.js"></script>
    <script type="text/javascript" src="resources/libs/project/invoice.js"></script>
    <script type="text/javascript" src="resources/libs/project/clients.js"></script>

  </body>
</html>