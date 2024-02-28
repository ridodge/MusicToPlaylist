package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Playlist;
/**
 * Servlet implementation class ViewPlaylistServlet
 */
@WebServlet("/viewPlaylistServlet")
public class ViewPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlaylistHelper tdh = new PlaylistHelper();
		List<Playlist> abc = tdh.getPlaylists();
		request.setAttribute("allPlaylists", abc);
		System.out.println(abc);
		if(abc.isEmpty()){
		request.setAttribute("allPlaylists", abc);
		}
		getServletContext().getRequestDispatcher("/viewPlaylists.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
