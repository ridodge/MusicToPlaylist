<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song to Playlist</title>
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
	
	<form method="post" action="addToPlaylistServlet">
	<input name="songId" value="${songToAdd.id}">
	<p> What playlist would you like to add | "${songToAdd.title}", by: ${songToAdd.artist} | to?</p>
		<table>
			<c:forEach items="${requestScope.allPlaylists}" var="currentList">
				<tr>
					<td><input type="radio" name="playlistId" value="${currentList.playlistId}"></td>
					<td><h2>${currentList.playlistName}</h2></td>
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
		<br/>
		<input type="submit" value="Add To Playlist" name="addToPlaylist">
	</form>

</body>
</html>