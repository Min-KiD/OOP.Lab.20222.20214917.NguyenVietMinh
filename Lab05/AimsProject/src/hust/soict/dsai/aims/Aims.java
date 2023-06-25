package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.store;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book;

public class Aims {
	
	private static store store = new store();
	private static Cart cart = new Cart();
	private static Scanner sc = new Scanner(System.in);

//	public static void main(String[] args) {
//		//Create a new cart
//		Cart anOrder = new Cart();
//		
//		//Create new dvd objects
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
//				"Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addMedia(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
//				"Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addMedia(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
//				"Animation", 18.99f);
//		anOrder.addMedia(dvd3);
//		
//		//print total cost of the items in the cart 
//		System.out.print("Total Cost is : ");
//		System.out.println(anOrder.totalCost());
//		
//		//Remove dvd object
//		anOrder.removeMedia(dvd3);
//		
//		System.out.print("Total Cost is : ");
//		System.out.println(anOrder.totalCost());
//		
//		ArrayList<Media> mediae = new ArrayList<Media>();
//		CompactDisc cd = new CompactDisc("Spider Man", "Tom Halland", "Super Heroes", "Marvel", 120, 10000);
//		Book book = new Book("Sherlock Holmes", "Detective", 20);
//		
//		mediae.add(cd);
//		mediae.add(dvd1);
//		mediae.add(book);
//		
//		for(Media m: mediae) {
//			System.out.println(m.toString());
//		}
//		
//		showMenu();
//		
//		
//	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			storeMenu();
		} else if (opt == 2) {
			updateStore();
		} else if (opt == 3) {
			cartMenu();
		} else if (opt == 0) {
			System.out.println("Successfully exit");
		} else {
			System.out.println("Option not exist");
		}
		
	}
	
	public static void storeMenu() {
		store.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int opt = sc.nextInt();
		sc.nextLine();
		if (opt == 1) {
			storeMenuOpt1();
		} else if (opt == 2) {
			storeMenuOpt2();
		} else if (opt == 3) {
			storeMenuOpt3();
		} else if (opt == 4) {
			cartMenu();
		} else if (opt == 0) {
			showMenu();
		} else {
			System.out.println("Error. Option not exist");
			showMenu();
		}
	}
	
	public static void storeMenuOpt1() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.nextLine();
		boolean findRes = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findRes = true;
				media.toString();
				mediaDetailsMenu(media);
			}
		}
		if (findRes == false) {
			System.out.println("This media is not in the store");
			storeMenu();
		}
	}
	
	public static void mediaDetailsMenu(Media media) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			cart.addMedia(media);
			storeMenu();
		} else if (opt == 2) {
			if (media instanceof CompactDisc){
				CompactDisc cd = (CompactDisc) media;
				cd.play();
			} else if (media instanceof DigitalVideoDisc){
				DigitalVideoDisc dvd = (DigitalVideoDisc) media;
				dvd.play();
			} else if (media instanceof Book) {
				System.out.println("Cannot play a book");
			}
			storeMenu();
		} else if (opt == 0) {
			storeMenu();
		}
	}
	
	public static void storeMenuOpt2() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.nextLine();
		boolean findRes = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findRes = true;
				cart.addMedia(media);
				System.out.println("Number of mediae in current cart: " + cart.getItemsOrdered().size());
			}
		}
		if (findRes == false) {
			System.out.println("This media is not in store");
		}
		storeMenu();
	}
	
	public static void storeMenuOpt3() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.nextLine();
		boolean findRes = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findRes = true;
				if (media instanceof CompactDisc){
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				} else if (media instanceof Book) {
					System.out.println("Cannot play this media as it is a book");
				}
			}
		}
		if (findRes == false) {
			System.out.println("This media is not in store");
		}
		storeMenu();
	}
	
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			updateStoreOpt1();
		} else if (opt == 2) {
			updateStoreOpt2();
		} else {
			showMenu();
		}
	}
	
	public static void updateStoreOpt1() {
		System.out.println("Enter the title of the media: ");
		String title = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the category of the media: ");
		String category = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the cost of the media: ");
		float cost = sc.nextFloat();

		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DigitalVideoDisc");
		System.out.println("3. CompactDisc");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		sc.nextLine();
		if (opt == 1) {
			Book newBook =  new Book(title, category, cost);
			store.addMedia(newBook);
		} else if (opt == 2) {
			DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, cost);
			store.addMedia(newDVD);
		} else if (opt == 3) {
			CompactDisc newCD = new CompactDisc(title, category, cost);
			store.addMedia(newCD);
		}
		updateStore();
	}
	
	public static void updateStoreOpt2() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.nextLine();
		boolean findRes = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findRes = true;
				store.removeMedia(media);
			}
		}
		if (findRes == false) {
			System.out.println("This media is not in the store");
		}
		updateStore();
	}
	
	public static void cartMenu() {
		cart.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			cartMenuOpt1();
		} else if (opt == 2) {
			cartMenuOpt2();
		} else if (opt == 3) {
			cartMenuOpt3();
		} else if (opt == 4) {
			cartMenuOpt4();
		} else if (opt == 5) {
			System.out.println("An order has been created");
			cart.getItemsOrdered().clear();
		} else if (opt == 0) {
			storeMenu();
		}
	}
	
	public static void cartMenuOpt1() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		sc.nextLine();
		if (opt == 1) {
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			cart.searchId(id);
			cartMenu();
		} else if (opt == 2) {
			System.out.println("Enter title: ");
			String title = sc.nextLine();
			cart.searchTitle(title);
			cartMenu();
		} else if (opt == 0) {
			cartMenu();
		}
	}
	
	public static void cartMenuOpt2() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
			cart.print();
			cartMenu();
		} else if (opt == 2) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
			cart.print();
			cartMenu();
		} else if (opt == 0) {
			cartMenu();
		}
	}
	
	public static void cartMenuOpt3() {
		System.out.println("Enter the title of the media want to remove: ");
		String mediaName = sc.nextLine();
		boolean findRes = false;
		for (Media media: cart.getItemsOrdered()) {
			if (media.getTitle().equals(mediaName)) {
				findRes = true;
				cart.removeMedia(media);
			}
		}
		if (findRes == false) {
			System.out.println("This media is not in the cart");
		}
		cartMenu();
	}
	
	public static void cartMenuOpt4() {
		System.out.println("Enter the title of the media want to play: ");
		String mediaName = sc.nextLine();
		boolean findingRes = false;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findingRes = true;
				if (media instanceof CompactDisc){
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				} else if (media instanceof Book) {
					System.out.println("Cannot play a book");
				}
			}
		}
		if (findingRes == false) {
			System.out.println("This media is not in the cart");
		}
		cartMenu();
	}
	
	public static void main(String[] args) throws DataConstraintsException, LimitExceededException, PlayerException {
		
		store mystore = new store();
		for (int i = 0; i < 9; i++) {
			mystore.addMedia(new DigitalVideoDisc(""+i));	
		}	
		
		Cart mycart = new Cart();
		for (int i = 0; i < 9; i++) {
			mycart.addMedia(new DigitalVideoDisc(""+i, ""+i+i, new Random().nextInt(1000)));			
		}
		mycart.addMedia(new Book("abc", "x", 0));	
		new StoreScreen(mystore, mycart);
		new CartScreen(mystore, mycart);
		
		new StoreScreen(mystore, mycart);
	}


}
