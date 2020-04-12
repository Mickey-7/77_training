<html>
<head>
    <title>Sign-up</title>
</head>
<body>
    <h3>Sign-up</h3>
    <!-- related to addUserSession -->
    <p>${alert}</p>
    <form action="sign-up" method="POST">
        Username : <input type="text" placeholder="Enter Username" name="username">
        Password : <input type="password" placeholder="Enter Password" name="password">
         Password : <input type="number" placeholder="Enter Initial Deposit" name="balance">
        <button type="submit">Sign-up</button>
    </form>
    <button onclick="window.location.href='login'">Go to Login</button>
</body>
</html>