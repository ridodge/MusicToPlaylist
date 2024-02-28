package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Spencer Tramontina - srtramontina
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

@Entity
@Table(name="playlist")
public class Playlist {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String playlistName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Listener listener;
	@OneToMany(cascade=CascadeType.MERGE, fetch= FetchType.EAGER)
	private List<Song> songs;
	
	
	public Playlist() {
	}

	public Playlist(String playlistName, Listener listener, List<Song> songs) {
		this.playlistName = playlistName;
		this.listener = listener;
		this.songs = songs;
	}

	
	public int getPlaylistId() {
		return id;
	}

	public void setPlaylistId(int playlistId) {
		this.id = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public Listener getListener() {
		return this.listener;
	}

	public void setPlaylistCreator(Listener l) {
		this.listener = l;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + id + ", playlistName=" + playlistName + ", Listener="
				+ listener + ", songs=" + songs + "]";
	}
	
}
