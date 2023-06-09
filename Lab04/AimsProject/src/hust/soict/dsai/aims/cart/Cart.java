package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public float totalCost() {
		float cost = 0;
		for (Media obj: itemsOrdered) {
			cost += obj.getCost();
		}
		return cost;
	}
	
	public ArrayList<Media> getItemsOrdered(){
		return this.itemsOrdered;
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (itemsOrdered.contains(media)) {
				System.out.println("The media " + media.getTitle() + " is already in the cart");
			} else {
				itemsOrdered.add(media);
				System.out.println("Add " + media.getTitle() + " to the cart");
			}
		} else {
			System.out.println("Cart has been full");
		}
	}
	
	public void addMedia(Media[] media) {
		for (int i = 0; i < media.length; i++) {
			if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				if (itemsOrdered.contains(media[i])) {
					System.out.println("The media " + media[i].getTitle() + " is already in the cart");
				} else {
					itemsOrdered.add(media[i]);
					System.out.println("Add " + media[i].getTitle() + " to the cart");
				}
			}
			else {
				System.out.println("Cart has been full");
				}
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Remove " + media.getTitle() + " from the cart");
		} else {
			System.out.println("The media " + media.getTitle() + " is not in the cart");
		}
	}
	
	public void searchId(int id) {
		for (Media media: itemsOrdered) {
			if (media.getId() == id) {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					System.out.println(dvd.toString());
					return;
				} else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					System.out.println(cd.toString());
					return;
				} else if (media instanceof Book) {
					Book b = (Book) media;
					System.out.println(b.toString());
					return;
				}
			}
		}
		System.out.println("Can not found");
		return;
	}
	
	public void searchTitle(String title) {
		for (Media media: itemsOrdered) {
			if (media.getTitle().equals(title)) {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					System.out.println(dvd.toString());
					return;
				} else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					System.out.println(cd.toString());
					return;
				} else if (media instanceof Book) {
					Book b = (Book) media;
					System.out.println(b.toString());
					return;
				}
			}
		}
		System.out.println("Can not found");
		return;
	}


	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	
	
}
