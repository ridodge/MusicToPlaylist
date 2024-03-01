<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
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
	<h3>Please enter song information:</h3>
	<form style="display:flex; flex-direction: column;"
	 	  action = "addSongServlet" method="post">
		Title: <input type="text" name="title">
		Artist: <input type="text" name="artist">
		Genre: <input type="text" name="genre">
		<br/>
		<input type = "submit" value="Add Song">
	</form> <br />
	<a href = "viewSongsServlet">View All Songs</a>
	<a href="viewPlaylistServlet">View Playlist</a>
	<br />
	<a href="index.html">Home</a>
</body>
</html>