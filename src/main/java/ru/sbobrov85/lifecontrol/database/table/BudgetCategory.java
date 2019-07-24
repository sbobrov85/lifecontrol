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
package ru.sbobrov85.lifecontrol.database.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Manage budgets for category.
 */
@DatabaseTable(tableName = "budget_category")
public class BudgetCategory {
    /**
     * Link to BudgetItem.
     */
    @DatabaseField(columnName = "budget_item_id")
    private int budgetItemId;

    /**
     * Link to Category.
     */
    @DatabaseField(columnName = "category_id")
    private int categoryId;

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
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
