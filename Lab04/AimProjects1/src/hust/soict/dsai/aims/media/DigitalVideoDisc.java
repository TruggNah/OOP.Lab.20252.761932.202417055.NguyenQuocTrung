package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Lỗi: DVD '" + this.getTitle() + "' không thể phát do độ dài <= 0!");
            return;
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Đạo diễn: " + getDirector() + " - Thời lượng: " + getLength() + " phút - Giá: " + getCost() + "$";
    }
}