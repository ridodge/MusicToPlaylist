/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 27, 2024
 */


package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Playlist;

/**
 * 
 */
public class PlaylistHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Music");

	public void insertNewPlaylist(Playlist p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public List<Playlist> getPlaylists() {
		EntityManager em = emfactory.createEntityManager();
		List<Playlist> allDetails = em.createQuery("SELECT p FROM Playlist p").getResultList();
		return allDetails;
	}

	public void deletePlaylist(Playlist toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Playlist> typedQuery = em.createQuery("select pl from Playlist pl where pl.id = :selectedId", Playlist.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getPlaylistId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Playlist result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Playlist searchForPlaylistById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Playlist found = em.find(Playlist.class, tempId);
		em.close();
		return found;
	}

	public void updatePlaylist(Playlist toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
