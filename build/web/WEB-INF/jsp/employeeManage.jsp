<%-- 
    Document   : employee
    Created on : Jan 29, 2016, 11:07:57 PM
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
        <link rel="stylesheet" type="text/css" href="css/employeeManagePageCSS.css"/>
        <link rel="stylesheet" type="text/css" href="css/menuCSS.css"/>
        <!-- JS -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <title>员工管理</title>
    </head>
    <body>
        <main>
            <h1>员工信息表</h1>
            <table class="persist-area">
                <thead>
                <tr class="persist-header">
                    <th>姓</th>
                    <th>名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>工资</th>
                    <th>出生日期</th>
                    <th>入职日期</th>
                </tr>

                </thead>
                <tbody
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                <c:forEach var="listValue" items="${employeeList}">
                    <tr>
                        <td>${listValue.getLastName()}</td>
                        <td>${listValue.getFirstName()}</td>
                        <td>${listValue.getSex()}</td>
                        <td>${listValue.getAge()}</td>
                        <td>${listValue.getSalary()}</td>
                        <td>${listValue.getDateOfBirth()}</td>
                        <td>${listValue.getDateEmployed()}</td>                
                    </tr>
                </c:forEach>
                </tbody>
            </table>  
            
        <script language="JavaScript" type="text/javascript" src="js/stickyTableHeader.js"></script>
            <jsp:include page="menu.jsp" />                       
        </main>
    </body>
</html>
