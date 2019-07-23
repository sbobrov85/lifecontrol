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
 * Manage table with accounts groups.
 */
@DatabaseTable(tableName = "account_group")
public final class AccountGroup {
    /**
     * Primary key.
     */
    @DatabaseField(columnName = "account_group_id", generatedId = true)
    private int accountGroupId;

    /**
     * Text label for group.
     */
    @DatabaseField
    private String label;

    /**
     * @return the accountGroupId
     */
    public int getAccountGroupId() {
        return accountGroupId;
    }

    /**
     * @param accountGroupId the accountGroupId to set
     */
    public void setAccountGroupId(int accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
