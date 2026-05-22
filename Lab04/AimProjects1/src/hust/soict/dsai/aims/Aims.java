package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.util.Scanner.create(System.in, "UTF-8").useDelimiter("\n"));

    public static void main(String[] args) {
        // Khởi tạo một vài dữ liệu mẫu cho Store
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    viewStoreRoutine();
                    break;
                case 2:
                    updateStoreRoutine();
                    break;
                case 3:
                    cartRoutine();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng AIMS. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại (0-3).");
            }
        } while (choice != 0);
    }

    private static void initSampleData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Action", 24.95f, 136, "Lana Wachowski");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan");
        Book book1 = new Book(3, "Java Programming", "Education", 45.50f);
        book1.addAuthor("James Gosling");

        CompactDisc cd1 = new CompactDisc(4, "Abbey Road", "Rock", 15.00f, "George Martin", "The Beatles");
        cd1.addTrack(new Track("Come Together", 259));
        cd1.addTrack(new Track("Something", 182));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // --- CÁC PHƯƠNG THỨC HIỂN THỊ MENU CHUẨN ĐỀ BÀI ---
    public static void showMenu() {
        System.out.println("\n--- AIMS: ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\n--- Options: ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n--- Options: ---");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\n--- Options: ---");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // --- LUỒNG XỬ LÝ MENU CHI TIẾT (ROUTINES) ---
    private static void viewStoreRoutine() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = getChoice();
            switch (choice) {
                case 1: // Chi tiết sản phẩm
                    System.out.print("Nhập tên phương tiện (Title): ");
                    String title = scanner.nextLine().trim();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println("\n[THÔNG TIN SẢN PHẨM]: " + media.toString());
                        detailMenuRoutine(media);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + title);
                    }
                    break;
                case 2: // Thêm sản phẩm trực tiếp từ Store vào Cart
                    System.out.print("Nhập tên sản phẩm muốn mua: ");
                    String tAdd = scanner.nextLine().trim();
                    Media mAdd = store.searchByTitle(tAdd);
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                    } else {
                        System.out.println("Sản phẩm không có trong cửa hàng!");
                    }
                    break;
                case 3: // Chạy/Phát đa phương tiện
                    System.out.print("Nhập tên sản phẩm để phát (Play): ");
                    String tPlay = scanner.nextLine().trim();
                    Media mPlay = store.searchByTitle(tPlay);
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) {
                            ((Playable) mPlay).play();
                        } else {
                            System.out.println("Loại phương tiện này không hỗ trợ chức năng phát nhạc/video.");
                        }
                    } else {
                        System.out.println("Sản phẩm không có trong cửa hàng!");
                    }
                    break;
                case 4: // Xem giỏ hàng nhanh
                    cart.printCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng chọn từ 0-4.");
            }
        } while (choice != 0);
    }

    private static void detailMenuRoutine(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("Sản phẩm này không hỗ trợ chức năng Play!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void updateStoreRoutine() {
        System.out.println("\n--- Cập Nhật Cửa Hàng ---");
        System.out.println("1. Thêm một Media mới vào Store");
        System.out.println("2. Xóa một Media khỏi Store");
        System.out.print("Lựa chọn của bạn: ");
        int subChoice = getChoice();

        if (subChoice == 1) {
            System.out.print("Chọn loại (1-DVD, 2-Book, 3-CD): ");
            int type = getChoice();
            System.out.print("Nhập ID: ");
            int id = getChoice();
            System.out.print("Nhập tiêu đề (Title): ");
            String title = scanner.nextLine().trim();
            System.out.print("Nhập thể loại (Category): ");
            String category = scanner.nextLine().trim();
            System.out.print("Nhập giá tiền (Cost): ");
            float cost = Float.parseFloat(scanner.nextLine().trim());

            if (type == 1) {
                System.out.print("Nhập thời lượng (phút): ");
                int len = getChoice();
                System.out.print("Nhập đạo diễn: ");
                String dir = scanner.nextLine().trim();
                store.addMedia(new DigitalVideoDisc(id, title, category, cost, len, dir));
            } else if (type == 2) {
                store.addMedia(new Book(id, title, category, cost));
            } else if (type == 3) {
                System.out.print("Nhập đạo diễn: ");
                String dir = scanner.nextLine().trim();
                System.out.print("Nhập nghệ sĩ: ");
                String art = scanner.nextLine().trim();
                store.addMedia(new CompactDisc(id, title, category, cost, dir, art));
            }
        } else if (subChoice == 2) {
            System.out.print("Nhập tên sản phẩm muốn xóa khỏi cửa hàng: ");
            String titleX = scanner.nextLine().trim();
            Media mX = store.searchByTitle(titleX);
            if (mX != null) {
                store.removeMedia(mX);
            } else {
                System.out.println("Sản phẩm không tồn tại trong cửa hàng.");
            }
        }
    }

    private static void cartRoutine() {
        int choice;
        do {
            cart.printCart();
            cartMenu();
            choice = getChoice();
            switch (choice) {
                case 1: // Lọc phương tiện trong giỏ hàng
                    System.out.println("Lọc theo: 1-ID, 2-Title");
                    int filterType = getChoice();
                    if (filterType == 1) {
                        System.out.print("Nhập ID cần tìm: ");
                        int fId = getChoice();
                        Media res = cart.searchById(fId);
                        System.out.println(res != null ? "Tìm thấy: " + res : "Không tìm thấy!");
                    } else if (filterType == 2) {
                        System.out.print("Nhập Title cần tìm: ");
                        String fTitle = scanner.nextLine().trim();
                        Media res = cart.searchByTitle(fTitle);
                        System.out.println(res != null ? "Tìm thấy: " + res : "Không tìm thấy!");
                    }
                    break;
                case 2: // Sắp xếp giỏ hàng
                    System.out.println("Sắp xếp theo: 1-Title, 2-Cost");
                    int sortType = getChoice();
                    if (sortType == 1) cart.sortCartByTitle();
                    else if (sortType == 2) cart.sortCartByCost();
                    break;
                case 3: // Xóa sản phẩm khỏi giỏ hàng
                    System.out.print("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng: ");
                    String rTitle = scanner.nextLine().trim();
                    Media rMedia = cart.searchByTitle(rTitle);
                    if (rMedia != null) {
                        cart.removeMedia(rMedia);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng.");
                    }
                    break;
                case 4: // Phát đa phương tiện trong giỏ hàng
                    System.out.print("Nhập tên sản phẩm trong giỏ hàng để phát: ");
                    String pTitle = scanner.nextLine().trim();
                    Media pMedia = cart.searchByTitle(pTitle);
                    if (pMedia instanceof Playable) {
                        ((Playable) pMedia).play();
                    } else {
                        System.out.println("Sản phẩm này không hỗ trợ chức năng phát âm thanh.");
                    }
                    break;
                case 5: // Đặt hàng
                    System.out.println("Thông báo: Đơn hàng của bạn đã được tạo thành công!");
                    cart.clear(); // Làm trống giỏ hàng theo yêu cầu
                    System.out.println("Giỏ hàng hiện tại đã được làm trống.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ (0-5).");
            }
        } while (choice != 0);
    }
}
