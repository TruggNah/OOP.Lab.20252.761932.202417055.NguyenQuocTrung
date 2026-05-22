package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào giỏ hàng.");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã tồn tại trong giỏ hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi giỏ hàng.");
        } else {
            System.out.println("Sản phẩm không có trong giỏ hàng.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tên (Title -> Cost).");
    }

    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá (Cost -> Title).");
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public void printCart() {
        System.out.println("\n========== GIỎ HÀNG HIỆN TẠI ==========");
        if (itemsOrdered.isEmpty()) {
            System.out.println("[Trống]");
        } else {
            for (Media m : itemsOrdered) {
                System.out.println(m.toString());
            }
            System.out.println("-> Tổng chi phí: " + totalCost() + "$");
        }
        System.out.println("=======================================");
    }
}