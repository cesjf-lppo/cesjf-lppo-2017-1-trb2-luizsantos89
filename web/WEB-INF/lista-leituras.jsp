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
                <th>Coleta:</th>
                <th>Local:</th>
                <th>Leitura:</th>
                <th>Unidade:</th>
                <th>Atualização:</th>
            </tr>
            <c:forEach var="leitura" items="${leituras}">
                <tr>
                    <td>${leitura.descricaoColeta}</td>
                    <td>${leitura.local}</td>
                    <td>
                        <c:if test="${leitura.leitura==0}">
                            <a href="cadastrar-leitura.html?id=${leitura.id}">Cadastrar Leitura</a>
                        </c:if>
                        <c:if test="${leitura.leitura!=0}">
                            ${leitura.leitura}
                        </c:if>
                    </td>
                    <td>${leitura.unidade}</td>
                    <td>${leitura.atualizacao}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="nova-coleta.html">Nova Coleta</a>
    </body>
</html>
