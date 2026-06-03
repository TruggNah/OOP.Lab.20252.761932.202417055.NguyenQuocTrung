package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreenTest {
    public static void main(String[] args) {
        // 1. Tạo một kho hàng mới
        Store store = new Store();

        // 2. Nạp dữ liệu mẫu đa hình vào kho hàng (Đã sửa khớp hoàn toàn cấu trúc constructor của bạn)
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));

        // Thêm Book: Book(id, title, category, cost)
        store.addMedia(new Book(2, "Java Programming", "Technology", 45.5f));

        // THAY ĐỔI: Thêm CD theo đúng thứ tự: id, title, category, cost, director, artist của bạn
        store.addMedia(new CompactDisc(3, "Greatest Hits", "Music", 15.0f, "Various Artists", "Michael Jackson"));

        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));

        // 3. Khởi chạy màn hình giao diện đồ họa StoreScreen bằng Swing
        new StoreScreen(store);
    }
}