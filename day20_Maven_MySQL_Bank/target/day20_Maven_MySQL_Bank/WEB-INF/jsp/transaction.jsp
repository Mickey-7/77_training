<!-- link for JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h3>Transactions</h3>
    <table>
        <tr>
            <th>Username</th>
            <th>Balance</th>
            <th>Transaction</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.balance}</td>
            <td>${user.transaction}</td>
            <td>${user.transAmt}</td>
            <td>${user.transDate}</td>
            <td>${user.transTime}</td>
        </tr>
        </c:forEach>
    </table>
    <button onclick="window.location.href='menu'">Go to Menu</button>
</body>
</html>