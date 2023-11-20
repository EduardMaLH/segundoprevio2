<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Movimiento</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="#" class="navbar-brand">Registro de Movimiento</a>
        </div>
    </nav>
</header>
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <form action="registro" method="post">

                <caption>
                    <h2>Registrar Movimiento</h2>
                </caption>

                <fieldset class="form-group">
                    <label>Descripción</label>
                    <input type="text" class="form-control" name="descripcion" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Tipo de Movimiento</label>
                    <select class="form-control" name="tipoMovimiento" required="required">
                        <option value="Ingreso">Ingreso</option>
                        <option value="Egreso">Egreso</option>
                    </select>
                </fieldset>

                <fieldset class="form-group">
                    <label>Valor</label>
                    <input type="number" class="form-control" name="valor" required="required">
                </fieldset>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Registrar</button>
                    <a href="#" class="btn btn-secondary">Cancelar</a>
                </div>

            </form>

        </div>
    </div>
</div>

</body>
</html>
