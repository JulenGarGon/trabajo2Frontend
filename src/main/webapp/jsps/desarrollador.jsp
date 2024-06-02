<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 29/5/24
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${mvc.locale}"/>
<fmt:setBundle var="textos" basename="textos"/>

<fmt:message bundle="${textos}" key="aniade" var="add"/>
<fmt:message bundle="${textos}" key="actualiza" var="update"/>
<fmt:message bundle="${textos}" key="borra" var="delete"/>

<c:choose>
    <c:when test="${action eq 'SELECT'}">
        <c:set var="readonly" value="readonly"/>
    </c:when>
    <c:when test="${action eq 'INSERT'}">
        <c:set var="readonly" value=""/>
        <c:set var="labelSubmit" value="${add}"/>
        <c:set var="uriForm" value="${mvc.uri('insertDesarrollador', {'locale': mvc.locale})}"/>
        <c:set var="methodForm" value="POST"/>
    </c:when>
    <c:when test="${action eq 'UPDATE'}">
        <c:set var="readonly" value=""/>
        <c:set var="labelSubmit" value="${update}"/>
        <c:set var="uriForm" value="${mvc.uri('updateDesarrolladorById', {'idDesarrollador' : desarrollador.id(), 'locale': mvc.locale})}"/>
        <c:set var="methodForm" value="PUT"/>
    </c:when>
    <c:otherwise>
        <c:set var="readonly" value="readonly"/>
        <c:set var="labelSubmit" value="${delete}"/>
        <c:set var="uriForm" value="${mvc.uri('deleteDesarrolladorById', {'idDesarrollador' : desarrollador.id(), 'locale': mvc.locale})}"/>
        <c:set var="methodForm" value="DELETE"/>
    </c:otherwise>
</c:choose>

<html>
<head>
    <title>${desarrollador.nombre()}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>${desarrollador.id()} - ${desarrollador.nombre()}</h1>

    <div class="row">
        <div class="col-3">
            <img src="${desarrollador.logo()}" class="img-fluid"/>
        </div>
        <div class="col-7">
            <form method="POST" action="${uriForm}" enctype="application/x-www-form-urlencoded">
                <input name="id" type="hidden" value="${desarrollador.id()}">
                <input type="hidden" name="_method" value="${methodForm}"/>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.nombre" var="plnombre"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="nombre"/>: </label>
                    <input class="form-control" id="nombre" name="nombre" type="text" minlength="1" maxlength="50" value="${desarrollador.nombre()}" placeholder="${plnombre}" aria-errormessage="errorNombre" ${readonly}/>
                    <div class="form-text" id="errorNombre"> ${errores.nombre} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.fundacion" var="plfundacion"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="fundacion"/> : </label>
                    <input class="form-control" id="fundacion" name="fundacion" type="date" minlength="1900-01-01" maxlength="2024-12-31" value="${desarrollador.fundacion()}" placeholder="${plfundacion}" aria-errormessage="errorFundacion" ${readonly}/>
                    <div class="form-text" id="errorFundacion"> ${errores.fundacion} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.fundador" var="plfundador"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="fundador"/> : </label>
                    <input class="form-control" id="fundador" name="fundador" type="text" minlength="1" maxlength="100" value="${desarrollador.fundador()}" placeholder="${plfundador}" aria-errormessage="errorFundador" ${readonly}/>
                    <div class="form-text" id="errorFundador"> ${errores.fundador} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.empleados" var="plempleados"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="nEmpleados"/> : </label>
                    <input class="form-control" id="empleados" name="empleados" type="number" min="1" max="100000" step="1" value="${desarrollador.empleados()}" placeholder="${plempleados}" aria-errormessage="errorEmpleados" ${readonly}/>
                    <div class="form-text" id="errorEmpleados"> ${errores.empleados} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.sede" var="plsede"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="sede"/> : </label>
                    <input class="form-control" id="sede" name="sede" type="text" minlength="1" maxlength="200" value="${desarrollador.sede()}" placeholder="${plsede}" aria-errormessage="errorSede" ${readonly}/>
                    <div class="form-text" id="errorSede"> ${errores.sede} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.sitioweb" var="plsw"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="sitioWeb"/> : </label>
                    <input class="form-control" id="sitioWeb" name="sitioWeb" type="url" maxlength="200" value="${desarrollador.sitioWeb()}" placeholder="${plsw}" aria-errormessage="errorSitioWeb" ${readonly}/>
                    <div class="form-text" id="errorSitioWeb"> ${errores.sitioweb} </div>
                </div>
                <div class="form-group mb-3">
                    <fmt:message bundle="${textos}" key="placeholder.logo" var="pllogo"/>
                    <label class="form-label"><fmt:message bundle="${textos}" key="logo"/> : </label>
                    <input class="form-control" id="logo" name="logo" type="url" maxlength="1000" value="${desarrollador.logo()}" placeholder="${pllogo}" aria-errormessage="errorLogo" ${readonly}/>
                    <div class="form-text" id="errorLogo"> ${errores.logo} </div>
                </div>
                <c:if test="${action != 'SELECT'}">
                    <input class="form-control" type="submit" value="${labelSubmit}" />
                </c:if>
            </form>
        </div>
    </div>

    <c:if test="${action == 'SELECT'}">
        <table>
            <thead>
                <th><fmt:message bundle="${textos}" key="identificador"/></th>
                <th><fmt:message bundle="${textos}" key="nombre"/></th>
                <th><fmt:message bundle="${textos}" key="estreno"/></th>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="videojuego" items="${videojuegos}">
                <c:set var="urlGetVideojuegoById" value="${mvc.uri('getVideojuegoById', {'idVideojuego' : videojuego.id(), 'locale': mvc.locale})}"/>
                <tr>
                    <td class="col-1"><h1>${videojuego.id()}</h1></td>
                    <td class="col-3 align-middle"><h2><a href="${urlGetVideojuegoById}">${videojuego.nombre()}</a></h2></td>
                    <td class="col-2"><h3>${videojuego.estreno()}</h3></td>
                    <td class="col-2"><img src="${videojuego.portada()}" class="img-fluid"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
