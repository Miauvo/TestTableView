import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent rootPane = FXMLLoader.load(getClass().getResource("/FXMLTestView.fxml"));
        Scene sc = new Scene(rootPane);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}