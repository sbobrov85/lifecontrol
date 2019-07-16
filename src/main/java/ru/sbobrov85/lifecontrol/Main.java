package ru.sbobrov85.lifecontrol;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("LifeControl");
        primaryStage.show();
	}
}
