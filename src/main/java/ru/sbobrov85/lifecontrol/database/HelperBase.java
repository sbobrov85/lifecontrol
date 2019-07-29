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

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Base helper for database work.
 */
public abstract class HelperBase implements DatabaseHelperInterface {
    /**
     * Contain common database name with extension.
     */
    public static String databaseName = "lifecontrol.db";

    /**
     * Contain database connection.
     */
    public static ConnectionSource databaseConnection;

    /**
     * Hide default constructor.
     */
    public HelperBase() {
        // don't write code here!
    }

    /**
     * Return database connection, with create if not connected.
     *
     * @return {ConnectionSource}
     */
    public ConnectionSource getConnectionSource() {
        return null;
    }

    /**
     * Get full name for database file.
     *
     * @return {String}
     */
    public String getDatabaseFullName() {
        return databaseName;
    }

    /**
     * Check if database exists.
     *
     * @return {Boolean} true, if exists, false another.
     */
    public Boolean exists() {
        Path databasePath = FileSystems
            .getDefault()
            .getPath(getDatabaseFullName());

        return Files.exists(databasePath);
    }
}
