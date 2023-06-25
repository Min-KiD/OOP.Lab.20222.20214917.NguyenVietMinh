package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;

	public MediaStore(Media media) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btnListener = new ButtonListener();
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(btnListener);
		container.add(addToCartButton);
		
		if (media instanceof Playable) {
			ButtonListenerPlay btnPlayListener = new ButtonListenerPlay();
			JButton playButton = new JButton("Play");
			playButton.addActionListener(btnPlayListener);
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
            addToCart();
        }
	}
	
	private class ButtonListenerPlay implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			playMedia();
        }
	}
	
	private void addToCart() {
        Cart cart = new Cart();
		cart.addMedia(media);
    }
	
	private void playMedia() {
	    if (media instanceof Playable) {
	        Playable playableMedia = (Playable) media;
	        
	        JDialog dialog = new JDialog();
	        dialog.setTitle("Media Playback");
	        dialog.setSize(400, 300);
	        dialog.setLocationRelativeTo(null); // Center the dialog on the screen

	        JLabel titleLabel = new JLabel(media.getTitle());
	        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

	        JButton stopButton = new JButton("Stop");
	        stopButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dialog.dispose(); 
	            }
	        });

	        dialog.setLayout(new BorderLayout());
	        dialog.add(titleLabel, BorderLayout.NORTH);
	        dialog.add(playableMedia.getMediaComponent(), BorderLayout.CENTER);
	        dialog.add(stopButton, BorderLayout.SOUTH);

	        dialog.setVisible(true);
	    }
	}

}
