<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Playlist</title>
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
	<form style="display:flex; flex-direction: column;" action = "addSongServlet" method="post">
		Playlist Name: <input type="text" name="title">
		Creator: <input type="text" name="creator">
		<br/>
		<input type = "submit" value="Add Playlist">
	</form> <br />
</body>
</html>