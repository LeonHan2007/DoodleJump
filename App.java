package doodleJump;

import doodleJump.PaneOrganizer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), 400, 700);
        stage.setScene(scene);
        stage.setTitle("doodly jump");
        stage.show();
    }
}
