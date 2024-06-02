<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 28/5/24
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${mvc.locale}"/>
<fmt:setBundle var="textos" basename="textos"/>
<html>
<head>
    <title><fmt:message bundle="${textos}" key="videojuegos"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class = "container-fluid">
        <h1 class="mb-5 mt-5"> -<fmt:message bundle="${textos}" key="videojuegos"/>- </h1>
        <c:set var="uriInsertVideojuego"    value="${mvc.uri('formInsertVideojuego', {'locale': mvc.locale})}"/>
        <div class="float-none">
            <a class = "btn btn-outline-success" href="${uriInsertVideojuego}"><fmt:message bundle="${textos}" key="nuevoVideojuego"/></a>
        </div>
        <table class="table table-striped table-hover caption-top">
            <thead>
                <tr>
                    <th class="col-1"><fmt:message bundle="${textos}" key="identificador"/></th>
                    <th class="col-3"><fmt:message bundle="${textos}" key="nombre"/></th>
                    <th class="col-2"><fmt:message bundle="${textos}" key="estreno"/></th>
                    <th class="col-2"><fmt:message bundle="${textos}" key="portada"/></th>
                    <th class="col-2"><fmt:message bundle="${textos}" key="operaciones"/></th>
                </tr>
            </thead>
            <tbody class="table-group-divider">
                <c:forEach var="videojuego" items="${videojuegos}">
                    <c:set var="urlGetVideojuegoById"   value="${mvc.uri('getVideojuegoById',           {'idVideojuego' : videojuego.id() , 'locale': mvc.locale})}"/>
                    <c:set var="uriUpdateVideojuego"    value="${mvc.uri('formUpdateVideojuegoById',    {'idVideojuego' : videojuego.id() , 'locale': mvc.locale})}"/>
                    <c:set var="uriDeleteVideojuego"    value="${mvc.uri('formDeleteVideojuegoById',    {'idVideojuego' : videojuego.id() , 'locale': mvc.locale})}"/>
                    <tr>
                        <td class="col-1"><h1>${videojuego.id()}</h1></td>
                        <td class="col-3 align-middle"><h2><a href="${urlGetVideojuegoById}">${videojuego.nombre()}</a></h2></td>
                        <td class="col-2"><h3>${videojuego.estreno()}</h3></td>
                        <td class="col-2"><img src="${videojuego.portada()}" class="img-fluid"/></td>
                        <td class="col-2 align-middle">
                            <a class="btn btn btn-warning" href="${uriUpdateVideojuego}"><fmt:message bundle="${textos}" key="actualizar"/></a>
                            <br><br>
                            <a class="btn btn-outline-danger" href="${uriDeleteVideojuego}"> <fmt:message bundle="${textos}" key="eliminar"/> </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
