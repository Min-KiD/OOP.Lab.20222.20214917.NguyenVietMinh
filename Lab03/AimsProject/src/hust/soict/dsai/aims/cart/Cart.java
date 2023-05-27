package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[this.qtyOrdered] = disc;
			this.qtyOrdered ++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is already full");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			itemsOrdered[this.qtyOrdered] = dvdList[i];
			this.qtyOrdered++;
			System.out.println("The disc " + dvdList[i].getTitle() + " has been added");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean flag = false;
		for(int i = 0; i<this.qtyOrdered; i++) {
			if(itemsOrdered[i] == disc) {
				flag = true;
			}
			if(flag == true) {
				itemsOrdered[i] = itemsOrdered[i+1];
			}
		}
		if(flag == false) {
			System.out.println("Remove error, wrong name or cart have no one to remove");
		} else {
			itemsOrdered[this.qtyOrdered-1] = null;
			this.qtyOrdered--;
		}
	}
	public double totalCost() {
		double cost = 0;
		for(int i = 0; i<this.qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <= this.qtyOrdered; i++) {
			System.out.println(String.format("%d", i) + "." + itemsOrdered[i-1].toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
}
