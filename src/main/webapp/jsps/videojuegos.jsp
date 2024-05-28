<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 28/5/24
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Identificador</th>
                <th>Nombre</th>
                <th>Estreno</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="videojuego" items="${videojuegos}">
                <tr>
                    <td>${videojuego.id()}</td>
                    <td>${videojuego.nombre()}</td>
                    <td>${videojuego.estreno()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
