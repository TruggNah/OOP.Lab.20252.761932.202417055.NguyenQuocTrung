package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;

    // Constructor nhận vào kho hàng Store để lấy dữ liệu thật ra hiển thị
    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout()); // Khung chính dùng BorderLayout

        // Thêm các thành phần đồ họa vào 3 vùng biên
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createWest(), BorderLayout.WEST);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Các thiết lập cửa sổ cơ bản
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store - AIMS Application");
        setSize(1024, 768); // Kích thước cửa sổ theo đúng tài liệu yêu cầu
        setVisible(true);
    }

    // 1. Tạo vùng Phía Bắc: Gồm Menu điều hướng và phần Header
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        // Tạo thanh MenuBar trên cùng
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOptions = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menuOptions.add(smUpdateStore);

        // Tạo JMenuItem cho View cart độc lập để gán sự kiện
        JMenuItem viewCartMenuItem = new JMenuItem("View cart");
        viewCartMenuItem.addActionListener(e -> {
            // Khi bấm Options -> View cart, gọi lớp điều phối trung tâm để mở màn hình Giỏ hàng
            AimsScreen.openCartScreen();
        });

        menuOptions.add(new JMenuItem("View store"));
        menuOptions.add(viewCartMenuItem);
        menuBar.add(menuOptions);

        menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
        north.add(menuBar);

        // Tạo phần Header chứa tên ứng dụng và nút xem nhanh giỏ hàng
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS STORE");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.CYAN); // Màu chữ xanh cyan rực rỡ

        JButton btnCart = new JButton("View cart");
        btnCart.setPreferredSize(new Dimension(100, 50));
        btnCart.setMaximumSize(new Dimension(100, 50));

        // THÊM SỰ KIỆN CHO NÚT VIEW CART TRÊN HEADER:
        btnCart.addActionListener(e -> {
            // Khi bấm nút "View cart", gọi lớp điều phối trung tâm để chuyển màn hình
            AimsScreen.openCartScreen();
        });

        header.add(Box.createRigidArea(new Dimension(10, 0)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createRigidArea(new Dimension(10, 0)));

        header.setBackground(Color.DARK_GRAY); // Nền xám đậm tương phản
        north.add(header);

        return north;
    }

    // 2. Tạo vùng Phía Tây: Thanh Sidebar hiển thị danh mục phân loại bên trái
    JPanel createWest() {
        JPanel west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));

        JLabel selectSection = new JLabel("CATEGORIES");
        selectSection.setFont(new Font("Arial", Font.BOLD, 18));
        selectSection.setAlignmentX(Component.CENTER_ALIGNMENT);
        west.add(selectSection);

        // Các nút bấm danh mục giả định
        String[] categories = {"Books", "CDs", "DVDs"};
        for (String category : categories) {
            JButton btn = new JButton(category);
            btn.setFont(new Font("Arial", Font.PLAIN, 14));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(120, 40));
            west.add(Box.createRigidArea(new Dimension(0, 10)));
            west.add(btn);
        }

        west.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return west;
    }

    // 3. Tạo vùng Trung tâm: Lưới hiển thị danh sách sản phẩm (GridLayout)
    JPanel createCenter() {
        JPanel center = new JPanel();

        // Tạo lưới: 3 cột cố định, số hàng tự động tính dựa vào số lượng sản phẩm (0), khoảng cách ô là 10px
        center.setLayout(new GridLayout(0, 3, 10, 10));

        // Gọi hàm lấy danh sách sản phẩm thật từ đối tượng Store của bạn
        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();

        // Duyệt qua từng sản phẩm và tạo "thẻ giao diện" tương ứng bỏ vào lưới
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return center;
    }
}