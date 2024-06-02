<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 29/5/24
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${mvc.locale}"/>
<fmt:setBundle var="textos" basename="textos"/>
<html>
<head>
    <title><fmt:message bundle="${textos}" key="desarrolladores"/></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
  <div class="container-fluid">
    <h1 class="mb-5 mt-5"> -<fmt:message bundle="${textos}" key="desarrolladores"/>- </h1>
    <c:set var="uriInsertDesarrollador" value="${mvc.uri('formInsertDesarrollador' , {'locale': mvc.locale})}"/>
    <div class="float-none">
      <a class = "btn btn-outline-success" href="${uriInsertDesarrollador}"><fmt:message bundle="${textos}" key="nuevoDesarrollador"/></a>
    </div>
    <table class="table table-striped table-hover caption-top">
      <thead>
        <tr>
          <th class="col-1"><fmt:message bundle="${textos}" key="identificador"/></th>
          <th class="col-2"><fmt:message bundle="${textos}" key="nombre"/></th>
          <th class="col-3"><fmt:message bundle="${textos}" key="logo"/></th>
          <th class="col-1"><fmt:message bundle="${textos}" key="fundacion"/></th>
          <th class="col-1"><fmt:message bundle="${textos}" key="sede"/></th>
          <th class="col-2"><fmt:message bundle="${textos}" key="operaciones"/></th>
        </tr>
      </thead>
      <tbody class="table-group-divider">
        <c:forEach var="desarrollador" items="${desarrolladores}">
          <c:set var="urlGetDesarrolladorById"      value="${mvc.uri('getDesarrolladorById',        {'idDesarrollador' : desarrollador.id() , 'locale': mvc.locale})}"/>
          <c:set var="uriUpdateDesarrolladorById"   value="${mvc.uri('formUpdateDesarrolladorById', {'idDesarrollador' : desarrollador.id() , 'locale': mvc.locale})}"/>
          <c:set var="uriDeleteDesarrollador"       value="${mvc.uri('formDeleteDesarrolladorById', {'idDesarrollador' : desarrollador.id() , 'locale': mvc.locale})}"/>
          <tr>
            <td class="col-1">${desarrollador.id()}</td>
            <td class="col-2"><a href="${urlGetDesarrolladorById}">${desarrollador.nombre()}</a></td>
            <td class="col-3"><img src="${desarrollador.logo()}" class="img-fluid"/></td>
            <td class="col-2">${desarrollador.fundacion()}</td>
            <td class="col-2">${desarrollador.sede()}</td>
            <td class="col-2 align-middle">
              <a class="btn btn btn-warning" href="${uriUpdateDesarrolladorById}"><fmt:message bundle="${textos}" key="actualizar"/></a>
              <br><br>
              <a class="btn btn-outline-danger" href="${uriDeleteDesarrollador}"> <fmt:message bundle="${textos}" key="eliminar"/> </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>

    </table>
  </div>
</body>
</html>
