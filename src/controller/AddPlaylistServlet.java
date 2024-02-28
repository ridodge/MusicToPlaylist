package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Listener;
import model.Playlist;
import model.Song;

/**
 * Servlet implementation class AddPlaylistServlet
 */
@WebServlet("/addPlaylistServlet")
public class AddPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlaylistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SongHelper sh = new SongHelper();
		String playlistName = request.getParameter("titleName");
		String listenerName = request.getParameter("listenerName");
		String[] selectedItems = request.getParameterValues("songsToAdd");
		List<Song> selectedItemsInList = new ArrayList<Song>();
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				Song s = sh.searchForSongById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(s);
			}
		}
		Listener listener = new Listener(listenerName);
		Playlist pl = new Playlist(playlistName, listener, selectedItemsInList);
		PlaylistHelper ph = new PlaylistHelper();
		ph.insertNewPlaylist(pl);
		System.out.println("Success!");
		getServletContext().getRequestDispatcher("/viewPlaylistServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
