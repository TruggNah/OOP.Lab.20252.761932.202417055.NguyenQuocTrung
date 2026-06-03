package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        // Chuỗi cấu trúc FXML được nhúng thẳng vào code
        // Đã sửa đổi cách đặt thuộc tính onAction và onMouseDragged để IntelliJ bắt buộc phải nhận diện
        String fxmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<?import javafx.geometry.Insets?>\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "<?import javafx.scene.control.RadioButton?>\n" +
                "<?import javafx.scene.control.TitledPane?>\n" +
                "<?import javafx.scene.control.ToggleGroup?>\n" +
                "<?import javafx.scene.layout.BorderPane?>\n" +
                "<?import javafx.scene.layout.Pane?>\n" +
                "<?import javafx.scene.layout.VBox?>\n" +
                "<BorderPane prefHeight=\"480.0\" prefWidth=\"640.0\" xmlns=\"http://javafx.com/javafx/8\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"hust.soict.dsai.javafx.PainterController\">\n" +
                "   <padding><Insets bottom=\"8.0\" left=\"8.0\" right=\"8.0\" top=\"8.0\" /></padding>\n" +
                "   <left>\n" +
                "      <VBox spacing=\"8.0\" BorderPane.alignment=\"TOP_LEFT\">\n" +
                "         <BorderPane.margin><Insets right=\"8.0\" /></BorderPane.margin>\n" +
                "         <children>\n" +
                "            <TitledPane animated=\"false\" text=\"Tools\">\n" +
                "               <content>\n" +
                "                  <VBox spacing=\"4.0\">\n" +
                "                     <children>\n" +
                "                        <RadioButton fx:id=\"radioPen\" mnemonicParsing=\"false\" selected=\"true\" text=\"Pen\">\n" +
                "                           <toggleGroup><ToggleGroup fx:id=\"toolsGroup\" /></toggleGroup>\n" +
                "                        </RadioButton>\n" +
                "                        <RadioButton fx:id=\"radioEraser\" mnemonicParsing=\"false\" text=\"Eraser\" toggleGroup=\"$toolsGroup\" />\n" +
                "                     </children>\n" +
                "                  </VBox>\n" +
                "               </content>\n" +
                "            </TitledPane>\n" +
                "            <Button maxWidth=\"1.7319493E308\" mnemonicParsing=\"false\" onAction=\"#clearButtonPressed\" text=\"Clear\" />\n" +
                "         </children>\n" +
                "      </VBox>\n" +
                "   </left>\n" +
                "   <center>\n" +
                "      <Pane fx:id=\"drawingAreaPane\" onMouseDragged=\"#drawingAreaMouseDragged\" style=\"-fx-background-color: white;\" BorderPane.alignment=\"CENTER\" />\n" +
                "   </center>\n" +
                "</BorderPane>";

        // Đọc chuỗi trực tiếp từ bộ nhớ Ram thành luồng dữ liệu vào cho FXMLLoader
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fxmlContent.getBytes(StandardCharsets.UTF_8));
        Parent root = loader.load(inputStream);

        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}