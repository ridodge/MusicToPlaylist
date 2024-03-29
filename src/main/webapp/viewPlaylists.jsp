<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing Playlists</title>
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
	<h1>List of Playlists and their Songs</h1>
	<form method="post" action="playlistNavigationServlet"
		  style="display:flex; flex-direction: column;">
		<table>
			<c:forEach items="${requestScope.allPlaylists}" var="currentList">
				<tr>
					<td><input type="radio" name="id" value="${currentList.playlistId}"></td>
					<td><h2>${currentList.playlistName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Listener: ${currentList.listener.listenerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentList.songs}">
					<tr>
						<td></td>
						<td colspan="3">"${listVal.title}", by ${listVal.artist}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<br/>
		<button type="submit" value="edit" name="doThisToList">Edit Playlist</button>
		<button type="submit" value="delete" name="doThisToList">Delete Playlist</button>
		<button type="submit" value="add" name="doThisToList">Add New Playlist</button>
	</form>
	<br>
	<a href="index.html">Home</a>
</body>
</html>