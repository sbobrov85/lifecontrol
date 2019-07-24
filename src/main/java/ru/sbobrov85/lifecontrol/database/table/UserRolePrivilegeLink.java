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
 * Manage link UserRole to UserPrivilege.
 */
@DatabaseTable(tableName = "user_role_privilege_link")
public class UserRolePrivilegeLink {
    /**
     * Link to UserRole.
     */
    @DatabaseField(columnName = "user_role_id")
    private int userRoleId;

    /**
     * Link to UserPrivilege.
     */
    @DatabaseField(columnName = "user_privilege_id")
    private int userPrivilegeId;

    /**
     * @return the userRoleId
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * @param userRoleId the userRoleId to set
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * @return the userPrivilegeId
     */
    public int getUserPrivilegeId() {
        return userPrivilegeId;
    }

    /**
     * @param userPrivilegeId the userPrivilegeId to set
     */
    public void setUserPrivilegeId(int userPrivilegeId) {
        this.userPrivilegeId = userPrivilegeId;
    }
}
