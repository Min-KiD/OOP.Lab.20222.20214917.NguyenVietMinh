package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.store;

public class StoreTest {
	public static void main(String[] args) {
		store Store = new store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Cinderella");
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4};
		Store.addDVD(dvdList);
		Store.addDVD(dvd5);
		Store.removeDVD(dvd2);
		Store.print();
	}
}