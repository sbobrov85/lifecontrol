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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.sbobrov85.lifecontrol.database.table.Account;
import ru.sbobrov85.lifecontrol.database.table.AccountGroup;
import ru.sbobrov85.lifecontrol.services.Accounts;

/**
 * FXML AccountsTab controller class.
 */
public class AccountsTabController implements Initializable {
  /**
  * Locale bundle resource.
  */
  @FXML
  private ResourceBundle resources;

  @FXML
  private TabPane accountGroupTabs;

  @Override
  public void initialize(URL location, ResourceBundle rb) {
    resources = rb;
    setAccountGroups();
  }

  protected void setAccountGroups() {
    List<AccountGroup> accountGroups = null;
    try {
      accountGroups = Accounts.getAccountGroupDao().queryForAll();
    } catch (SQLException ex) {
      Logger.getLogger(AccountsTabController.class.getName()).log(Level.SEVERE, null, ex);
    }
    if (accountGroups != null) {
      for (AccountGroup accountGroup: accountGroups) {
        Tab tab = new Tab(accountGroup.getLabel());

        accountGroupTabs.getTabs().add(tab);
      }
    }
  }
}
