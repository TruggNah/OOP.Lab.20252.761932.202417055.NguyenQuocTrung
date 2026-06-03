package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Biến tích lũy tổng, khởi tạo bằng 0

    // Constructor thiết lập giao diện Swing
    public SwingAccumulator() {
        // Trong Swing, các thành phần phải được thêm vào ContentPane của JFrame
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        // Hàng 1
        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        // Hàng 2
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Khóa không cho chỉnh sửa tổng
        cp.add(tfOutput);

        // Thiết lập các thuộc tính của cửa sổ JFrame
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tự động dừng chương trình khi bấm X
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    // Lớp xử lý sự kiện
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}