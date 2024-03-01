<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Playlist</title>
<style>
.display {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	flex-direction: column
}
</style>
</head>
<body class="display">
	<h2>Please enter the name of the playlist and who created it:</h2>
	<form style="display: flex; flex-direction: column;"
		action="addPlaylistServlet" method="post">
		Playlist Name: <input type="text" name="titleName"> Listener: <input
			type="text" name="listenerName">
			<br />
			<input type="submit" value="Add Playlist">
	</form>
	<br />
	<a href="index.html">Home</a>
</body>
</html>
