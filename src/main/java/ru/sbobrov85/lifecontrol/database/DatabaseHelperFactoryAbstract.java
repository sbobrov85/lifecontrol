/* 
 * Copyright (C) 2019 sergzx
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

abstract public class DatabaseHelperFactoryAbstract
{
    protected static DatabaseHelperInterface databaseHelper = null;

    /**
     * Set helper to instance.
     * @throws Exception if not implemented.
     */
    public static void setHelper() throws Exception {
        throw new Exception("Not implemented yet.");
    }

    /**
     * Get helper instance.
     */
    public static DatabaseHelperInterface getHelper() {
        return databaseHelper;
    }

    /**
     * Release resources.
     */
    public static void releaseHelper() {
        databaseHelper = null;
    }
}
