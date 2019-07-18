/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbobrov85.lifecontrol.utils;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author sergzx
 */
public final class GUI {
    /**
     * Hide default constructor.
     */
    private GUI() {

    }

    /**
     * Get resource url from view name.
     * @param viewName fxml view (file) name without extension.
     * @return resource url.
     */
    private static java.net.URL getResourceUrl(final String viewName) {
        return GUI.class.getResource("/views/" + viewName + ".fxml");
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
                "languages." + viewName
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
}
