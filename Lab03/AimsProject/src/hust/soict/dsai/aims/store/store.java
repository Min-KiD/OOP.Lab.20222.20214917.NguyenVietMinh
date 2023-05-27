package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class store {
	private DigitalVideoDisc[] itemInStore = new DigitalVideoDisc[100000];
	private int NumDVD = 0;
	
	public DigitalVideoDisc[] getItemInStore() {
		return itemInStore;
	}

	public int getNumDVD() {
		return NumDVD;
	}

	public void addDVD(DigitalVideoDisc disc) {
		itemInStore[NumDVD] = disc;
		NumDVD++;
		System.out.println("The disc " + disc.getTitle() + " has been added to store");
	}
	
	public void addDVD(DigitalVideoDisc[] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			itemInStore[NumDVD] = dvdList[i];
			NumDVD++;
			System.out.println("The disc " + dvdList[i].getTitle() + " has been added to store");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		int indexRemove = -1;
		for (int i = 0; i < NumDVD; i++) {
			if (itemInStore[i].equals(disc)){
				indexRemove = i;
				break;
			}
		}
		
		if (indexRemove != -1) {
		    DigitalVideoDisc[]copy = new DigitalVideoDisc[100000];
		    System.arraycopy(itemInStore, 0, copy, 0, indexRemove);
		    System.arraycopy(itemInStore, indexRemove + 1, copy, indexRemove, 100000 - indexRemove - 1);
		    this.itemInStore = copy;
		    NumDVD--;
		    
		    System.out.println("The disc " + itemInStore[indexRemove].getTitle() + " has been removed from store");
		} else {
		    System.out.println("Disc not found");
		}
	}
	
	public void print() {
		System.out.println("**********************STORE**********************");
		System.out.println("Items In Store:");
		for (int i = 1; i <= NumDVD; i++) {
			System.out.println(String.format("%d", i) + "." + itemInStore[i-1].toString());
		}
		System.out.println("*************************************************");
	}
	
}