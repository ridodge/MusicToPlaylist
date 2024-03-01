<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing Song</title>
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
	<h3>What would you like to update?</h3>
	<form action="editSongServlet" method="post"
		  style="display:flex; flex-direction: column;">
		Title: <input type="text" name="title" value="${itemToEdit.title}">
		Artist: <input type="text" name="artist" value="${itemToEdit.artist}">
		Genre: <input type="text" name="genre" value="${itemToEdit.genre}">
	<input type="hidden" name="id" value="${itemToEdit.id}">
	<br/>
	<input type="submit" value="Save Edited Item">
	</form> <br />
	<a href = "viewAllItemsServlet">View All Songs</a>
	<a href="viewAllSongsServlet">View Playlist</a>
	<br />
	<a href="addSongsForPlaylistServlet">Create New Playlist</a>

</body>
</html>