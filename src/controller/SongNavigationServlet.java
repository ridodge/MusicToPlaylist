package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Song;

/**
 * Servlet implementation class SongNavigationServlet
 */
@WebServlet("/songNavigationServlet")
public class SongNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongNavigationServlet() {
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
		
		String act = request.getParameter("doThisToItem");
		String path = "/viewSongsServlet";
		
		SongHelper sh = new SongHelper();
		
		if(act.equals("delete")) {
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Song itemToDelete = sh.searchForSongById(tempId);
				sh.deleteItem(itemToDelete);
				
			} catch (NumberFormatException e) {
				
				System.out.println("Forgot to select an item");
				
			}
		}
		else if(act.equals("edit")) {
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Song itemToEdit = sh.searchForSongById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/editSong.jsp";
				
			} catch (NumberFormatException e) {
				
				System.out.println("Forgot to select an item");
				
			}
		}
		else if(act.equals("add")) {
			
			path = "/addSong.jsp"; 
			
		}
		else if(act.equals("addTo")) {
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Song songToAdd = sh.searchForSongById(tempId);
				request.setAttribute("songToAdd", songToAdd);
				path = "/addSongToPlaylistServlet";
				
			} catch (NumberFormatException e) {
				
				System.out.println("Forgot to select an item");
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
