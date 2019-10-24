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
package ru.sbobrov85.lifecontrol.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TreeItem;
import ru.sbobrov85.lifecontrol.classes.BaseService;
import ru.sbobrov85.lifecontrol.classes.CategoryTreeItem;
import ru.sbobrov85.lifecontrol.database.table.Category;
import ru.sbobrov85.lifecontrol.utils.GUI;

/**
 * Manage categories.
 */
public class Categories extends BaseService {
  /**
   * Get category dao.
   * @return null or categories dao.
   */
  public static Dao<Category, ?> getDao() {
    Dao<Category, ?> dao = getDao(Category.class);
    return dao;
  }

  /**
   * Gcategories tree for adding to TreeView.
   * @return categories tree.
   */
  public static TreeItem<String> getCategoriesTree() {
    CategoryTreeItem rootNode = new CategoryTreeItem(
      GUI.translateStringFromCommonBundle("%AllCategories")
    );

    loadCategoriesTreeHierarchical(rootNode, 0);

    return rootNode;
  }

  /**
   * Building categories tree with recursion.
   * @param rootNode parent categories node for append childs.
   * @param parentId parent category id.
   */
  protected static void loadCategoriesTreeHierarchical(
    final CategoryTreeItem rootNode,
    final int parentId
  ) {
    List<Category> categories = null;

    try { // trying loading children categories by parent category id.
        QueryBuilder<Category, ?> query = (getDao()).queryBuilder();
        query.where().eq("parent_id", parentId);
        categories = query.query();
    } catch (SQLException ex) {
      Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (categories != null) { // appending children categories if exists.
      for (Category category: categories) {
        CategoryTreeItem childrenCategory = new CategoryTreeItem(
          category.getLabel()
        );
        final int categoryId = category.getCategoryId();
        childrenCategory.setCategoryId(categoryId);
        if (categoryId != parentId) { // processing recursion...
          loadCategoriesTreeHierarchical(childrenCategory, categoryId);
        }
        rootNode.getChildren().add(childrenCategory);
      }
    }
  }

  /**
   * Getting one category from db by id.
   * @param categoryId category id
   * @return Category instance if exists.
   * @throws SQLException on error.
   */
  protected static Category getByCategoryId(
    final int categoryId
  ) throws SQLException {
    return (Category) getDao().queryBuilder()
      .where().eq("category_id", categoryId)
      .queryForFirst();
  }

  /**
   * Deleting category by id.
   * @param categoryId category id.
   * @throws SQLException on db errors.
   * @throws RuntimeException if category is protected.
   */
  public static void delete(
    final int categoryId
  ) throws
    SQLException,
    RuntimeException {
    Category current = getByCategoryId(categoryId);
    if (current.getIsProtected()) {
      throw new RuntimeException();
    }
    getDao().delete(current);
  }

  /**
   * Adding new category.
   * @param parentCategoryId parent category id.
   * @param label new category label.
   * @throws SQLException on adding errors.
   */
  public static void add(
    final int parentCategoryId,
    final String label
  ) throws SQLException {
    Category parentCategory = getByCategoryId(parentCategoryId);
    Category category = new Category(
      label,
      parentCategory.getCategoryType(),
      false
    );
    category.setParentId(parentCategory.getCategoryId());
    getDao().create(category);
  }

  /**
   * Editing category.
   * @param categoryId category id.
   * @param label new category label.
   * @throws SQLException on editing errors.
   * @throws RuntimeException if category is protected.
   */
  public static void edit(
    final int categoryId,
    final String label
  ) throws
    SQLException,
    RuntimeException {
    Category current = getByCategoryId(categoryId);
    if (current.getIsProtected()) {
      throw new RuntimeException();
    }
    current.setLabel(label);
    getDao().update(current);
  }
}
