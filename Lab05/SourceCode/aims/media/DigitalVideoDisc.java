package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Thuộc tính static dùng để đếm số lượng đĩa để tự sinh ID
    private static int nbDigitalVideoDiscs = 0;

    // Hàm bổ trợ tăng và trả về ID tiếp theo
    private static int nextId() {
        nbDigitalVideoDiscs++;
        return nbDigitalVideoDiscs;
    }

    // --- Các Constructor (Hàm khởi tạo) ---

    // Khởi tạo theo Tiêu đề
    public DigitalVideoDisc(String title) {
        super(nextId(), title, null, 0.0f, null, 0);
    }

    // Khởi tạo theo Danh mục, Tiêu đề và Giá
    public DigitalVideoDisc(String title, String category, float cost) {
        super(nextId(), title, category, cost, null, 0);
    }

    // Khởi tạo theo Đạo diễn, Danh mục, Tiêu đề và Giá
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(nextId(), title, category, cost, director, 0);
    }

    // Khởi tạo đầy đủ tất cả các thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nextId(), title, category, cost, director, length);
    }

    // Hiện thực hóa phương thức play() từ Interface Playable
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    // Ghi đè phương thức hiển thị thông tin DVD
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getDirector() + " - "
                + this.getLength() + ": "
                + this.getCost() + " $";
    }

}