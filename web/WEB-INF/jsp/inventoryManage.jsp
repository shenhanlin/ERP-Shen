<%-- 
    Document   : inventory
    Created on : Jan 30, 2016, 9:46:54 PM
    Author     : hanlinshen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/defaultCSS.css"/>
        <link rel="stylesheet" type="text/css" href="css/defaultTableCSS.css"/>
        <link rel="stylesheet" type="text/css" href="css/menuCSS.css"/>
        <link rel="stylesheet" type="text/css" href="css/inventoryManagePageCSS.css"/>
        <!-- JS -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <title>仓储管理</title>
    </head>
    <body>

        <table class="persist-area">
            <thead>
                <tr class="persist-header">
                    <th>物品编号</th>
                    <th>物品名称</th>
                    <th>物品数量</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="listValue" items="${inventoryList}">
                <tr>
                    <td>${listValue.getInventoryId()}</td>
                    <td>${listValue.getInventoryItemDetailName()}</td>
                    <td>${listValue.getInventoryQuantity()}</td>              
                </tr>
            </c:forEach>
        </tbody>
    </table>  
        <jsp:include page="menu.jsp" /> 
</body>
</html>
