
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Leitura</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
            <%@include file="jspf/menu.jspf" %>
        <%@include file="jspf/menu.jspf" %>
        <h1>Cadastro de Leituras:</h1>
        <form method="post">
            <input type="hidden" value="${leitura.id}" name="id" />
            <h2>${leitura.descricaoColeta}</h2>
            <table>
                <table>
                    <tr>
                        <th>Descrição da Coleta: </th>
                        <td>${leitura.descricaoColeta}</td>
                    </tr>
                    <tr>
                        <td>Leitura: </td>
                        <td>
                            <input type="text" name="leitura" />
                        </td>
                        <td><small>* Somente números</small></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <button type="submit">Cadastrar</button>
                        </td>
                    </tr>
                </table>
            </table>
        </form>
        </div>
    </center>
    </body>
</html>
