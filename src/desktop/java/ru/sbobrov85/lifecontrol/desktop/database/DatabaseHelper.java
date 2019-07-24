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
package ru.sbobrov85.lifecontrol.desktop.database;

import java.io.File;
import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;
import ru.sbobrov85.lifecontrol.database.HelperBase;
import ru.sbobrov85.lifecontrol.database.HelperInit;

/**
 *
 * DatabaseHelper desktop.
 */
public class DatabaseHelper
        extends HelperBase
        implements DatabaseHelperInterface {

    @Override
    public ConnectionSource getDatabaseConnection() {
       if (!(databaseConnection instanceof ConnectionSource)) {
            try {
                databaseConnection = new JdbcConnectionSource(
                    "jdbc:sqlite:" + getDatabaseFullName()
                );
            } catch (SQLException e) {
                System.out.println(e);
                databaseConnection = null;
            }
        }

        return databaseConnection;
    }

    public DatabaseHelper() {
        if (!exists()) {
			HelperInit.initDatabase(getDatabaseConnection());
        }
    }

    /**
     * Get full name for database file.
     * @return {String}
     */
     @Override
    public String getDatabaseFullName() {
        return System.getProperty("user.home") + File.separator + databaseName;
    }
}
