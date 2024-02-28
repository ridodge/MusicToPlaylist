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
	<form style="display: flex; flex-direction: column;"
		action="addPlaylistServlet" method="post">
		Playlist Name: <input type="text" name="titleName"> Listener: <input
			type="text" name="listenerName">
			 Songs:<br /> <select name="songsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title} by
					${currentitem.artist}</option>
			</c:forEach>
			</select>
			<br />
			<input type="submit" value="Add Playlist">
	</form>
	<br />
</body>
</html>
