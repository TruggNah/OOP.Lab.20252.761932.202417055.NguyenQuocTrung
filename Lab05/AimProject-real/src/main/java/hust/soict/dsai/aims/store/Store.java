package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

public class Store {
    // Thay thế mảng cũ bằng danh sách động ArrayList chứa Media
    private List<Media> itemsInStore = new ArrayList<Media>();

    // Constructor mặc định
    public Store() {
        super();
    }

    // Phương thức thêm sản phẩm vào cửa hàng
    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add a null item to the store.");
            return;
        }
        if (itemsInStore.contains(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }

    // Phương thức xóa sản phẩm khỏi cửa hàng (khi có khách mua hoặc hạ kệ)
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not found in the store.");
        }
    }

    // In toàn bộ danh sách sản phẩm hiện có tại cửa hàng
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("[Empty Store]");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }

    // --- THÊM HÀM NÀY VÀO ĐỂ HẾT LỖI ĐỎ Ở LỚP AIMS ---
    /**
     * Tìm kiếm sản phẩm trong cửa hàng dựa vào Tiêu đề (Title)
     * @param title Tiêu đề cần tìm
     * @return Đối tượng Media nếu tìm thấy trùng khớp, ngược lại trả về null
     */
    public Media searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return null;
        }

        // Duyệt qua từng sản phẩm Media đang có trên kệ của Store
        for (Media media : itemsInStore) {
            // So sánh tiêu đề (bỏ qua khoảng trắng thừa và không phân biệt hoa thường)
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                return media; // Tìm thấy thì trả về đối tượng đó ngay lập tức
            }
        }

        return null; // Trả về null nếu tìm hết danh sách mà không có sản phẩm nào khớp
    }

    public List<Media> getItemsInStore() {
        return this.itemsInStore;
    }
}