<%-- 
    Document   : mainPage
    Created on : Jan 29, 2016, 10:16:06 PM
    Author     : hanlinshen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/defaultCSS.css"/>
        <link rel="stylesheet" type="text/css" href="css/mainCSS.css"/>
        <title>Main Page</title>
    </head>
    <body>
        <main>
            <form:form action="login" type="POST">
                <table>
                    <tr>
                        <td>员工管理</td>
                        <td>仓储管理</td>
                        <td>数据统计</td>
                    </tr>
                    <tr>
                        <td><img src="image/employees.png" onClick="location.href='employeeManage'"/></td>
                        <td><img src="image/inventory.png" onClick="location.href='inventoryManage'"/></td>
                        <td><img src="image/static.png" /></td>
                    </tr>
                </table>  
            </form:form>
        </main>
    </body>
</html>
