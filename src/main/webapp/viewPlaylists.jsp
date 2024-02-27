<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing Playlists</title>
</head>
<body>
	<h1>List of Playlists and their Songs</h1>
	<table>
		<c:forEach items="${requestScope.allPlaylists}" var="currentPlaylist">
			<tr>
				<td>Name: ${currentPlaylist.name} | </td>
				<td>Created By: ${currentPlaylist.creator}</td>
			</tr>
			<c:forEach items="${currentPlaylist.songs}" var="currentSong">
				<tr>
					<td>     Title: ${currentSong.title} | </td>
					<td>Artist: ${currentSong.artist} | </td>
					<td>Genre: ${currentSong.genre}</td>
				</tr>
			</c:forEach> 
		</c:forEach> 
	</table>
	<br>
	<a href="index.jsp">Home</a>
</body>
</html>