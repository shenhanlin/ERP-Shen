<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
    </head>

    <body>
        <form:form action="login" type="POST">
            <h2><span class="entypo-login"></span> Login</h2>
            <button class="submit"><span class="entypo-lock"></span></button>
            <span class="entypo-user inputUserIcon"></span>
            <input type="text" class="user" placeholder="username" name = "username"/>
            <span class="entypo-key inputPassIcon"></span>
            <input type="password" class="pass"placeholder="password" name = "userPassword"/>
        </form:form>
            
            <h1>${loginResult}</h1>
    </body>
</html>
