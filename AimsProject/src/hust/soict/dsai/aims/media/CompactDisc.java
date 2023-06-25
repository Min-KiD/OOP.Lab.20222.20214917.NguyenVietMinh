package hust.soict.dsai.aims.media;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc(String title, float cost) {
		super(title, cost);
	}

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

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
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
	
	@Override
	public Component getMediaComponent() {
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("CD Playback"));
        return panel;
    }

}
