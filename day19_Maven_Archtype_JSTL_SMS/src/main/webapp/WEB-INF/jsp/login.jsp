<!-- link for JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h3>login.jsp</h3>
        <hr/>
        <p> ${'Enter details'} </p>
        <!-- for loginMessage -->
        <p>${loginMessage}</p>
        <form action="login" method="POST">
            Username : <input type="text" name="username">
            Password : <input type="text" name="password">
            <input type="submit" value="Login">
        </form>
        <!-- redirect to sign-up page -->
        <button onclick="window.location.href = 'sign-up'">Sign-up</button>
    </body>
</html>