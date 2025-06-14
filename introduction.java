import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ArpitIntroduction extends Application {

    @Override
    public void start(Stage stage) {
        // Text: Introduction
        Text name = new Text("Name: Arpit Ojha");
        name.setFont(Font.font("Verdana", 20));
        name.setFill(Color.WHITE);
        name.setTranslateY(-150);

        Text classText = new Text("Class: 11");
        classText.setFont(Font.font("Verdana", 18));
        classText.setFill(Color.LIGHTBLUE);
        classText.setTranslateY(-120);

        Text school = new Text("School: M. C. Kejriwal Vidyapeeth");
        school.setFont(Font.font("Verdana", 18));
        school.setFill(Color.LIGHTGREEN);
        school.setTranslateY(-90);

        // Create a 3D Sphere
        Sphere coreSphere = new Sphere(50);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKBLUE);
        coreSphere.setMaterial(material);

        // "Java" Text rotating around the sphere
        Text javaText = new Text("Java");
        javaText.setFont(Font.font("Verdana", 24));
        javaText.setFill(Color.GOLD);
        javaText.setTranslateX(100);

        Group rotatingGroup = new Group(javaText);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), rotatingGroup);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        Group root = new Group(name, classText, school, coreSphere, rotatingGroup);
        Scene scene = new Scene(root, 600, 400, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);

        // Perspective camera for 3D
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-500);
        scene.setCamera(camera);

        stage.setTitle("Arpit Ojha - Introduction");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}