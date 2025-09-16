package doodleJump;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {
    private Doodle Doodle;



    private int v0;
    private int v;

    private int score;
    private Platform topPlat;

    private Label scorelabel;

    ArrayList<Platform> Platforms = new ArrayList<>();


    public Game(Pane root) {
        this.Doodle = new Doodle(root);
        Platform Platform = new Platform(root);
        Platforms.add(Platform);
        setPlatforms(root);
        Button quit = new Button("die");
        quit.setOnMouseClicked((MouseEvent e) -> System.exit(0));
        quit.relocate(200, 500);
        this.scorelabel = new Label(Integer.toString(score));
        root.getChildren().addAll(quit, scorelabel);
        root.setOnKeyPressed(this::move);
        this.setupTimeline(root);
    }

    private void setupTimeline(Pane root) {
        KeyFrame kf = new KeyFrame(Duration.seconds(0.016), (ActionEvent e) -> this.fall(root));
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setPlatforms(Pane root){
        this.topPlat = Platforms.get(Platforms.size() - 1);
        while (topPlat.rectangle.getY() > 0){
            double xlow = Math.max(0, topPlat.rectangle.getX() - 300);
            double xhigh = Math.min(340, topPlat.rectangle.getX() + 300);
            double ylow = topPlat.rectangle.getY() - 10;
            double yhigh = topPlat.rectangle.getY() - 100;
            Platform Plats = new Platform(root);
            double randx = xlow + (int)((xhigh - xlow + 1) * Math.random());
            double randy = yhigh - (int)((ylow - yhigh + 1) * Math.random());
            Plats.rectangle.setX(randx);
            Plats.rectangle.setY(randy);
            topPlat = Plats;
            Platforms.add(Plats);
        }
    }

    public void fall(Pane root) {
        if (v0 > 0){
            for (doodleJump.Platform platform : Platforms) {
                if (this.Doodle.rectangle.intersects(platform.rectangle.getLayoutBounds())) {
                    v = -600;
                    break;
                } else {
                    v = v0 + 16;
                }
            }
        } else {
            v = v0 + 16;
            }
        if (this.Doodle.rectangle.getY() < 350){
            double h = 350 - this.Doodle.rectangle.getY();
            this.Doodle.rectangle.setY(350);
            for (int i = 0; i < Platforms.size(); i++) {
                Platforms.get(i).rectangle.setY(Platforms.get(i).rectangle.getY() + h);
                if (Platforms.get(i).rectangle.getY() > 690) {
                    root.getChildren().remove(Platforms.get(i).rectangle);
                    Platforms.remove(Platforms.get(i));
                    score += 1;
                    this.scorelabel.setText(Integer.toString(score));
                }
            }
            setPlatforms(root);
        } else {
            this.Doodle.rectangle.setY(this.Doodle.rectangle.getY() + (v * 0.016));
            v0 = v;
        }
        if (this.Doodle.rectangle.getY() > 800){
            for (int i = 0; i < Platforms.size(); i++){
                root.getChildren().remove(Platforms.get(i).rectangle);
                Platforms.remove(Platforms.get(i));
            }
            this.scorelabel.setText("you suck");
        }
    }


    public void move(KeyEvent e){
        KeyCode key = e.getCode();
        if (key == KeyCode.A){
            this.Doodle.moveLeft();
        } else if (key == KeyCode.D){
            this.Doodle.moveRight();
        }
        e.consume();
    }


}
