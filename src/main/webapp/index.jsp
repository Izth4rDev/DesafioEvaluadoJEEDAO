<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Proveedores</title>
</head>

<body>
<h2 class="text-center text-primary my-4">Lista de proveedores</h2>
<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Rut</th>
            <th scope="col">Dirección</th>
            <th scope="col">Correo</th>
            <th scope="col">Teléfono</th>
            <th scope="col">Contacto</th>
            <th scope="col">TelContacto</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="supplier" items="${providers_res}">
            <tr>
                <td>${supplier.name}</td>
                <td>${supplier.rut}</td>
                <td>${supplier.address}</td>
                <td>${supplier.mail}</td>
                <td>${supplier.phoneNumber}</td>
                <td>${supplier.contact}</td>
                <td>${supplier.contactNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <a class="btn btn-primary" href="providers">Cargar lista</a>
</div>

<div class="container-fluid">
    <h2 class="text-center text-primary">Ingresar un nuevo proveedor</h2>
    <form action="providers" method="POST">
        <label for="name">Nombre</label>
        <input type="text" class="form-control" name="name" id="name" required>
        <label for="name">rut</label>
        <input type="text" class="form-control" name="rut" id="rut" required>
        <label for="name">Direccion</label>
        <input type="text" class="form-control" name="address" id="address" required>
        <label for="mail">Correo</label>
        <input type="email" class="form-control" name="mail" id="mail" required>
        <label for="phoneNumber">Numero de Telefono</label>
        <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" required>
        <label for="contact">Contacto</label>
        <input type="text" class="form-control" name="contact" id="contact" required>
        <label for="contactNumber">Contacto</label>
        <input type="text" class="form-control" name="contacNumber" id="contactNumber" required>
        <button type="submit" class="btn btn-primary">Registrar</button>
    </form>

    <c:if test="${not empty respNewUser}">
        <div class="alert alert-danger" role="alert">
            ${respNewUser}
        </div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>