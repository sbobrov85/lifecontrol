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
package ru.sbobrov85.lifecontrol.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.io.File;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

import ru.sbobrov85.lifecontrol.Main;
import ru.sbobrov85.lifecontrol.utils.Tools;

import org.apache.commons.lang3.StringUtils;
import ru.sbobrov85.lifecontrol.database.table.Category;
import ru.sbobrov85.lifecontrol.utils.GUI;

/**
 * Database init actions.
 */
public class HelperInit {
    /**
     * Contain chunks for tables path.
     */
    public static String[] tablesLocationChunks = {
        "ru",
        "sbobrov85",
        "lifecontrol",
        "database",
        "table"
    };

    /**
     * Init database, create tables.
     *
     * @param connection current database connection.
     *
     * @return Boolean true on success, false otherwise.
     */
    public static Boolean initDatabase(ConnectionSource connection) {
        Boolean result = true;

        String packageName = getTablesPackageName();

        try {
            String[] files = Tools.getResourceListing(
                Main.class,
                getTablesLocation()
            );
            for (String tableClass: files) {
                try {
                    String classFileName = tableClass.split("\\.")[0];
                    Class className = Class
                        .forName(packageName + "." + classFileName);
                    TableUtils.createTable(connection, className);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            populateData(connection);
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }

        return result;
    }

    /**
     * Build relative path to tables classes directory.
     *
     * @return path to tables classes directory.
     */
    protected static String getTablesLocation() {
        return StringUtils.join(tablesLocationChunks, File.separator)
          +  File.separator;
    }

    /**
     * Build package name for database tables entities.
     *
     * @return package name
     */
    protected static String getTablesPackageName() {
        return StringUtils.join(tablesLocationChunks, ".");
    }

    /**
     * Populate database with common data.
     *
     * @param connection current database connection.
     *
     * @throws java.sql.SQLException error on create protected categories.
     */
    public static void populateData(
      ConnectionSource connection
    ) throws SQLException {
      Dao<Category, ?> dao = DaoManager.createDao(
        connection,
        Category.class
      );

      dao.create(new Category(
        GUI.translateStringFromCommonBundle("%Income"),
        Category.CATEGORY_TYPE_INCOME,
        true
      ));

      dao.create(new Category(
        GUI.translateStringFromCommonBundle("%Expence"),
        Category.CATEGORY_TYPE_EXPENSE,
        true
      ));
    }
}
