package doodleJump;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Doodle {
    Rectangle rectangle;


    public Doodle(Pane root){
        this.rectangle = new Rectangle(40, 80);
        this.rectangle.setX(200);
        this.rectangle.setY(350);
        root.getChildren().add(rectangle);
    }

    public void moveRight(){
        if (rectangle.getX() < 400){
            rectangle.setX(rectangle.getX() + 20);
        } else{
            rectangle.setX(0);
        }
    }

    public void moveLeft(){
        if (rectangle.getX() > 0){
            rectangle.setX(rectangle.getX() - 20);
        } else{
            rectangle.setX(400);
        }
    }



}
