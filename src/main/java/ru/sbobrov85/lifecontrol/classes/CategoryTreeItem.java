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
package ru.sbobrov85.lifecontrol.classes;

import javafx.scene.control.TreeItem;

/**
 * Extends TreeItem for working with TreeView.
 */
public class CategoryTreeItem extends TreeItem {
  /**
   * Contains current category id.
   */
  private int categoryId;

  /**
   * Constructor with one argument.
   * @param label category label.
   */
  public CategoryTreeItem(final String label) {
    super(label);
  }

  /**
   * Get current category id.
   * @return category id from property.
   */
  public final int getCategoryId() {
    return categoryId;
  }

  /**
   * Set new category id.
   * @param newCategoryId new value for category id.
   */
  public final void setCategoryId(final int newCategoryId) {
    categoryId = newCategoryId;
  }
}
