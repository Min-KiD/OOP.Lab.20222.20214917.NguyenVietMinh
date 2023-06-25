package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.store.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private store store;
	private Cart cart;
	
	public CartScreen(store store, Cart cart) {
		super();

		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
				CartScreenController controller = new CartScreenController(store, cart);
				controller.setWindow(SwingUtilities.getWindowAncestor(fxPanel));
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
//	public static void main(String[] args) {
//		Cart cart = new Cart();
//		cart.addMedia(new Book("Book 2", "Gay", 12.0f));
//        cart.addMedia(new CompactDisc("CD 2", "Spider Man", 11.0f));
//        cart.addMedia(new DigitalVideoDisc("DVD 2", "Rider", 21.0f));
//		new CartScreen(cart);
		

	}
	
	

}

