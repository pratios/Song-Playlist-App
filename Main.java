package com.music;

import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Album album = new Album("Folklore", "Taylor Swift");
		album.addSong("Epiphany", 3.32);
		album.addSong("Invisible string", 3.43);
		album.addSong("Peace", 3.23);
		album.addSong("Hoax", 2.44);
		albums.add(album);
		
		album = new Album("Hopeless fountain kingdom", "Halsey");
		album.addSong("Bad at love", 3.22);
		album.addSong("Hopeless", 3.34);
		albums.add(album);
		
		LinkedList<Song> PlayList1 = new LinkedList<>();
		
		albums.get(0).addToPlaylist("Epiphany", PlayList1);
		albums.get(0).addToPlaylist("Peace", PlayList1);
		albums.get(1).addToPlaylist("Hopeless", PlayList1);
		albums.get(1).addToPlaylist("Bad at Love", PlayList1);
		
		play(PlayList1);
	}
		
		private static void play(LinkedList<Song> playList) 
		{
			Scanner sc = new Scanner(System.in);
			boolean quit = false;
			boolean forward = true;
			ListIterator<Song> listIterator = playList.listIterator();
			
			if(playList.size()==0)
				System.out.println("Empty playlist.");
			else {
				System.out.println("Now playing : "+listIterator.next().toString());
				printMenu();
			}
			
			while(!quit) 
			{
				int action = sc.nextInt();
				sc.nextLine();
				
				switch(action) 
				{
				case 0:
					System.out.println("Playlist Complete");
					quit = true;
					
				case 1 :
					if(!forward) {
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						forward = true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now playing : "+listIterator.next().toString());
					}else {
						System.out.println("We have reached to the end of the list");
						forward = false;
					}
					break;
					
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false; 
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing : "+listIterator.previous().toString());
					}else {
						System.out.println("This is the first song");
						forward = false;
					}
					break;
					
				case 3:
					if(forward) 
					{
						if(listIterator.hasPrevious()) 
						{
							listIterator.previous();
							forward = false;
						}else 
						{
							System.out.println("We're at the start of the list.");
						}
					}
					else 
					{
						if(listIterator.hasNext()) 
						{
						System.out.println("Now playing : "+listIterator.next().toString());
						forward = true;
						}else 
						{
						System.out.println("This is the end of list.");
						forward = false;
						}
					}
					break;
					
				case 4:
					printList(playList);
					break;
				
				case 5:
					printMenu();
					break;
					
				case 6:
					if(playList.size()>0)
					{
						listIterator.remove();
						if(listIterator.hasNext())
						{
							System.out.println("Now playing : "+listIterator.next().toString());
						}
						else 
						{
							if(listIterator.hasPrevious()) 
							{
								System.out.println("Now playing : "+listIterator.previous().toString());
							}else 
							{
								System.out.println("We're at the start of the list.");
							}
							
						}
					}
					else
					{
						System.out.println("There is no song to delete in the list.");
					}
					break;
				}
				}
			
		}
		
		private static void printMenu()
		{
			System.out.println("\n0. Quit\n1.Play next song\n2.Play previous song\n3.Replay current song\n4.List of songs\n5.Print all available options \n6.Delete current song");
		}
		
		private static void printList(LinkedList<Song> playList) 
		{
			Iterator<Song> iterator = playList.iterator();
			System.out.println("-----------------------------------");
			
			while(iterator.hasNext()) 
			{
				System.out.println(iterator.next());
			}
			System.out.println("-----------------------------------");
		}
	}
