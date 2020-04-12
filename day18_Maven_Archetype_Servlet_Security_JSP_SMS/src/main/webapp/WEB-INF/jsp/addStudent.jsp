<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h3>addStudent.jsp</h3>
    <hr/>
    <form action="addStudent" method="POST">
        <!-- the name property below will be passed as parameter on servlet-->
        <!-- we use req.getParameter("") method to access it -->
        ID: <input type="text" name="id">
        Name: <input type="text" name="name">
        Grade: <input type="text" name="grade">

        <input type="submit" value="Add Student">
    </form>
</body>
</html>