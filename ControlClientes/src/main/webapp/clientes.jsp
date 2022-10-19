<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/6b976899bc.js" crossorigin="anonymous"></script>

        <title>control de clientes</title>
    </head>
    <body>
        <!--cabecero-->
        <header id>
            <div>
                <div>
                    <div>
                        <h1>control de clientes</h1>
                    </div>
                </div>
            </div>
        </header>
        <div>
            <c:forEach var="cliente" items="${clientes}">
                <li>
                    ${cliente.idCliente}
                    ${cliente.nombre}
                    ${cliente.apellido}
                    ${cliente.saldo}
                </li>
            </c:forEach>
        </div >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    </body>
</html>
