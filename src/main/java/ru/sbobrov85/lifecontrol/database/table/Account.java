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
 * Manage database account table.
 */
@DatabaseTable(tableName = "account")
public final class Account {
    /**
     * Primary key.
     */
    @DatabaseField(generatedId = true, columnName = "account_id")
    private int accountId;

    /**
     * Text label for account.
     */
    @DatabaseField
    private String label;

    /**
     * Contained account group id column name constant.
     */
    public static final
        String ACCOUNT_GROUP_ID_COLUMN_NAME = "account_group_id";

    /**
     * Link to AccountGroup.
     */
    @DatabaseField(columnName = ACCOUNT_GROUP_ID_COLUMN_NAME)
    private int accountGroupId;

    /**
     * Contained account type id column name constant.
     */
    public static final
        String ACCOUNT_TYPE_ID_COLUMN_NAME = "account_type_id";

    /**
     * Link to AccountType.
     */
    @DatabaseField(columnName = ACCOUNT_TYPE_ID_COLUMN_NAME)
    private int accountTypeId;

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
     * @return the accountTypeId
     */
    public int getAccountTypeId() {
        return accountTypeId;
    }

    /**
     * @param accountTypeId the accountTypeId to set
     */
    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
}
