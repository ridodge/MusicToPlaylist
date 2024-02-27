/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 26, 2024
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Listener;

/**
 * 
 */
public class ListenerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertListener(Listener l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public List<Listener> showAllDrivers() {
		EntityManager em = emfactory.createEntityManager();
		List<Listener> allListeners = em.createQuery("SELECT l FROM Listener l").getResultList();
		return allListeners;
	}

	public Listener findListener(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Listener> typedQuery = em.createQuery("select l from listner l where l.listenerName = :selectedName",
				Listener.class);

		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);

		Listener foundListener;
		try {
			foundListener = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundListener = new Listener(nameToLookUp);
		}
		em.close();
		return foundListener;
	}

}
