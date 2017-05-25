
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Coletas</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
            <%@include file="jspf/menu.jspf" %>
            <h1>Lista de Coletas</h1>
            <table border="1">
                <tr>
                    <th>Descrição:</th>
                    <th>Data:</th>
                </tr>
                <c:forEach var="coleta" items="${coletas}">
                    <tr>
                        <td><a href="lista-leituras.html?coleta=${coleta.id}" title="Listagem de leituras para essa coleta">
                                ${coleta.descricao}</a>
                        </td>
                        <td>${coleta.data}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </center>
    </body>
</html>
