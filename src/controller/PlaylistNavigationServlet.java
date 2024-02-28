package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Playlist;

/**
 * Servlet implementation class PlaylistNavigationServlet
 */
@WebServlet("/playlistNavigationServlet")
public class PlaylistNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistNavigationServlet() {
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
		PlaylistHelper ph = new PlaylistHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewPlaylistServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				System.out.println(request.getParameter("id"));
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Playlist playlistToDelete = ph.searchForPlaylistById(tempId);
				ph.deletePlaylist(playlistToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewPlaylistServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Playlist playlistToEdit = ph.searchForPlaylistById(tempId);
				request.setAttribute("listToEdit", playlistToEdit);
				SongHelper shForItems = new SongHelper();
				request.setAttribute("allItems", shForItems.showAllItems());
				if (shForItems.showAllItems().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/editPlaylist.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewPlaylistServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			SongHelper shForItems = new SongHelper();
			request.setAttribute("allItems", shForItems.showAllItems());
			if (shForItems.showAllItems().isEmpty()) {
				request.setAttribute("allItems", " ");
				getServletContext().getRequestDispatcher("/addPlaylist.jsp").forward(request, response);
			}
		}
	}
}
