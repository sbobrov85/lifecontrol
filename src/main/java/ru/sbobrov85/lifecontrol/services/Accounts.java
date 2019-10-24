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
package ru.sbobrov85.lifecontrol.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.sbobrov85.lifecontrol.classes.BaseService;
import ru.sbobrov85.lifecontrol.database.table.Account;
import ru.sbobrov85.lifecontrol.database.table.AccountGroup;

/**
 * Manage accounts.
 */
public class Accounts extends BaseService {
  /**
   * Get account groups list without filtering.
   * @return account groups list.
   * @throws SQLException on query errors.
   */
  public static List<AccountGroup> getAccountGroupAll() throws SQLException {
    Dao<AccountGroup, ?> dao = getDao(AccountGroup.class);
    return dao.queryForAll();
  }

  /**
   * Get accounts for account group.
   * @param accountGroupId account group id.
   * @return list of accounts.
   */
  public static List<Account> getAccountGroupAccount(Integer accountGroupId) {
    List<Account> accounts = null;
    Dao<Account, ?> dao = getDao(Account.class);

    if (dao != null) {
      QueryBuilder queryBuilder = dao.queryBuilder();
      try {
        queryBuilder.where().eq("account_group", accountGroupId);
        accounts = queryBuilder.query();
      } catch (SQLException ex) {
        Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return accounts;
  }
}
