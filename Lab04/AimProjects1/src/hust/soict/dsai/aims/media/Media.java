package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Định nghĩa các Comparator làm thuộc tính static hằng số
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return this.title != null && this.title.equalsIgnoreCase(media.getTitle());
    }

    @Override
    public String toString() {
        return "Media [ID=" + id + ", Title=" + title + ", Category=" + category + ", Cost=" + cost + "$]";
    }
}