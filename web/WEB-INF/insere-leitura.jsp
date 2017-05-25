
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insere Leitura:</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
            <%@include file="jspf/menu.jspf" %>
        <h1>Insere Leitura:</h1>
        <form method="post">
            <table border="1">
                <tr>
                    <th>Local:</th>
                    <th>Unidade:</th>
                    <th colspan="2">Leitura:</th>
                </tr>
                <tr>
                    <td>${leitura.local}</td>
                    <td>${leitura.unidade}</td>
                    <td>
                        <input type="text" name="leitura" />
                    </td>
                    <td>
                        <small>* Somente números</small>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" align="right">
                        <button type="submit">Enviar</button>
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </center>
    </body>
</html>
