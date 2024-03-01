<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Songs</title>
<style>
	.display {
		display: flex;
		align-items: center;
		justify-content:center;
		height: 100vh;
		flex-direction: column
	}
</style>
</head>
<body class="display">
	<h1>List of Songs:</h1>
	<form method="post" action="songNavigationServlet"
		  style="display:flex; flex-direction: column;">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>"${currentitem.title}", by: ${currentitem.artist} | (${currentitem.genre})</td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<button type="submit" value="edit" name="doThisToItem">Edit Song</button>
		<button type="submit" value="delete" name="doThisToItem">Delete Song</button>
		<button type="submit" value="add" name="doThisToItem">Add New Song</button>
		<br/>
		<button type="submit" value="addTo" name="doThisToItem">Add Song to Playlist</button>
		</form>
		<br/>
		<a href="index.html">Home</a>
</body>
</html>