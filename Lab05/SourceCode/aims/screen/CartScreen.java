package hust.soict.dsai.aims.screen;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        final JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart - AIMS Application");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);

                    // Định nghĩa chuỗi FXML trực tiếp trong mã nguồn - Đã thêm thuộc tính onAction cho View Store
                    String fxmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<?import javafx.geometry.Insets?>\n" +
                            "<?import javafx.scene.control.*?>\n" +
                            "<?import javafx.scene.layout.*?>\n" +
                            "<?import javafx.scene.text.Font?>\n" +
                            "<BorderPane prefHeight=\"768.0\" prefWidth=\"1024.0\" xmlns=\"http://javafx.com/javafx/8\" xmlns:fx=\"http://javafx.com/fxml/1\">\n" +
                            "   <top>\n" +
                            "      <VBox BorderPane.alignment=\"CENTER\">\n" +
                            "         <children>\n" +
                            "            <MenuBar><menus><Menu mnemonicParsing=\"false\" text=\"Options\"><items><MenuItem mnemonicParsing=\"false\" onAction=\"#btnViewStorePressed\" text=\"View Store\" /></items></Menu></menus></MenuBar>\n" +
                            "            <Label text=\"CART\" textFill=\"CYAN\"><font><Font name=\"System Bold\" size=\"30.0\" /></font><padding><Insets left=\"10.0\" /></padding></Label>\n" +
                            "         </children>\n" +
                            "      </VBox>\n" +
                            "   </top>\n" +
                            "   <center>\n" +
                            "      <VBox prefHeight=\"200.0\" prefWidth=\"100.0\" BorderPane.alignment=\"CENTER\">\n" +
                            "         <padding><Insets left=\"10.0\" right=\"10.0\" /></padding>\n" +
                            "         <children>\n" +
                            "            <HBox alignment=\"CENTER_LEFT\" prefWidth=\"200.0\" spacing=\"10.0\">\n" +
                            "               <padding><Insets bottom=\"10.0\" top=\"10.0\" /></padding>\n" +
                            "               <children>\n" +
                            "                  <Label text=\"Filter:\" />\n" +
                            "                  <TextField fx:id=\"tfFilter\" />\n" +
                            "                  <RadioButton fx:id=\"radioBtnFilterId\" mnemonicParsing=\"false\" selected=\"true\" text=\"By ID\"><toggleGroup><ToggleGroup fx:id=\"filterCategory\" /></toggleGroup></RadioButton>\n" +
                            "                  <RadioButton fx:id=\"radioBtnFilterTitle\" mnemonicParsing=\"false\" text=\"By Title\" toggleGroup=\"$filterCategory\" />\n" +
                            "               </children>\n" +
                            "            </HBox>\n" +
                            "            <TableView fx:id=\"tblMedia\">\n" +
                            "              <columns>\n" +
                            "                <TableColumn fx:id=\"colMediaTitle\" prefWidth=\"75.0\" text=\"Title\" />\n" +
                            "                <TableColumn fx:id=\"colMediaCategory\" prefWidth=\"75.0\" text=\"Category\" />\n" +
                            "                <TableColumn fx:id=\"colMediaCost\" prefWidth=\"75.0\" text=\"Cost\" />\n" +
                            "              </columns>\n" +
                            "               <columnResizePolicy><TableView fx:constant=\"CONSTRAINED_RESIZE_POLICY\" /></columnResizePolicy>\n" +
                            "            </TableView>\n" +
                            "            <HBox alignment=\"TOP_RIGHT\" prefHeight=\"100.0\" prefWidth=\"200.0\" spacing=\"10.0\">\n" +
                            "               <padding><Insets top=\"10.0\" /></padding>\n" +
                            "               <children>\n" +
                            "                  <Button fx:id=\"btnPlay\" mnemonicParsing=\"false\" text=\"Play\" />\n" +
                            "                  <Button fx:id=\"btnRemove\" mnemonicParsing=\"false\" onAction=\"#btnRemovePressed\" text=\"Remove\" />\n" +
                            "               </children>\n" +
                            "            </HBox>\n" +
                            "         </children>\n" +
                            "      </VBox>\n" +
                            "   </center>\n" +
                            "   <right>\n" +
                            "      <VBox alignment=\"TOP_CENTER\" prefHeight=\"200.0\" spacing=\"30.0\" BorderPane.alignment=\"CENTER\">\n" +
                            "         <padding><Insets top=\"50.0\" /></padding>\n" +
                            "         <children>\n" +
                            "            <HBox alignment=\"CENTER\" spacing=\"10.0\">\n" +
                            "               <children>\n" +
                            "                  <Label text=\"Total:\"><font><Font size=\"24.0\" /></font></Label>\n" +
                            "                  <Label fx:id=\"lblTotalCost\" text=\"0.00 $\" textFill=\"LIME\"><font><Font name=\"System Bold\" size=\"24.0\" /></font></Label>\n" +
                            "               </children>\n" +
                            "               <VBox.margin><Insets left=\"20.0\" right=\"20.0\" /></VBox.margin>\n" +
                            "            </HBox>\n" +
                            "            <Button mnemonicParsing=\"false\" style=\"-fx-background-color: red;\" text=\"Place Order\" textFill=\"WHITE\"><font><Font name=\"System Bold\" size=\"24.0\" /></font></Button>\n" +
                            "         </children>\n" +
                            "      </VBox>\n" +
                            "   </right>\n" +
                            "</BorderPane>";

                    // Đọc cấu trúc cây đồ họa trực tiếp từ luồng chuỗi byte
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(fxmlContent.getBytes(StandardCharsets.UTF_8));
                    Parent root = loader.load(inputStream);
                    fxPanel.setScene(new Scene(root));
                    System.out.println("✅ Khởi tạo và nạp giao diện Giỏ hàng thành công!");

                } catch (IOException e) {
                    System.err.println("❌ LỖI: Không thể dựng cây giao diện!");
                    e.printStackTrace();
                }
            }
        });
    }
}