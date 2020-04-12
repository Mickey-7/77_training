<!-- link for JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Sign-up</title>
    </head>
    <body>
        <h3>sign-up.jsp</h3>
        <hr/>
        <p> ${'Enter credentials'} </p>
         <form action="sign-up" method="POST">
            Name : <input type="text" name="name">
            Username : <input type="text" name="username">
            Password : <input type="text" name="password">
            <input type="submit" value="Sign-up">
        </form>

        <!-- redirect to login-->
        <button onclick="window.location.href='login'" >go to Login page</button>

        <!-- printing the message if username exist already-->
        <p>${user}</p>

        <!-- printing the message if for adding successful sign-up-->
        <p>${message}</p>

    </body>
</htm