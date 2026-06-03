package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    // Default constructor
    public Book() {
        super();
    }

    // Parameterized constructor passing attributes to Media
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    // Add author method with English console messages
    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Invalid author name!");
            return;
        }
        if (authors.contains(authorName)) {
            System.out.println("The author \"" + authorName + "\" is already in the list.");
        } else {
            authors.add(authorName);
            System.out.println("The author \"" + authorName + "\" has been added successfully.");
        }
    }

    // Remove author method with English console messages
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author \"" + authorName + "\" has been removed from the list.");
        } else {
            System.out.println("The author \"" + authorName + "\" is not found in the list.");
        }
    }
    // Ghi đè phương thức hiển thị thông tin sách dưới dạng chuỗi
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - "
                + this.getCategory() + " - Authors: "
                + this.getAuthors() + ": "
                + this.getCost() + " $";
    }
}