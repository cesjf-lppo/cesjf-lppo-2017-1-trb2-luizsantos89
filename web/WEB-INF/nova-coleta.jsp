
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Coleta</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
            <%@include file="jspf/menu.jspf" %>
            <h1>Cadastrar nova coleta</h1>
            <form method="post">
                <table>
                    <tr>
                        <td>Descrição da coleta: </td>
                        <td><input type="text" name="descricao" size="35" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <button type="submit">Adicionar pontos de leitura</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    </body>
</html>
