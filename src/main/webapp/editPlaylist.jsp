<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Playlist</title>
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
	<h3>Hold ctrl and click to select which songs you would like in the playlist:</h3>
	<form action="editPlaylistServlet" method="post">
		<input type="hidden" name="id" value="${playlistToEdit.playlistId}"> 
		Playlist Name: <input type="text" name="playlistName" value="${playlistToEdit.playlistName}"><br />
		Listener Name: <input type="text" name="listenerName" value="${playlistToEdit.listener.listenerName}"><br />
		Songs: <br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title} by ${currentitem.artist}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Done Editing">
	</form>
	<br/>
	<a href="index.html">Home</a>
</body>
</html>