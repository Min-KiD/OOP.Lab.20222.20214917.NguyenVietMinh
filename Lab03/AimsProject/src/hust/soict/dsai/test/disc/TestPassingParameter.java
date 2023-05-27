package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		swap(dvd1, dvd2);
		System.out.println("The lion king dvd title: " + dvd1.toString());
		System.out.println("star wars dvd title: " + dvd2.toString());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    DigitalVideoDisc tmp = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());
	    dvd1.setTitle(dvd2.getTitle());
	    dvd1.setCategory(dvd2.getCategory());
	    dvd1.setDirector(dvd2.getDirector());
	    dvd1.setLength(dvd2.getLength());
	    dvd1.setCost(dvd2.getCost());
	    dvd2.setTitle(tmp.getTitle());
	    dvd2.setCategory(tmp.getCategory());
	    dvd2.setDirector(tmp.getDirector());
	    dvd2.setLength(tmp.getLength());
	    dvd2.setCost(tmp.getCost());
	   	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}