/* 
 * Copyright (C) 2019 sergzx
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
