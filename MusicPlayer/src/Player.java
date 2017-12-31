import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Player {
	private ArrayList<Album> albums;
	private LinkedList<Song> playlist;
	
	public Player() {
		this.albums = new ArrayList<Album>();
		this.playlist = new LinkedList<Song>();
	}
	
	public ArrayList<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}
	public LinkedList<Song> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(LinkedList<Song> playlist) {
		this.playlist = playlist;
	}
	

	public void addAlbum(){
		Scanner console1 = new Scanner(System.in);
		System.out.println("Enter album name: ");
		String name = console1.nextLine();
		System.out.println("Enter artist name: ");
		String artist = console1.nextLine();
		
		Album newAlbum = new Album(name,artist);
	
		boolean albumSearch = findAlbum(name);
		
		if(albumSearch) {
			System.out.println("This album already exists!");
		}

		if(!albumSearch) {
			this.albums.add(newAlbum);
		}
	}
	
	public void addSongToAlbum() {
		Scanner console1 = new Scanner(System.in);
		System.out.println("Enter song name: ");
		String name = console1.nextLine();
		System.out.println("Enter duration: ");
		double duration = console1.nextDouble();
		
		System.out.println("Which album would you like to add?");
		Scanner console = new Scanner(System.in);
		String response = console.nextLine();
		
		boolean albumSearch = findAlbum(response);
		
		if(albumSearch) {
			Album theAlbum = getTheAlbum(response);
			theAlbum.getSongs().add(new Song(name,duration));
			System.out.println("Song added successfully...");
		}
		
		if(!albumSearch) {
			System.out.println();
			System.out.println("This album does not exist...");
		}
	}
	
	public boolean findAlbum(String name){
				
		ListIterator<Album> myIter = this.albums.listIterator();
		
		
		while(myIter.hasNext()) {
			Album someAlbum = myIter.next();
			
			if(someAlbum.getAlbumName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Album getTheAlbum(String name) {
		ListIterator<Album> myIter = albums.listIterator();
		
		while(myIter.hasNext()) {
			Album someAlbum = myIter.next();
			
			if(someAlbum.getAlbumName().equals(name)) {
				return someAlbum;
			}
		}
		return null;
	}
	
	public void theAlbumDisplay() {
		ListIterator<Album> newIter = this.albums.listIterator();
		System.out.println("Your albums are as follows: ");
		int x = 1;
		while(newIter.hasNext()) {
			Album someAlbum = newIter.next();
			System.out.println(x + " " + someAlbum.getAlbumName() + " by " + someAlbum.getArtistName());
			x++;
		}
	} 
	
	public void printAlbum() {
		Scanner console1 = new Scanner(System.in);
		theAlbumDisplay();
		System.out.println("Enter album name which you would like to display: ");
		String name = console1.nextLine();
		
		boolean albumSearch = findAlbum(name);
		
		if(albumSearch) {
			Album theAlbum = getTheAlbum(name);
			ArrayList<Song> albumSongs = theAlbum.getSongs();
			ListIterator<Song> newIter = albumSongs.listIterator();
			
			if(albumSongs.isEmpty()) {
				System.out.println();
				System.out.println("This album has no songs in it...");
			}else {
				int x  = 0;
				while(newIter.hasNext()) {
					Song theSong = newIter.next();
					
					System.out.println(x + ". " + theSong.getName() + " which runs for " + theSong.getDuration() + " minutes.");
					x++;
				}
			}
		}
		
		if(!albumSearch) {
			System.out.println();
			System.out.println("This album does not exist...");
		}
		
	}
	
	
}



























