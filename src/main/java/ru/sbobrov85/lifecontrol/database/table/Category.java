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
 * Manage categories list.
 */
@DatabaseTable(tableName = "category")
public final class Category {
    /**
     * Category type constant for expense.
     */
    public static final int CATEGORY_TYPE_EXPENSE = 0;

    /**
     * Category type constant for income.
     */
    public static final int CATEGORY_TYPE_INCOME = 1;

    /**
     * Primary key.
     */
    @DatabaseField(columnName = "category_id", index = true)
    private int categoryId;

    /**
     * Link to parent category_id.
     */
    @DatabaseField(columnName = "parent_id", index = true)
    private int parentId;

    /**
     * Text label for category.
     */
    @DatabaseField
    private String label;

    /**
     * Link to category type.
     * @see class constants.
     */
    @DatabaseField(columnName = "category_type")
    private int categoryType;

    /**
     * Contains short comment of category.
     */
    @DatabaseField
    private String comment;

    /**
     * Protect root categories.
     */
    @DatabaseField(
        columnName = "is_protected",
        defaultValue = "0",
        canBeNull = false
    )
    private Boolean isProtected;

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param newCategoryId the categoryId to set
     */
    public void setCategoryId(final int newCategoryId) {
        this.categoryId = newCategoryId;
    }

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param newParentId the parentId to set
     */
    public void setParentId(final int newParentId) {
        this.parentId = newParentId;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param newLabel the label to set
     */
    public void setLabel(final String newLabel) {
        this.label = newLabel;
    }

    /**
     * @return the categoryType
     */
    public int getCategoryType() {
        return categoryType;
    }

    /**
     * @param newCategoryType the categoryType to set
     */
    public void setCategoryType(final int newCategoryType) {
        this.categoryType = newCategoryType;
    }

    /**
     * Get value of comment field.
     * @return value of comment field.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set value of comment field.
     * @param newComment new value of comment field.
     */
    public void setComment(final String newComment) {
        this.comment = newComment;
    }

    /**
     * Get value of isProtected field.
     * @return value of isProtected field.
     */
    public Boolean getIsProtected() {
        return isProtected;
    }

    /**
     * Set value of isProtected field.
     * @param newIsProtected new value of isProtected field.
     */
    public void setIsProtected(final Boolean newIsProtected) {
        this.isProtected = newIsProtected;
    }
}
