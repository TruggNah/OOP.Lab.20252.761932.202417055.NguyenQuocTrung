package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // 1. Khởi tạo một cửa hàng mới (đã nâng cấp sang ArrayList<Media>)
        Store store = new Store();

        // 2. Tạo các đĩa DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", null, 0, 18.99f);

        // 3. Kiểm thử tính năng thêm đĩa vào cửa hàng
        System.out.println("--- Testing Adding to Store ---");
        // THAY ĐỔI: Chuyển sang dùng hàm addMedia() mới
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // In ra danh sách kho để kiểm tra
        store.printStore();

        // 4. Kiểm thử tính năng xóa đĩa khỏi cửa hàng
        System.out.println("\n--- Testing Removing from Store ---");
        // THAY ĐỔI: Chuyển sang dùng hàm removeMedia() mới
        store.removeMedia(dvd2); // Xóa Star Wars thành công

        // In lại danh sách kho sau khi xóa
        store.printStore();

        // Thử xóa một đĩa không tồn tại (hoặc đã xóa rồi) để test thông báo lỗi
        store.removeMedia(dvd2);
    }
}