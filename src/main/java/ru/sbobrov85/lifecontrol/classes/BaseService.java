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
package ru.sbobrov85.lifecontrol.classes;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryBase;

/**
 * Base service class.
 */
abstract public class BaseService {
    
    /**
     * Get dao.
     * @param <T> dao entities type.
     * @param clazz dao entities class.
     * @return null or class dao.
     */
    public static <T> Dao<T, ?> getDao(Class clazz) {
      Dao<T, ?> dao = null;
      
      try {
        dao = DaoManager.createDao(
          (DatabaseHelperFactoryBase.getHelper()).getConnectionSource(),
          clazz
        );
      } catch (SQLException ex) {
        Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
      }

      return dao;
    }
}
