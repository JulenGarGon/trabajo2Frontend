<%--
  Created by IntelliJ IDEA.
  User: Julen
  Date: 29/5/24
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
      <tr>
        <th>Id</th>
        <td>${videojuego.id()}</td>
      </tr>
      <tr>
        <th>Nombre</th>
        <td>${videojuego.nombre()}</td>
      </tr>
      <tr>
        <th>Estreno</th>
        <td>${videojuego.estreno()}</td>
      </tr>
      <tr>
        <th>Duración</th>
        <td>${videojuego.duracion()}</td>
      </tr>
      <tr>
        <th>Ventas</th>
        <td>${videojuego.ventas()}</td>
      </tr>
      <tr>
        <th>Portada</th>
        <td>${videojuego.portada()}</td>
      </tr>
    </table>
</body>
</html>
