package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Playlist;
import model.Song;

/**
 * Servlet implementation class AddSongToPlaylistServlet
 */
@WebServlet("/addSongToPlaylistServlet")
public class AddSongToPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSongToPlaylistServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/addSongToPlaylist.jsp";
		
		SongHelper sh = new SongHelper();
		PlaylistHelper ph = new PlaylistHelper();
		List<Playlist> pl = ph.getPlaylists();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Song songToAdd = sh.searchForSongById(tempId);
		
		request.setAttribute("songToAdd", songToAdd);
		request.setAttribute("allPlaylists", pl);
		
		if(pl.isEmpty()) {
			path = "index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
