package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    // Sức chứa tối đa của giỏ hàng (nếu muốn giới hạn, hoặc để động hoàn toàn)
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Thay thế mảng cũ bằng ArrayList chứa đối tượng Media
    private List<Media> itemsOrdered = new ArrayList<Media>(); //

    // Constructor mặc định
    public Cart() {
        super();
    }

    // Phương thức thêm một sản phẩm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add a null item to the cart.");
            return;
        }
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add more items.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the cart.");
        }
    }

    // Phương thức xóa một sản phẩm Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not found in the cart.");
        }
    }

    // Tính tổng số tiền trong giỏ hàng áp dụng tính Đa hình
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost(); // Hàm getCost() tự động chạy đúng theo từng lớp con
        }
        return total;
    }

    // In danh sách giỏ hàng ra màn hình để kiểm tra công khai
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    public void search(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item: " + media.toString());
                found = true;
                break; // Vì ID là duy nhất nên tìm thấy là dừng vòng lặp luôn
            }
        }
        if (!found) {
            System.out.println("No item found with ID: " + id);
        }
    }
    /**
     * Tìm kiếm sản phẩm trong giỏ hàng theo Tiêu đề (chứa từ khóa)
     */
    public void search(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid search title!");
            return;
        }

        boolean found = false;
        // Duyệt qua giỏ hàng để tìm sản phẩm có tiêu đề chứa từ khóa người dùng nhập
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                System.out.println("Found item: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with title containing: \"" + title + "\"");
        }
    }
    // Thêm vào file Cart.java nếu bị báo lỗi đỏ ở Controller
    // Thêm hàm này vào file Cart.java của bạn để lấy danh sách itemsOrdered ra giao diện
    public java.util.ArrayList<Media> getItemsInCart() {
        return (ArrayList<Media>) this.itemsOrdered;
    }
}