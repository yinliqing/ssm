<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form</title>
</head>
<body>

<h2>Submitted Employee Information</h2>
   <table>
    <tr>
        <td>ID: </td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>UserName: </td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Password: </td>
        <td>${user.password}</td>
    </tr>
</table>  
</body>
</html>