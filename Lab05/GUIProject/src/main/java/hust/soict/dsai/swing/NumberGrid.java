package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Mảng chứa 10 nút số từ 0-9
    private JButton btnDelete, btnReset;            // Nút xóa 1 ký tự (DEL) và nút xóa hết (C)
    private JTextField tfDisplay;                   // Ô hiển thị chuỗi số đã nhập

    // Constructor thiết lập giao diện
    public NumberGrid() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout()); // Sử dụng BorderLayout cho khung cảnh chính

        // 1. Tạo ô hiển thị nằm ở phía BẮC (North) của cửa sổ
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Chữ chạy từ phải sang trái (giống máy tính bỏ túi)
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 18));
        cp.add(tfDisplay, BorderLayout.NORTH);

        // 2. Tạo một Panel riêng để chứa các nút bấm xếp theo dạng lưới
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3, 5, 5)); // Lưới 4 hàng, 3 cột, khoảng cách ngang/dọc là 5px

        // Khởi tạo bộ lắng nghe sự kiện chung cho các nút bấm
        ButtonListener btnListener = new ButtonListener();

        // 3. Tạo và thêm các nút từ 1 đến 9 vào panel
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener); // Gắn sự kiện click
        }

        // Hàng cuối cùng của lưới gồm: Nút DEL, Nút số 0, và Nút C (Reset)
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);

        // Đưa toàn bộ panel chứa nút vào vùng TRUNG TÂM (Center) của cửa sổ
        cp.add(panelButtons, BorderLayout.CENTER);

        // Thiết lập các thuộc tính hiển thị cho cửa sổ chính
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(250, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    // Lớp nội bộ xử lý sự kiện click cho tất cả các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand(); // Lấy chữ hiển thị trên nút vừa bấm

            // Trường hợp 1: Nếu bấm các nút số từ 0 - 9
            if (buttonLabel.charAt(0) >= '0' && buttonLabel.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + buttonLabel); // Nối thêm số vào ô hiển thị
            }
            // Trường hợp 2: Nếu bấm nút DEL (Xóa ký tự cuối cùng)
            else if (buttonLabel.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    // Cắt bỏ ký tự cuối cùng của chuỗi hiện tại
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
            // Trường hợp 3: Nếu bấm nút C (Xóa sạch trống trơn)
            else if (buttonLabel.equals("C")) {
                tfDisplay.setText(""); // Xóa trắng ô hiển thị
            }
        }
    }
}