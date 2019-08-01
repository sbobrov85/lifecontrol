/* 
 * Copyright (C) 2019 sbobrov85
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
package ru.sbobrov85.lifecontrol.utils;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Class with JavaFX GUI methods.
 * @author sbobrov85
 */
public final class GUI {
    /**
     * Contains folder name with fxml files.
     */
    final private static String VIEW_FOLDER = "view";

    /**
     * Contains folder name with language bundles.
     */
    final private static String LANGUAGE_FOLDER = "language";

    /**
     * Contains folder with css files.
     */
    final private static String STYLE_FOLDER = "style";

    /**
     * Hide default constructor.
     */
    private GUI() {
      // don't write code here...
    }

    /**
     * Get resource url from view name.
     * @param viewName fxml view (file) name without extension.
     * @return resource url.
     */
    private static java.net.URL getResourceUrl(final String viewName) {
        return GUI.class.getResource("/" + VIEW_FOLDER + "/" + viewName + ".fxml");
    }

    /**
     * Get layout from fxml resource with language.
     * @param viewName fxml name withount extensions from views folder.
     * @return Parent object
     * @throws IOException on load errors.
     */
    public static Parent getLayout(final String viewName) throws IOException {
        Parent root = FXMLLoader.load(
            getResourceUrl(viewName),
            ResourceBundle.getBundle(
                LANGUAGE_FOLDER + "." + viewName
            )
        );
        return root;
    }

    /**
     * Prepare scene from fxml resource.
     * @param viewName fxml name withount extensions from views folder.
     * @return Scene object.
     * @throws IOException on load errors.
     */
    public static Scene getScene(final String viewName) throws IOException {
        Parent root = getLayout(viewName);
        Scene scene = new Scene(root);
        return scene;
    }

    /**
     * Translate string from common language bundle.
     *
     * @param string string with % lead.
     *
     * @return translated string.
     */
    public static String translateStringFromCommonBundle(String string) {
      return Tools.translateString(
        string,
        ResourceBundle.getBundle(LANGUAGE_FOLDER + ".Common")
      );
    }
}
