<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body><h1>LOGIN</h1>
    <form action="/j_security_check" method="post">    
        <input type="text" placeholder="Id" name="j_username"><br>
        <input type="text" placeholder="Password" name="j_password" type="password"><br>
        <button type="submit">Login</button>      
    </form>
</body>
</html>
