package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Spencer Tramontina - srtramontina
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */
@Entity
@Table(name="listener")
public class Listener {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int listenerId;
	@Column(name="NAME")
	private String listenerName;
	
	
	public Listener() {
	}

	public Listener(String listenerName) {
		this.listenerName = listenerName;
	}

	
	public int getListenerId() {
		return listenerId;
	}

	public void setListenerId(int listenerId) {
		this.listenerId = listenerId;
	}

	public String getListenerName() {
		return listenerName;
	}

	public void setListenerName(String listenerName) {
		this.listenerName = listenerName;
	}

	@Override
	public String toString() {
		return "Listener [listenerId=" + listenerId + ", listenerName=" + listenerName + "]";
	}
	
}
