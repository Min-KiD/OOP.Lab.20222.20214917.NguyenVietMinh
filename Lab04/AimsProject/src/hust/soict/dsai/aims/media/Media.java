package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	private int id;
	private String category;
	private String title;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media(String title) {
		this.title = title;
	}

	public Media(String title, String category, float cost) {
		this(title);
		this.category = category;
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media media = (Media) o;
			if (this.title == media.getTitle()) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
