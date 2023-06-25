package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.cart.*;

public abstract class AddToStoreScreen extends JFrame {
	private store store;
	private Cart cart;
	
	public store getStore() {
		return store;
	}


	public Cart getCart() {
		return cart;
	}


	public AddToStoreScreen(store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
}
