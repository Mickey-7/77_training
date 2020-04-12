<html>
<head>
    <title>Deposit</title>
</head>
<body>
    <h3>Deposit</h3>
    <p>Enter amount to be withdrawn</p>
    <!-- related to withdrawSession -->
    <p>${alert}</p>
    <form action="withdraw" method="POST">
        Amount : <input type="number" placeholder="Enter Amount" name="transAmt">
        <button type="submit">Withdraw</button>
    </form>
    <button onclick="window.location.href='menu'">Go to Menu</button>
</body>
</html>