package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Biến tích lũy tổng, khởi tạo bằng 0

    // Constructor thiết lập giao diện và bộ xử lý sự kiện
    public AWTAccumulator() {
        // Thiết lập bố cục dạng lưới 2 hàng, 2 cột
        setLayout(new GridLayout(2, 2));

        // Hàng 1: Nhãn và Ô nhập liệu
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);
        // Đăng ký bộ lắng nghe sự kiện khi nhấn Enter trên ô nhập
        tfInput.addActionListener(new TFInputListener());

        // Hàng 2: Nhãn và Ô hiển thị kết quả
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Khóa không cho người dùng sửa ô kết quả
        add(tfOutput);

        // Các thiết lập cửa sổ cơ bản
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);

        // Thêm sự kiện bấm nút X để tắt chương trình (AWT mặc định không tắt)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    // Lớp nội bộ xử lý sự kiện khi người dùng gõ số và nhấn Enter
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy chuỗi từ ô nhập, chuyển thành số nguyên
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;      // Cộng dồn vào tổng
            tfInput.setText("");  // Xóa trống ô nhập để nhập tiếp
            tfOutput.setText(sum + ""); // Hiển thị tổng mới lên ô kết quả
        }
    }
}