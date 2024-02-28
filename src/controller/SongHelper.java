/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 25, 2024
 */


package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Song;

/**
 * 
 */
public class SongHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Music");

	public void insertItem(Song si) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(si);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Song> showAllItems() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Song> allItems = em.createQuery("SELECT i FROM Song i").getResultList();
		return allItems;
	}

	public void deleteItem(Song toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Song> typedQuery = em.createQuery(
				"SELECT li FROM ListItem li WHERE li.make = :selectedMake and li.model = :selectedModel",
				Song.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedArtist", toDelete.getArtist());
		typedQuery.setMaxResults(1);
		Song result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * @param toEdit
	 */
	public void updateItem(Song toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Song searchForSongById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Song found = em.find(Song.class, idToEdit);
		em.close();
		return found;
		}

	/**
	 * @param itemName
	 * @return
	 */
	public List<Song> searchForItemByTitle(String titleName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Song> typedQuery = em.createQuery("select si from Song si where si.title = :selectedTitle", Song.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<Song> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Song> searchForItemByArtist(String artistName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Song> typedQuery = em.createQuery("select si from Song si where si.artist = :selectedArtist",
				Song.class);
		typedQuery.setParameter("selectedArtist", artistName);
		List<Song> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Song> searchForItemByGenre(String genreName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Song> typedQuery = em.createQuery("select si from Song si where si.genre = :selectedGenre",
				Song.class);
		typedQuery.setParameter("selectedGenre", genreName);
		List<Song> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

		public void cleanUp(){
		emfactory.close();
		}
	

}

