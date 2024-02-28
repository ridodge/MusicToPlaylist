<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing Playlists</title>
</head>
<body>
	<h1>List of Playlists and their Songs</h1>
	<form method="post" action="playlistNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allPlaylists}" var="currentList">
				<tr>
					<td><input type="radio" name="id" value="${currentList.playlistId}"></td>
					<td><h2>${currentList.playlistName} ${currentList.playlistId} </h2></td>
				</tr>
				<tr>
					<td colspan="3">Listener: ${currentList.listener.listenerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentList.songs}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.title}by ${listVal.artist}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> <input
			type="submit" value="delete" name="doThisToList"> <input
			type="submit" value="add" name="doThisToList">
	</form>
	<br>
	<a href="index.html">Home</a>
</body>
</html>