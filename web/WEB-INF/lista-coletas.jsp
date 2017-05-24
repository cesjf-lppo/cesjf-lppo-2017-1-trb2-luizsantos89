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
                <th>Descrição:</th>
                <th>Data:</th>
            </tr>
            <c:forEach var="coleta" items="${coletas}">
                <tr>
                    <td>ID: ${coleta.id}</td>
                    <td><a href="lista-leituras.html?coleta=${coleta.id}" title="Listagem de leituras para essa coleta">
                            ${coleta.descricao}</a>
                    </td>
                    <td>${coleta.data}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="nova-leitura.html">Cadastrar pontos de leitura</a>
        <a href="nova-coleta.html">Nova Coleta</a>
    </body>
</html>
