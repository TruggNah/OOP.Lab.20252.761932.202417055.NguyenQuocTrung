package hust.soict.dsai.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    // Constructor nhận vào đối tượng giỏ hàng thật
    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    // Hàm tự động chạy sau khi giao diện FXML được tải xong để cấu hình các thuộc tính
    @FXML
    private void initialize() {
        // Đăng ký thuộc tính hiển thị cho từng cột trong bảng khớp với getter của lớp Media
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Lấy danh sách sản phẩm và đẩy lên bảng hiển thị JavaFX
        if (cart.getItemsInCart() != null) {
            ObservableList<Media> items = FXCollections.observableArrayList(cart.getItemsInCart());
            tblMedia.setItems(items);
        }

        // Mặc định ẩn/khóa các nút chức năng khi chưa chọn dòng nào trong bảng
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện người dùng click chọn hàng trên bảng để kích hoạt nút bấm tương ứng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateStatusProperty(newValue);
                }
            }
        });

        // Cập nhật lại tổng tiền lần đầu
        updateTotalCost();
    }

    // Hàm kiểm tra bật/tắt nút Play và Remove dựa trên sản phẩm được chọn
    private void updateStatusProperty(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // Xử lý sự kiện khi nhấn nút Remove để xóa sản phẩm
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media); // Xóa khỏi giỏ hàng logic

        // Cập nhật lại bảng hiển thị trực quan
        ObservableList<Media> items = FXCollections.observableArrayList(cart.getItemsInCart());
        tblMedia.setItems(items);

        // Tính toán và hiển thị lại tổng tiền mới
        updateTotalCost();
    }

    // Hàm phụ trợ tính tổng tiền giỏ hàng hiển thị lên Label
    private void updateTotalCost() {
        float total = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", total));
    }

    @FXML
    void btnViewStorePressed(javafx.event.ActionEvent event) {
        // Khi người dùng bấm Options > View Store trên giỏ hàng, quay lại màn hình Store
        hust.soict.dsai.aims.screen.AimsScreen.openStoreScreen();
    }
}