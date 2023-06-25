package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class store {
	private ArrayList<Media> itemsInStore= new ArrayList<Media>();
	private int NumMedia = 0;

	public int getNumDVD() {
		return NumMedia;
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media " + media.getTitle() +  " is already in the store");
		} else {
			itemsInStore.add(media);
			NumMedia++;
			System.out.println("Successfully added " + media.getTitle() + " to the store");
		}
	}
	
	public void addMedia(Media[] media) {
		for (int i = 0; i < media.length; i++) {
			if (itemsInStore.contains(media[i])) {
				System.out.println("The media " + media[i].getTitle() + " is already in the store");
			} else {
				itemsInStore.add(media[i]);
				System.out.println("Added " + media[i].getTitle() + " to the store");
			}
			NumMedia++;
		}
	}
	
		
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Successfully removed " + media.getTitle() + " from store");
		} else {
			System.out.println("The media " + media.getTitle() + " is not in store");
		}
	}
	
	public void print() {
		System.out.println("**********************STORE**********************");
		System.out.println("Items In Store:");
		for (Media media: itemsInStore) {
			System.out.println(media.toString());
		}
		System.out.println("*************************************************");
	}

}