<%-- 
    Document   : reorder
    Created on : 2018-8-1, 22:44:20
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="reorderServlet" method="post">
        <table border="1">
            <tr><td>Input:</td><td><input type="text" name="input"/></td></tr>
            
            <tr><td><input type="submit" value="Submit"/></td><td><input type="reset" value="Reset"/></td></tr>
            
        </table>
        </form>
    </body>
</html>
