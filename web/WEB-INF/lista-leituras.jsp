
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Leituras</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
            <%@include file="jspf/menu.jspf" %>
        <h1>Lista de Leituras:</h1>
        <table border="1">
            <tr>
                <th>Coleta:</th>
                <th>Local:</th>
                <th>Leitura:</th>
                <th>Unidade:</th>
                <th>Atualização: </th>
            </tr>
            <c:forEach var="leitura" items="${leituras}">
                <tr>
                    <td><a href="lista-leituras.html?coleta=${leitura.coleta}">${leitura.coleta}</a></td>
                    <td><a href="lista-leituras.html?local=${leitura.local}">${leitura.local}</a></td>
                    <td>
                        <c:if test="${leitura.leitura==0.0}">
                            <a href="insere-leitura.html?id=${leitura.id}">Inserir dados</a>
                        </c:if>
                        <c:if test="${leitura.leitura!=0.0}">
                            ${leitura.leitura}
                        </c:if>
                    </td>
                    <td>${leitura.unidade}</td>
                    <td>${leitura.atualizacao}</td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </center>
    </body>
</html>
