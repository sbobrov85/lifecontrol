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
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import ru.sbobrov85.lifecontrol.classes.CategoryTreeItem;
import ru.sbobrov85.lifecontrol.services.Categories;
import ru.sbobrov85.lifecontrol.utils.GUI;
import ru.sbobrov85.lifecontrol.utils.Tools;

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
   * Contains add button instance.
   */
  @FXML
  private Button addButton;

  /**
   * Contains edit button instance.
   */
  @FXML
  private Button editButton;

  /**
   * Contains delete button instance.
   */
  @FXML
  private Button deleteButton;

  /**
   * {@inheritDoc}
   */
  @Override
  public final void initialize(URL url, ResourceBundle rb) {
      resources = rb;

      categoriesTree.getSelectionModel()
        .setSelectionMode(SelectionMode.SINGLE);
      categoriesTree.getSelectionModel()
        .select(0);

      loadCategoriesTree();
  }

  /**
   * Load categories tree into TreeView.
   */
  protected final void loadCategoriesTree() {
    TreeItem<String> rootItem = Categories.getCategoriesTree();
    rootItem.setExpanded(true);
    categoriesTree.setRoot(rootItem);
    categoriesTree.setShowRoot(false);
  }

  /**
   * Preparing add|edit dialog.
   * @param label category label.
   * @return add or edit dialog.
   */
  protected final TextInputDialog getCategoryDialog(final String label) {
    Boolean isUpdate = label.isEmpty();

    TextInputDialog dialog = new TextInputDialog(label);

    String title = (isUpdate ? "Edit" : "Add") + " category";

    dialog.setTitle(
      Tools.translateString("%" + title, resources)
    );
    dialog.setHeaderText(
      Tools.translateString("%Enter category label", resources)
    );
    dialog.setContentText(
      Tools.translateString("%Label", resources)
    );

    return dialog;
  }

  /**
   * Show alert dialog for protected category.
   */
  protected final void showProtectedDialog() {
    Alert dialog = new Alert(AlertType.WARNING);

    dialog.setTitle(
      Tools.translateString("%Protected category warning", resources)
    );
    dialog.setContentText(
      Tools.translateString("%Can't modify protected category!", resources)
    );

    dialog.showAndWait();
  }

  /**
   * Action for adding category.
   */
  public final void addCategory() {
    Optional<String> categoryName = getCategoryDialog("").showAndWait();

    if (categoryName.isPresent()) {
      TreeItem<String> parent = categoriesTree
        .getSelectionModel()
        .getSelectedItem();

      String categoryNameValue = categoryName.get();

      try {
        Categories.add(
          ((CategoryTreeItem) parent).getCategoryId(),
          categoryNameValue
        );
        TreeItem<String> newItem = new TreeItem<>(categoryNameValue);
        parent.getChildren().add(newItem);
      } catch (SQLException ex) {
        Logger.getLogger(SettingsTabController.class.getName())
          .log(Level.SEVERE, null, ex);
      }
    }
  }

  /**
   * Action for edit category.
   */
  public final void editCategory() {
    TreeItem<String> current = categoriesTree
      .getSelectionModel()
      .getSelectedItem();

    Optional<String> categoryName = getCategoryDialog(current.getValue())
      .showAndWait();

    if (categoryName.isPresent()) {
      String categoryNameValue = categoryName.get();
      try {
        Categories.edit(
          ((CategoryTreeItem) current).getCategoryId(),
          categoryNameValue
        );
        TreeItem<String> newItem = new TreeItem<>(categoryNameValue);
        current.setValue(categoryNameValue);
      } catch (SQLException ex) {
        Logger.getLogger(SettingsTabController.class.getName())
          .log(Level.SEVERE, null, ex);
      } catch (RuntimeException ex) {
        showProtectedDialog();
      }
    }
  }

  /**
   * Action for delete category.
   */
  public final void deleteCategory() {
    TreeItem<String> current = categoriesTree
      .getSelectionModel()
      .getSelectedItem();

    int categoryId = ((CategoryTreeItem) current).getCategoryId();

    try {
      Categories.delete(categoryId);
      current.getParent().getChildren().remove(current);
    } catch (SQLException ex) {
      Logger.getLogger(SettingsTabController.class.getName())
        .log(Level.SEVERE, null, ex);
    } catch (RuntimeException ex) {
      showProtectedDialog();
    }
  }
}
