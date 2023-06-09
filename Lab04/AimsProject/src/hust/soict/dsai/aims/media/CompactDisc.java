package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks;

	public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
	
	public CompactDisc(String title, String artist, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}

	public void addTrack(Track trackName) {
		if (tracks.contains(trackName)) {
			System.out.println("The disc already has this track");
		} else {
			tracks.add(trackName);
		}
	}
	
	public void removeTrack(Track trackName) {
		if (tracks.contains(trackName)) {
			tracks.remove(trackName);
		} else {
			System.out.println("The disc do not have this track");
		}
	}
	
	@Override
	public int getLength() {
		int len = 0;
		for (Track element: tracks) {
			len += element.getLength();
		}
		return len;
	}
	
	public void play() {
		System.out.println("CD artist: " + this.artist);
		System.out.println("Total length: " + this.getLength());
		for (Track track: tracks) {
			System.out.println("Playing track: " + track.getTitle());
			System.out.println("Track length: " + track.getLength());
		}
	}

}
