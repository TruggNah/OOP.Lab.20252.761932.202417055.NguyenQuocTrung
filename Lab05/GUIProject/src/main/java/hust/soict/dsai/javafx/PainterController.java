package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    // Hàm này bắt buộc nhận MouseEvent để lấy vị trí con trỏ chuột khi kéo
    @FXML
    public void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle;

        // Kiểm tra xem RadioButton nào đang được chọn
        if (radioPen != null && radioPen.isSelected()) {
            // Chế độ Pen: Vẽ nét đen, bán kính 4px
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else if (radioEraser != null && radioEraser.isSelected()) {
            // Chế độ Eraser: Vẽ nét trắng, bán kính 8px để tẩy
            newCircle = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    // Hàm xử lý khi nhấn nút Clear
    @FXML
    public void clearButtonPressed(ActionEvent event) {
        if (drawingAreaPane != null) {
            drawingAreaPane.getChildren().clear();
        }
    }
}