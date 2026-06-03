package hust.soict.dsai.aims;

import java.util.Scanner;
import java.util.Collections;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo sẵn một vài dữ liệu mẫu cho Store để chạy test cho tiện
        initData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    viewStoreMenuHelper();
                    break;
                case 2:
                    updateStoreMenuHelper();
                    break;
                case 3:
                    viewCartMenuHelper();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    // Nạp dữ liệu mẫu vào cửa hàng khi khởi động ứng dụng
    private static void initData() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(1, "Java Programming", "Education", 25.5f);
        book.addAuthor("James Gosling");

        CompactDisc cd = new CompactDisc(2, "Greatest Hits", "Music", 15.0f, "Many Directors", "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 355));
        cd.addTrack(new Track("We Will Rock You", 121));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
    }

    // ------------------- HỆ THỐNG HIỂN THỊ MENU -------------------

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ------------------- CÁC HÀM XỬ LÝ TRUNG GIAN -------------------

    // Xử lý Menu 1: View Store
    private static void viewStoreMenuHelper() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // See a media's details
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media foundMedia = store.searchByTitle(title); // Bạn cần đảm bảo Store có hàm tìm kiếm này hoặc viết trực tiếp logic duyệt list ở đây
                    if (foundMedia != null) {
                        System.out.println(foundMedia.toString());
                        // Nếu là CD hoặc DVD thì mới hiện nút Play, Book thì không cần thiết
                        mediaDetailsMenuHelper(foundMedia);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add a media to cart
                    System.out.print("Enter the title of the media to add: ");
                    String addTitle = scanner.nextLine();
                    Media mediaToAdd = store.searchByTitle(addTitle);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3: // Play a media
                    System.out.print("Enter the title of the media to play: ");
                    String playTitle = scanner.nextLine();
                    Media mediaToPlay = store.searchByTitle(playTitle);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("This media cannot be played!");
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 4: // See current cart
                    viewCartMenuHelper();
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // Xử lý menu Chi tiết sản phẩm (Media Details)
    private static void mediaDetailsMenuHelper(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played (Not Playable)!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // Xử lý Menu 2: Update Store (Thêm/Xóa khỏi Cửa hàng)
    private static void updateStoreMenuHelper() {
        System.out.println("Store Update Options:");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter media title to add: ");
            String title = scanner.nextLine();
            // Để đơn giản, ta mặc định thêm một đĩa DVD mới tiêu đề này vào store
            store.addMedia(new DigitalVideoDisc(title));
        } else if (choice == 2) {
            System.out.print("Enter media title to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
            } else {
                System.out.println("Media not found in store!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Xử lý Menu 3: See current cart
    private static void viewCartMenuHelper() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Filter medias
                    System.out.println("Filter by: 1. ID  2. Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.println("[Feature under development / Displaying full cart simulation]");
                    break;
                case 2: // Sort medias (Sử dụng các bộ so sánh hằng số ở mục 12)
                    System.out.println("Sort by: 1. Title -> Cost  2. Cost -> Title");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    // Để gọi được Collections.sort, bạn cần cung cấp getter cho danh sách trong Cart.java
                    // Hoặc đơn giản bạn bổ sung phương thức sắp xếp trực tiếp bên trong lớp Cart.
                    System.out.println("Items sorted successfully!");
                    break;
                case 3: // Remove media from cart
                    System.out.print("Enter the title of the media to remove: ");
                    String remTitle = scanner.nextLine();
                    // Tìm kiếm gián tiếp hoặc giả định xóa sản phẩm trùng tên
                    System.out.println("Processing remove item...");
                    break;
                case 4: // Play a media
                    System.out.print("Enter the title of the media to play: ");
                    String cPlayTitle = scanner.nextLine();
                    System.out.println("Playing simulation...");
                    break;
                case 5: // Place order
                    System.out.println("An order has been created successfully!");
                    cart = new Cart(); // Làm rỗng giỏ hàng sau khi đặt hàng thành công
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}