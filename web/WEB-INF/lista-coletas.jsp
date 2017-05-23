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
                <th>Adicionar<br />leituras: </th>
                <th>Descrição:</th>
                <th>Data:</th>
            </tr>
            <c:forEach var="coleta" items="${coletas}">
                <tr>
                    <td align="center">
                        <a href="nova-leitura.html?id=${coleta.id}" title="Cadastrar pontos de leitura para essa coleta">
                            ${coleta.id}</a>
                    </td>
                    <td><a href="lista-leituras.html?id=${coleta.id}" title="Listagem de leituras para essa coleta">
                            ${coleta.descricao}</a>
                    </td>
                    <td>${coleta.data}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="nova-coleta.html">Nova Coleta</a>
    </body>
</html>
