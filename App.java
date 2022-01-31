/*
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Sub1 p = new Sub1(24, "kitaya");
        Button btn = new Button();
        btn.setText("My Name is ");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(p.printName());
            }
        });
        Button btn2 = new Button();
        btn2.setText("My Age is ");
        btn2.setLayoutY(10.f);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(p.printAge());
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(btn2);
  
  
  Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
  Scene scene = new Scene(root);
  
  
  Scene scene = new Scene(root, 300, 250);
  
  primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
*/