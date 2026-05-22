package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() { return itemsInStore; }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào cửa hàng.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã có sẵn trong cửa hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm \"" + media.getTitle() + "\" trong cửa hàng.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("\n========== CỬA HÀNG (STORE) ==========");
        if (itemsInStore.isEmpty()) {
            System.out.println("[Trống]");
        } else {
            for (Media m : itemsInStore) {
                System.out.println(m.toString());
            }
        }
        System.out.println("======================================");
    }
}