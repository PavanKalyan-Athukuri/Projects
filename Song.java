package model;

public class Song {
	private String artist;
    private String version;
    private String track;
    private String title;
    private String album;
    private String year;
	public Song(String artist, String version, String track, String title, String album,String year) {
		super();
		this.artist = artist;
		this.version = version;
		this.track = track;
		this.title = title;
		this.album = album;
		this.year = year;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	} 
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
    
}
