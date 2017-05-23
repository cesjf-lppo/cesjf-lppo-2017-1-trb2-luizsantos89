<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar ponto de leitura:</title>
    </head>
    <body>
        <h1>Cadastrar Ponto de Leitura: </h1>
        
        <form method="post">
            <table>
                <tr>
                    <td>Coleta:</td>
                    <td>
                        <select name="coleta">
                            <c:forEach var="coleta" items="${coletas}">
                                <option value="${coleta.id}">${coleta.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                </tr>
                <tr>
                    <td>Unidade: </td>
                    <td>
                        <input type="text" name="unidade" />
                    </td>
                </tr>
                <tr>
                    <td>Local: </td>
                    <td>
                        <input type="text" name="local" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <button type="submit">Cadastrar</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
