package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() { return authors; }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả '" + authorName + "' đã tồn tại trong danh sách.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả: " + authorName);
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Tác giả: " + authors + " - Giá: " + getCost() + "$";
    }
}