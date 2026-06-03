package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    // Constructor nhận vào một đối tượng Media để vẽ giao diện cho sản phẩm đó
    public MediaStore(Media media) {
        this.media = media;
        // Xếp các thành phần theo trục dọc (Y_AXIS)
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. Hiển thị Tiêu đề sản phẩm
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 2. Hiển thị Giá sản phẩm
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setFont(new Font("Arial", Font.PLAIN, 14));
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 3. Khung chứa các nút bấm hành động (Xếp theo hàng ngang - FlowLayout)
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);

        // Kiểm tra đa hình: Nếu sản phẩm thuộc loại có thể "phát" (CD hoặc DVD) thì mới hiện nút Play
        // --- ĐÃ CẬP NHẬT: XỬ LÝ NÚT PLAY THEO ĐÚNG INTERFACE PLAYABLE CỦA BẠN ---
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> {
                // Lấy ra tên lớp (DigitalVideoDisc hoặc CompactDisc)
                String mediaType = media.getClass().getSimpleName();
                int length = 0;

                // Ép kiểu về đúng lớp con để bốc tách thuộc tính length/duration vật lý
                if (media instanceof hust.soict.dsai.aims.media.DigitalVideoDisc) {
                    length = ((hust.soict.dsai.aims.media.DigitalVideoDisc) media).getLength();
                } else if (media instanceof hust.soict.dsai.aims.media.CompactDisc) {
                    length = ((hust.soict.dsai.aims.media.CompactDisc) media).getLength();
                }

                // Hiển thị hộp thoại thông báo đang phát với số phút chuẩn xác
                JOptionPane.showMessageDialog(this,
                        "Playing " + mediaType + ": " + media.getTitle() + "\n" +
                                "Duration: " + (length > 0 ? length + " mins" : "Unknown"),
                        "AIMS Media Player",
                        JOptionPane.INFORMATION_MESSAGE);
            });
            container.add(btnPlay);
        }

        // Đẩy các thành phần cách đều nhau theo chiều dọc
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        // Tạo đường viền đen mảnh bao quanh thẻ sản phẩm
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}