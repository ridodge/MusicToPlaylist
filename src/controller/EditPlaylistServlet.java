package controller;

import java.io.IOException;
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
 * Servlet implementation class EditPlaylistServlet
 */
@WebServlet("/editPlaylistServlet")
public class EditPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(1);
		PlaylistHelper ph = new PlaylistHelper();
		SongHelper sh = new SongHelper();
		ListenerHelper lh = new ListenerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Playlist playlistToUpdate = ph.searchForPlaylistById(tempId);
		String newPlaylistName = request.getParameter("playlistName");
		String listenerName = request.getParameter("listenerName");
		// find our add the new shopper
		Listener newListener = lh.findListener(listenerName);
		try {
			// items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			
			List<Song> selectedSongs = new ArrayList<Song>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Song song = sh.searchForSongById(Integer.parseInt(selectedItems[i]));
				selectedSongs.add(song);
			}
			playlistToUpdate.setSongs(selectedSongs);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Song> selectedSongs = new ArrayList<Song>();
			playlistToUpdate.setSongs(selectedSongs);
		}
		playlistToUpdate.setPlaylistName(newPlaylistName);
		playlistToUpdate.setListener(newListener);
		ph.updatePlaylist(playlistToUpdate);
		getServletContext().getRequestDispatcher("/viewPlaylistServlet").forward(request, response);
	}

}
