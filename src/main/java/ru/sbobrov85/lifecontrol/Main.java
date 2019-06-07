package ru.sbobrov85.lifecontrol;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;

public abstract class Main extends Application {
    /**
     * Get database helper.
     */
    public abstract DatabaseHelperFactoryInterface getDatabaseHelperFactory();

    @Override
    public void init() throws Exception {
        super.init();
        (getDatabaseHelperFactory()).setHelper();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("LifeControl");
        primaryStage.show();
	}
}
