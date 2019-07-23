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
package ru.sbobrov85.lifecontrol.database.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Manage options table from database.
 */
@DatabaseTable(tableName = "option")
public final class Option {
    /**
     * Unique key.
     */
    @DatabaseField(columnName = "option_id", unique = true)
    private String optionId;

    /**
     * Contains value for optionId.
     */
    @DatabaseField(columnName = "value")
    private String value;

    /**
     * Get value of optionId field.
     * @return value of optionsId field.
     */
    public String getOptionId() {
        return optionId;
    }

    /**
     * Get value of value field.
     * @return value of value field.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set value of optionId field.
     * @param newOptionId new value of optionId field.
     */
    public void setOptionId(final String newOptionId) {
        this.optionId = newOptionId;
    }

    /**
     * Set value of value field.
     * @param newValue new value of value field.
     */
    public void setValue(final String newValue) {
        this.value = newValue;
    }
}
