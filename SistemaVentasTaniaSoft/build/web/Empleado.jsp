
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Empleados</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST"> <!-- FORMULARIO PARA INGRESAR UN NUEVO CLIENTE -->
                        <!-- Campo para el Dni -->
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${not empty empleado ? empleado.getDni() : ''}" name="txtDni" class="form-control"> 
                            <!-- Mensaje de error para el campo Telefono -->
                            <div class="text-danger" id="mensajeErrorDni">
                                ${mensajeErrorDni}
                                <script>
                                    // Función para ocultar el mensaje de error después de 7 segundos
                                    setTimeout(function () {
                                        document.getElementById('mensajeErrorDni').style.display = 'none';
                                    }, 20000); // Duración en milisegundos del mensaje de error
                                </script>
                            </div>
                        </div>
                        <!-- Campo para los Nombres -->
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${not empty empleado ? empleado.getNom() : ''}" name="txtNombres" class="form-control"> 
                        </div>
                        <!-- Campo para el Telefono -->
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${not empty empleado ? empleado.getTel() : ''}" name="txtTel" class="form-control"> 
                            <!-- Mensaje de error para el campo Telefono -->
                            <div class="text-danger" id="mensajeErrorTelefono">
                                ${mensajeErrorTelefono}
                                <script>
                                    // Función para ocultar el mensaje de error después de 7 segundos
                                    setTimeout(function () {
                                        document.getElementById('mensajeErrorTelefono').style.display = 'none';
                                    }, 20000); // Duración en milisegundos del mensaje de error
                                </script>
                            </div>
                        </div>
                        <!-- Campo para el Estado -->
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${not empty empleado ? empleado.getEstado() : ''}" name="txtEstado" class="form-control">
                            <!-- Mensaje de error para el campo Estado -->
                            <div class="text-danger" id="mensajeErrorEstado">
                                ${mensajeErrorEstado}
                                <script>
                                    // Función para ocultar el mensaje de error después de 7 segundos
                                    setTimeout(function () {
                                        document.getElementById('mensajeErrorEstado').style.display = 'none';
                                    }, 20000); // Duración en milisegundos del mensaje de error
                                </script>
                            </div>
                        </div> 
                        <!-- Campo para la Direccion -->
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${not empty empleado ? empleado.getUser() : ''}" name="txtUser" class="form-control"> 
                        </div>
                        <!-- BOTONES PARA GUARDAR y CANCELAR GUARDADO; ACTUALIZAR Y CANCELAR EDICIÓN -->
                        <div class="d-flex">
                            <!-- Mostrar el botón de "Guardar" solo cuando no se está editando un empleado -->
                            <c:if test="${empty editarEmpleado}">
                                <button type="submit" name="accion" style="margin-right: 6px" value="Guardar" class="btn btn-primary" onclick="return confirm('¿Estás seguro de GUARDAR este empleado?')">Guardar</button>
                                <button type="submit" name="accion" value="cancelarGuardado" class="btn btn-danger" onclick="return confirm('¿Estás seguro de CANCELAR el guardado del empleado?')">Cancelar</button>
                            </c:if>
                            <!-- Mostrar los botones de "Actualizar" y "Cancelar" solo cuando se está editando un empleado -->
                            <c:if test="${not empty editarEmpleado}">
                                <button type="submit" name="accion" style="margin-right: 6px" value="Actualizar" class="btn btn-success" onclick="return confirm('¿Estás seguro de ACTUALIZAR este empleado?')">Actualizar</button>
                                <button type="submit" name="accion" value="cancelarEdicion" class="btn btn-danger" onclick="return confirm('¿Estás seguro de CANCELAR la edición?')">Cancelar</button>
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8" style="overflow-y: auto; max-height: 500px;">
                <table Class="table table-striped table-hover">
                    <thead>
                        <tr class="text-left"> 
                            <th scope="col">ID</th>
                            <th scope="col">DNI</th>
                            <th scope="col">NOMBRES</th>
                            <th scope="col">TELEFONO</th>
                            <th scope="col">ESTADO</th>
                            <th scope="col">USER</th>
                            <th scope="col">ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}"> <!--El atributo clientes se esta enviando desde el controlador.-->
                            <tr> <!-- ARROJAMIENTO DE LOS DATOS DE LOS CLIENTES AGREGADOS -->
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNom()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td class="d-flex"> <!-- td PARA LOS BOTONES DE EDITAR Y ELIMINAR EMPLEADOS -->
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}" onclick="return confirm('¿Estás seguro de iniciar a EDITAR este empleado?')">Editar</a> 
                                    <a class="btn btn-danger" style="margin-left: 6px" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}" onclick="return confirm('¿Estás seguro de ELIMINAR este Empleado?')">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>          
        </div>

        <!-- MENSAJE EXITO EN LAS ACCIONES -->
        <!-- Mensaje de éxito al realizar una acción --> 
        <% String mensajeCorrecto = (String) request.getAttribute("mensajeCorrecto");
            if (mensajeCorrecto != null) {%>
        <div id="mensajeCorrecto" class="alert alert-success text-center" style="position: fixed; bottom: 0px; left: 50%; transform: translateX(-50%);" role="alert">
            <%= mensajeCorrecto%>
        </div>
        <script>
            // Función para ocultar el mensaje de éxito después de 6 segundos
            setTimeout(function () {
                document.getElementById('mensajeCorrecto').style.display = 'none';
            }, 7000); // Duración en milisegundos del mensaje de éxito
        </script>
        <%}%>

        <!-- MENSAJE EXITO EN LAS ACCIONES DE CANCELAR-->
        <!-- Mensaje de éxito al realizar una cancelacion --> 
        <% String mensajeCancelar = (String) request.getAttribute("mensajeCancelar");
            if (mensajeCancelar != null) {%>
        <div id="mensajeCancelar" class="alert alert-warning text-center" style="position: fixed; bottom: 0px; left: 50%; transform: translateX(-50%);" role="alert">
            <%= mensajeCancelar%>
        </div>
        <script>
            // Función para ocultar el mensaje de éxito después de 6 segundos
            setTimeout(function () {
                document.getElementById('mensajeCancelar').style.display = 'none';
            }, 7000); // Duración en milisegundos del mensaje de éxito
        </script>
        <%}%>

        <!-- MENSAJE DE ERROR EN LAS ACCIONES -->
        <!-- Mensaje de error al realizar una accion-->            
        <% String mensajeError = (String) request.getAttribute("mensajeError");
            if (mensajeError != null) {%>
        <div id="mensajeError" class="alert alert-danger text-center" style="position: fixed; bottom: 0px; left: 50%; transform: translateX(-50%);" role="alert">
            <%= mensajeError%>
        </div>
        <script>
            // Función para ocultar el mensaje de éxito después de 6 segundos
            setTimeout(function () {
                document.getElementById('mensajeError').style.display = 'none';
            }, 8000); // Duración en milisegundos del mensaje de éxito
        </script>
        <%}%>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
