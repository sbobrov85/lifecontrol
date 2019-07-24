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
package ru.sbobrov85.lifecontrol.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class.
 */
public class SettingsTabController implements Initializable {

    /**
    * Locale bundle resource.
    */
    @FXML
    private ResourceBundle resources;

    /**
     * Contains categories tree instance.
     */
    @FXML
    private TreeView<String> categoriesTree;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void initialize(URL url, ResourceBundle rb) {
        resources = rb;

        loadCategoriesTree();
    }

    /**
     * Load categories into TreeView.
     */
    protected final void loadCategoriesTree() {
        TreeItem<String> rootItem = new TreeItem<>(
            resources.getString("AllCategories")
        );

        rootItem.setExpanded(true);

        categoriesTree.setRoot(rootItem);
    }
}
