package com.music;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String album;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String album, String artist) {
		super();
		this.album = album;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	public Song findSong(String title)
	{
		for(Song checkedSong : songs)
			if(checkedSong.getTitle().equals(title))
				return checkedSong;
		
		return null;
	}
	
	public boolean addSong(String title, double duration) {
		if (findSong(title) == null)
		{
			songs.add(new Song(title, duration));
			//System.out.println(title + " is added to the album successfully!");
			return true;
		}
		else {
			System.out.println("This song already exists.");
			return false;
		}
	}
	
	public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber-1;
		if(index>0 && index<=this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}else {
			System.out.println("This album does not have song with track number "+trackNumber);
			return false;
		}
	}
	
	public boolean addToPlaylist(String title, LinkedList<Song> PlayList) {
		for(Song checkedSong : this.songs)
			if(checkedSong.getTitle().equals(title))
			{
				PlayList.add(checkedSong);
				return true;
			}
		//System.out.println("There is no such song as "+title+"in album");
		return false;
	}
}
