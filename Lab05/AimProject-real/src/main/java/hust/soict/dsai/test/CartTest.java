package hust.soict.dsai.test;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới (đã nâng cấp sang ArrayList<Media>)
        Cart cart = new Cart();

        // Tạo các đĩa DVD mẫu (Lúc này ID sẽ tự động tăng từ 1 đến 3)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", null, 0, 18.99f);

        // THAY ĐỔI: Chuyển sang dùng hàm addMedia() mới để thêm sản phẩm
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3); // Thêm đĩa thứ 3

        // 1. Kiểm thử phương thức in hóa đơn giỏ hàng
        System.out.println("\n--- Testing Print Method ---");
        cart.print();

        // 2. Kiểm thử phương thức tìm kiếm theo ID (Đã hết lỗi đỏ sau khi thêm hàm search vào Cart.java)
        System.out.println("\n--- Testing Search by ID ---");
        cart.search(2);  // Mong đợi: Tìm thấy Star Wars (ID = 2)
        cart.search(5);  // Mong đợi: Thông báo không tìm thấy

        // 3. Kiểm thử phương thức tìm kiếm theo Title
        System.out.println("\n--- Testing Search by Title ---");
        cart.search("Lion");   // Mong đợi: Tìm thấy The Lion King
        cart.search("Avatar"); // Mong đợi: Thông báo không tìm thấy
    }
}