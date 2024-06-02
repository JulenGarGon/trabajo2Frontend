<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 29/5/24
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${mvc.locale}"/>
<fmt:setBundle var="textos" basename="textos"/>

<fmt:message bundle="${textos}" key="aniade" var="add"/>
<fmt:message bundle="${textos}" key="actualiza" var="update"/>
<fmt:message bundle="${textos}" key="borra" var="delete"/>

<!-- similar a un switch -->
<c:choose>
  <c:when test="${action eq 'SELECT'}">
    <c:set var="readonly" value="readonly"/>
    <c:set var="disabled" value="disabled"/>
  </c:when>
  <c:when test="${action eq 'INSERT'}">
    <c:set var="readonly" value=""/>
    <c:set var="disabled" value=""/>
    <c:set var="labelSubmit" value="${add}"/>
    <c:set var="uriForm" value="${mvc.uri('insertVideojuego' , {'locale': mvc.locale})}"/>
    <c:set var="methodForm" value="POST"/>
  </c:when>
  <c:when test="${action eq 'UPDATE'}">
    <c:set var="readonly" value=""/>
    <c:set var="disabled" value=""/>
    <c:set var="labelSubmit" value="${update}"/>
    <c:set var="uriForm" value="${mvc.uri('updateVideojuegoById', {'idVideojuego' : videojuego.id() , 'locale': mvc.locale})}"/>
    <c:set var="methodForm" value="PUT"/>
  </c:when>
  <c:otherwise>
    <!-- DELETE -->
    <c:set var="readonly" value="readonly"/>
    <c:set var="disabled" value="disabled"/>
    <c:set var="labelSubmit" value="${delete}"/>
    <c:set var="uriForm" value="${mvc.uri('deleteVideojuegoById', {'idVideojuego' : videojuego.id() , 'locale': mvc.locale})}"/>
    <c:set var="methodForm" value="DELETE"/>
  </c:otherwise>
</c:choose>

<fmt:setLocale value="${mvc.locale}"/>
<fmt:setBundle var="textos" basename="textos"/>

<html>
<head>
    <title>${videojuego.nombre()}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <h1>${videojuego.id()} - ${videojuego.nombre()}</h1>

      <div class="row">
          <div class="col-3">
            <img src="${videojuego.portada()}" class="img-fluid"/>
          </div>

        <div class="col-7">
          <form method="POST" action="${uriForm}" enctype="application/x-www-form-urlencoded">
            <input name="id" type="hidden" value="${videojuego.id()}">
            <input type="hidden" name="_method" value="${methodForm}"/>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.nombre" var="plnombre"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="nombre"/>: </label>
              <input class="form-control" id="nombre" name="nombre" type="text" minlength="1" maxlength="50" value="${videojuego.nombre()}" placeholder="${plnombre}" aria-errormessage="errorNombre" ${readonly}/>
              <div class="form-text" id="errorNombre"> ${errores.nombre} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.genero" var="plgenero"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="genero"/>: </label>
              <input class="form-control" id="genero" name="genero" type="text" minlength="1" maxlength="100" value="${videojuego.genero()}" placeholder="${plgenero}" aria-errormessage="errorGenero" ${readonly}/>
              <div class="form-text" id="errorGenero"> ${errores.genero} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.duracion" var="plduracion"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="duracion"/> : </label>
              <input class="form-control" id="duracion" name="duracion" type="number" minlength="1" maxlength="100" step="0.01" value="${videojuego.duracion()}" placeholder="${plduracion}" aria-errormessage="errorDuracion" ${readonly}>
              <div class="form-text" id="errorDuracion"> ${errores.duracion} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.tamanio" var="pltamanio"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="peso"/> : </label>
              <input class="form-control" id="tamanio" name="tamanio" type="number" minlength="1" maxlength="100" step="0.01" value="${videojuego.tamanio()}" placeholder="${pltamanio}" aria-errormessage="errorTamanio" ${readonly}>
              <div class="form-text" id="errorTamanio"> ${errores.tamanio} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.estreno" var="plestreno"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="estreno"/> : </label>
              <input class="form-control" id="estreno" name="estreno" type="date" minlength="1900-01-01" maxlength="2024-12-31" value="${videojuego.estreno()}" placeholder="${plestreno}" aria-errormessage="errorEstreno" ${readonly}/>
              <div class="form-text" id="errorEstreno"> ${errores.estreno} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.nombre" var="plnombre"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="ventas"/> : </label>
              <input class="form-control" id="ventas" name="ventas" type="number" minlength="1" maxlength="100" value="${videojuego.ventas()}" placeholder="Ventas" aria-errormessage="errorVentas" ${readonly}>
              <div class="form-text" id="errorVentas"> ${errores.ventas} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.nota" var="plnota"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="nota"/> : </label>
              <input class="form-control" id="nota" name="nota" type="number" min="0" max="10" step="0.1" value="${videojuego.nota()}" placeholder="${plnota}" aria-errormessage="errorNota" ${readonly}/>
              <div class="form-text" id="errorNota"> ${errores.nota} </div>
            </div>
            <div class="form-group mb-3">
              <fmt:message bundle="${textos}" key="placeholder.portada" var="plportada"/>
              <label class="form-label"><fmt:message bundle="${textos}" key="portada"/>: </label>
              <input class="form-control" id="portada" name="portada" type="url" maxlength="1000" value="${videojuego.portada()}" placeholder="${plportada}" aria-errormessage="errorPortada" ${readonly}/>
              <div class="form-text" id="errorPortada"> ${errores.portada} </div>
            </div>

            <c:if test="${action != 'SELECT'}">
              <div>
                <label class="form-label"><fmt:message bundle="${textos}" key="desarrollador"/>: </label>
                <select name="desarrollador" id="desarrollador" ${disabled}>
                  <c:forEach var="desarrolladorDatos" items="${desarrolladores}">
                    <option value="${desarrolladorDatos.id()}">${desarrolladorDatos.nombre()}</option>
                  </c:forEach>
                </select>
              </div>
              <input class="form-control" type="submit" value="${labelSubmit}" />
            </c:if>
            <c:if test="${action == 'SELECT'}">
              <c:set var="urlGetDesarrolladorById" value="${mvc.uri('getDesarrolladorById', {'idDesarrollador' : videojuego.desarrollador() , 'locale': mvc.locale})}"/>
              <c:set var="desarrollador" value="${desarrollador}"/>
              <div class="form-group mb-3">
                <label class="form-label"><fmt:message bundle="${textos}" key="desarrollador"/>: </label>
                <a class="btn btn-success" href="${urlGetDesarrolladorById}">${desarrollador.nombre()}</a>
              </div>
            </c:if>

          </form>
        </div>
      </div>

</body>
</html>
