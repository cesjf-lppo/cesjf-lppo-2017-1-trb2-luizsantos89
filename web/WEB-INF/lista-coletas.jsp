<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de coletas</title>
    </head>
    <body>
        <h1>Lista de Coletas</h1>
        <table border="1">
            <tr>
                <th>ID: </th>
                <th>Descrição:</th>
                <th>Data:</th>
            </tr>
            <c:forEach var="coleta" items="${coletas}">
                <tr>
                    <td>
                        <a href="detalhe.html?id=${coleta.id}" title="Detalhes sobre a coleta">
                            ${coleta.id}</a>
                    </td>
                    <td>${coleta.descricao}</td>
                    <td>${coleta.data}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
