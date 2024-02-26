package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private int playlistId;
	@Column(name="NAME")
	private String playlistName;
	@Column(name="CREATOR")
	private String playlistCreator;
	@OneToMany(cascade=CascadeType.MERGE, fetch= FetchType.EAGER)
	private List<Song> songs;
	
	
	public Playlist() {
	}

	public Playlist(String playlistName, String playlistCreator, List<Song> songs) {
		this.playlistName = playlistName;
		this.playlistCreator = playlistCreator;
		this.songs = songs;
	}

	
	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public String getPlaylistCreator() {
		return playlistCreator;
	}

	public void setPlaylistCreator(String playlistCreator) {
		this.playlistCreator = playlistCreator;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", playlistName=" + playlistName + ", playlistCreator="
				+ playlistCreator + ", songs=" + songs + "]";
	}
	
}
