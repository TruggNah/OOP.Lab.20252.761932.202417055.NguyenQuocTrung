package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class AimsScreen {
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Nạp dữ liệu mẫu vào cửa hàng để test giao diện
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new Book(2, "Java Programming", "Technology", 45.5f));
        store.addMedia(new CompactDisc(3, "Greatest Hits", "Music", 15.0f, "Various Artists", "Michael Jackson"));

        // Khởi động hiển thị màn hình Store đầu tiên
        openStoreScreen();
    }

    public static void openStoreScreen() {
        if (cartScreen != null) {
            cartScreen.setVisible(false);
        }
        // Tạo mới hoặc hiển thị lại StoreScreen với dữ liệu store hiện tại
        storeScreen = new StoreScreen(store);
    }

    public static void openCartScreen() {
        if (storeScreen != null) {
            storeScreen.setVisible(false);
        }
        // Tạo mới CartScreen với dữ liệu cart hiện tại
        cartScreen = new CartScreen(cart);
    }

    public static Cart getCart() {
        return cart;
    }

    public static Store getStore() {
        return store;
    }
}