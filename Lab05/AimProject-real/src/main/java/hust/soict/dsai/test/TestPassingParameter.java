package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // Khởi tạo 2 đĩa DVD mẫu
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "Adventure", "Director A", 90, 15.5f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Fairytale", "Director B", 120, 19.9f);

        // 1. Thử nghiệm hàm swap (Tráo đổi ruột dữ liệu)
        System.out.println("--- Testing Swap ---");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());       // Kỳ vọng: Cinderella
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle()); // Kỳ vọng: Jungle

        // 2. Thử nghiệm hàm changeTitle gốc từ bài Lab
        System.out.println("\n--- Testing Change Title ---");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());       // Kỳ vọng: Tùy thuộc vào logic hàm
    }

    /**
     * Hàm swap chính xác: Tráo đổi toàn bộ dữ liệu bên trong của hai vùng nhớ đối tượng
     */
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (dvd1 == null || dvd2 == null) return;

        // Sao lưu toàn bộ thuộc tính của dvd1 sang biến tạm
        String tmpTitle = dvd1.getTitle();
        String tmpCategory = dvd1.getCategory();
        String tmpDirector = dvd1.getDirector();
        int tmpLength = dvd1.getLength();
        float tmpCost = dvd1.getCost();

        // Gán dữ liệu của dvd2 vào dvd1
        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());

        // Gán dữ liệu tạm (của dvd1 cũ) vào dvd2
        dvd2.setTitle(tmpTitle);
        dvd2.setCategory(tmpCategory);
        dvd2.setDirector(tmpDirector);
        dvd2.setLength(tmpLength);
        dvd2.setCost(tmpCost);
    }

    /**
     * Hàm đổi tiêu đề gốc trong bài Lab (Để chứng minh cơ chế Pass-by-value)
     */
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // Dòng này làm thay đổi title của vật thể thật ngoài bộ nhớ

        // Dòng này tạo một vật thể mới hoàn toàn và gán cho biến cục bộ 'dvd'.
        // Sau khi hàm kết thúc, biến cục bộ mất đi, vật thể mới này bị dọn rác và không ảnh hưởng gì tới biến truyền vào ở hàm main.
        dvd = new DigitalVideoDisc(oldTitle);
    }
}