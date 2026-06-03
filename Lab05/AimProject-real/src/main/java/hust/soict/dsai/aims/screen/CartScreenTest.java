package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartScreenTest {
    public static void main(String[] args) {
        // 1. Khởi tạo một giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo và nạp các sản phẩm mẫu vào giỏ hàng để hiển thị lên bảng
        // Khởi tạo DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd);

        // Khởi tạo Book: Book(id, title, category, cost) theo đúng constructor của bạn
        Book book = new Book(2, "Java Programming", "Technology", 45.5f);
        cart.addMedia(book);

        // Khởi tạo CD: CompactDisc(id, title, category, cost, director, artist) theo đúng constructor của bạn
        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.0f, "Various Artists", "Michael Jackson");
        cart.addMedia(cd);

        // 3. Khởi chạy màn hình Giỏ hàng đồ họa
        new CartScreen(cart);
    }
}