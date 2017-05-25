<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insere Leitura:</title>
    </head>
    <body>
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
                        <input type="text" name="unidade" />
                    </td>
                    <td>
                        <small>* Somente números</small>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
