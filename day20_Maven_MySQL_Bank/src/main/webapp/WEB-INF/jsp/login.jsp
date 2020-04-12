<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="bg-img flex-container ">

    <h3>Login</h3>
    <!-- related to doesNotExistSession -->
    <p>${alert}</p>
    <form class="container"  action="login" method="POST">
        Username : <input type="text" placeholder="Enter Username" name="username">
        Password : <input type="password" placeholder="Enter Password" name="password">
        <button type="submit">Login</button>
    </form>
    <button class="btn" onclick="window.location.href='sign-up'">Go to Sign-up</button>
</div>
</body>
</html>