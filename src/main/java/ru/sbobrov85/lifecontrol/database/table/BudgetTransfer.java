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
 * Manage budgets for transfers.
 */
@DatabaseTable(tableName = "budget_transfer")
public class BudgetTransfer {
    /**
     * Link to BudgetItem.
     */
    @DatabaseField(columnName = "budget_item_id")
    private int budgetItemId;

    /**
     * Link from Account.
     */
    @DatabaseField(columnName = "from_account_id")
    private int fromAccountId;

    /**
     * Link to Account.
     */
    @DatabaseField(columnName = "to_account_id")
    private int toAccountId;

    /**
     * @return the budgetItemId
     */
    public int getBudgetItemId() {
        return budgetItemId;
    }

    /**
     * @param budgetItemId the budgetItemId to set
     */
    public void setBudgetItemId(int budgetItemId) {
        this.budgetItemId = budgetItemId;
    }

    /**
     * @return the fromAccountId
     */
    public int getFromAccountId() {
        return fromAccountId;
    }

    /**
     * @param fromAccountId the fromAccountId to set
     */
    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    /**
     * @return the toAccountId
     */
    public int getToAccountId() {
        return toAccountId;
    }

    /**
     * @param toAccountId the toAccountId to set
     */
    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }
}
