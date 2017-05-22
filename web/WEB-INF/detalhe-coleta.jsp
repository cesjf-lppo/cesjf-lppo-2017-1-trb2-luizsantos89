<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe Coleta ${coleta.descricao}</title>
    </head>
    <body>
        <h1>Detalhes da coleta ${coleta.descricao}</h1>
        
        <form method="post">
            <input type="hidden" name="id" value="${coleta.id}" />
            <small>Criada em: ${coleta.data} </small>
            <br />
            <table>
                <tr>
                    <td>Local </td>
                    <td>
                        <input type="text" name="local" />
                    </td>
                </tr>
                <tr>
                    <td>Leitura: </td>
                    <td><input type="text" name="leitura" /></td>
                    <td><small>*Somente números</small></td>
                </tr>
                <tr>
                    <td>Unidade </td>
                    <td><input type="text" name="unidade" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><button type="submit">Enviar</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
