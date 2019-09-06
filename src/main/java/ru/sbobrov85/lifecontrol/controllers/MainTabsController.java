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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.sbobrov85.lifecontrol.utils.GUI;

/**
 * FXML MainTabs controller class.
 */
public class MainTabsController implements Initializable {

    /**
     * Locale bundle resource.
     */
    @FXML
    private ResourceBundle resources;

    /**
     * Contain main tabs instance.
     */
    @FXML
    private TabPane mainTabs;

    /**
     * Accounts tab instance.
     */
    @FXML
    private Tab accountsTab;

    /**
     * Budgets tab instance.
     */
    @FXML
    private Tab budgetsTab;

    /**
     * Reports tab instance.
     */
    @FXML
    private Tab reportsTab;

    /**
     * Settings tab instance.
     */
    @FXML
    private Tab settingsTab;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void initialize(URL url, ResourceBundle rb) {
        resources = rb;

        mainTabs.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Tab>() {
                @Override
                public void changed(
                    ObservableValue<? extends Tab> observable,
                    Tab oldValue,
                    Tab newValue
                ) {
                    oldValue.setContent(null);

                    switch (newValue.getId()) {
                        case "accountsTab":
                            setAccountsTabData();
                            break;
                        case "settingsTab":
                            setSettingsTabData();
                            break;

                        default:
                    }
                }
            }
        );

        setAccountsTabData();
    }

    protected final void setTabView(Tab tab, final String viewName) {
      try {
        Parent root = GUI.getLayout(viewName);
        tab.setContent(root);
      } catch (IOException ex) {
        Logger.getLogger(MainTabsController.class.getName())
            .log(Level.SEVERE, null, ex);
      }
    }

    /**
     * Create user interface for accounts tab.
     */
    protected final void setAccountsTabData() {
      setTabView(accountsTab, "AccountsTab");
    }

    /**
     * Create user interface for settings tab.
     */
    protected final void setSettingsTabData() {
      setTabView(settingsTab, "SettingsTab");
    }
}
