package hust.soict.dsai.aims.media;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, float cost) {
		super(title, cost);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public Component getMediaComponent() {
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("DVD Playback"));
        return panel;
    }
	
}
