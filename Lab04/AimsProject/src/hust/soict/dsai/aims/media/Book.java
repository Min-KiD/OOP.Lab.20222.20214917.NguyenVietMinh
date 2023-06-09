package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)){
			System.out.println("Already have");
		} else {
			authors.add(authorName);
			System.out.println("Have been added");
		}
	}
	
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)){
			authors.remove(authorName);
			System.out.println("Have been removed");
		} else {
			System.out.println("Not have");
		}
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

}
