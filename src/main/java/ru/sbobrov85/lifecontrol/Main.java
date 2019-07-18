package ru.sbobrov85.lifecontrol;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.sbobrov85.lifecontrol.utils.GUI;

public abstract class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("LifeControl");
        Scene scene = GUI.getScene("MainTabs");

        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
