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
 * Manage budgets item.
 */
@DatabaseTable(tableName = "budget_item")
public class BudgetItem {
    /**
     * Primary key.
     */
    @DatabaseField(columnName = "budget_item_id", generatedId = true)
    private int budgetItemId;

    /**
     * Budget year.
     */
    @DatabaseField
    private int year;

    /**
     * Budget month.
     */
    @DatabaseField
    private int month;

    /**
     * Total summ for item.
     */
    @DatabaseField
    private int summ;

    /**
     * Comment.
     */
    @DatabaseField
    private String comment;

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
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the summ
     */
    public int getSumm() {
        return summ;
    }

    /**
     * @param summ the summ to set
     */
    public void setSumm(int summ) {
        this.summ = summ;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
