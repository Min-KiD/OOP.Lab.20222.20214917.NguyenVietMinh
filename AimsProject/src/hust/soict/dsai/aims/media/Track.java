package hust.soict.dsai.aims.media;

import java.awt.Component;
import javax.swing.*;

public class Track implements Playable {
	
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}


	public int getLength() {
		return length;
	}


	public Track(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this(title);
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			if ((this.title == track.getTitle()) && (this.length == track.getLength())) {
				return true;
			}
		}
		return false;
	}
	
	public Component getMediaComponent() {
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("CD Playback"));
        return panel;
    }

}
