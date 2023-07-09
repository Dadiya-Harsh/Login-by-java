<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
.container
{
	width:40%;
	border:1px solid black;
	margin: auto;
	font-size: 25px;
	padding: 20px
}
#fr table tr td input
{
	font-size: 25px;
}
</style>
</head>
<body>
<div class="container">
<form id="fr" action="LoginServlet" method="post">
<table>
<tr>
<td style="text-align: center">User-Name</td>
<td style="text-align: center"><input type="text" name="user_name" placeholder="Enter Here"></td>
</tr>
<tr>
<td style="text-align: center">Password</td>
<td style="text-align: center"><input type="password" name="user_password" placeholder="Enter Here"></td>
</tr>
<tr>
<td><input type="submit" name="submit"></td>

</tr>
</table>
</form>
</div>
</body>
</html>