package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    // Các thuộc tính chung được gom lên lớp cha
    private int id;
    private String title;
    private String category;
    private float cost;
    private int length;

    // Constructor không tham số
    public Media() {
        super();
    }

    // Constructor đầy đủ tham số để các lớp con gọi qua super()
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Các phương thức Getter công khai (Accessors)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }
    public  int getLength() { return length; }

    // Phương thức Setter (chỉ tạo khi thực sự cần thay đổi thuộc tính)
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }
    public void setId(int id) { this.id = id; }
    public void setLength(int length) { this.length = length; }

    @Override
    public boolean equals(Object obj) {
        // Nếu hai biến cùng trỏ vào 1 ô nhớ thì chắc chắn bằng nhau
        if (this == obj) {
            return true;
        }

        // Nếu đối tượng truyền vào bị null hoặc không phải là một thực thể của Media
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }

        // Ép kiểu (Downcasting) đối tượng Object về kiểu Media để truy cập thuộc tính
        Media other = (Media) obj;

        // Trả về kết quả so sánh chuỗi tiêu đề (bỏ qua chữ hoa chữ thường hoặc so sánh chính xác)
        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equalsIgnoreCase(other.title);
    }
}