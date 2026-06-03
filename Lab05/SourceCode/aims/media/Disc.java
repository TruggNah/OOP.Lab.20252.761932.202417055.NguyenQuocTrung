package hust.soict.dsai.aims.media;

public class Disc extends Media {
    // Thuộc tính riêng của các dòng sản phẩm dạng đĩa
    private String director;
    private int length;

    // Constructor không tham số
    public Disc() {
        super();
    }

    // Constructor đầy đủ tham số để truyền dữ liệu lên lớp cha Media
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost); // Đẩy thuộc tính chung lên Media
        this.director = director;
        this.length = length;
    }

    // Các hàm Getter công khai cho thuộc tính riêng của Disc
    public String getDirector() {
        return director;
    }

    // Hàm setter cho Đạo diễn
    public void setDirector(String director) {
        this.director = director;
    }

    // Hàm setter cho Thời lượng đĩa
    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}