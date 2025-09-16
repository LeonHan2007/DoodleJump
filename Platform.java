package doodleJump;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Platform {
    Rectangle rectangle;

    public Platform(Pane root){
        this.rectangle = new Rectangle(60, 10);
        this.rectangle.setX(190);
        this.rectangle.setY(450);
        root.getChildren().add(rectangle);
    }
}
