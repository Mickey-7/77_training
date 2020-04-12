<!-- link for JSTL -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h3>users.jsp</h3>
        <hr/>
        <p>${'Displaying users list'}</p>
        <table>
            <tr>
                <th>Name</th>
                <th>Username</th>
                <th>Password</th>
            </tr>
        <!-- iterate on userList items from users attribute -->
         <c:forEach var="user" items="${userList}">
            <tr style="text-align:center">
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
         </c:forEach>
         <!-- need to terminate c:forEach -->
        </table>
        <p> ${'Successfully logged in : '} ${username}</p>
        <button onclick="window.location.href='logout'">Logout</button>
    </body>
</html>