<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>JPA User Test</title>
</head>
<body>
<h3>Spring WEB MVC JPA Test</h3>
 
<form:form method="post" action="/user/add.html" modelAttribute="User" >
     ID : <input id="id" type="text"/><br/>
     USERNAME : <input id="username" type="text"/><br/><br/>
    <input type="submit" value="User Save" />
</form:form>
</body>
</html>