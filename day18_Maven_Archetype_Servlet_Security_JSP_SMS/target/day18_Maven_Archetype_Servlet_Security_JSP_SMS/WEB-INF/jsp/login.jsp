
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h3>login.jsp</h3>
    <hr/>
    <form action="login" method="POST">
        <!-- the name property below will be passed as parameter on servlet-->
        <!-- we use req.getParameter("") method to access it -->
        Username : <input type="text" name="username">
        Password : <input type="text" name="password">
        <input type="submit" value="Login">
    </form>
</body>
</html>