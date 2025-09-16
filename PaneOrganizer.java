package doodleJump;

import javafx.scene.layout.Pane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PaneOrganizer {
    private final Pane root;

    private Game Game;


    public PaneOrganizer(){
        this.root = new Pane();
        new Game(this.getRoot());
    }



    public Pane getRoot(){
        return this.root;
    }

}
