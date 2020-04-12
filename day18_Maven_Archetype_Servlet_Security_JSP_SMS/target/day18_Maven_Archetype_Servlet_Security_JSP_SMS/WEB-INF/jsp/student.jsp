<html>
<head>
    <title>Students</title>
</head>
<body>
    <h3>student.jsp</h3>
    <hr/>
    <!-- displaying the students mock data -->
    <%= request.getAttribute("student")%>
    <hr/>
    <!-- creating table -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Grade</th>
        </tr>
    </table>
    <br/>

    <!-- for logout-->
    <!-- window.location.href returns the href (URL) of the current page -->
    <button onclick="window.location.href='logout'">Logout</button>
</body>
</html>