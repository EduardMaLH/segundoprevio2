<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="co.empresa.test.modelo.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movimientos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h2>Movimientos List</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Pais</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Dummy data for testing, replace it with actual data
            List<Usuario> listUsuarios = (List<Usuario>) request.getAttribute("listUsuarios");
            if (listUsuarios != null) {
                for (Usuario usuario : listUsuarios) {
        %>
        <tr>
            <td><%= usuario.getId() %></td>
            <td><%= usuario.getNombre() %></td>
            <td><%= usuario.getEmail() %></td>
            <td><%= usuario.getPais() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <a href="registroMovimiento.jsp" class="btn btn-primary">Registro de Movimiento</a>
</div>

</body>
</html>
