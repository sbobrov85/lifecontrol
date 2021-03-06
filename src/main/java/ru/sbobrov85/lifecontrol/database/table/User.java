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
import java.util.Date;

/**
 * Manage users list.
 */
@DatabaseTable(tableName = "user")
public class User {
    /**
     * Primary key.
     */
    @DatabaseField(columnName = "user_id", generatedId = true)
    private int userId;

    /**
     * Const for user_id database column name.
     */
    public static final String USER_ID_COLUMN_NAME = "user_id";

    /**
     * Username field.
     */
    @DatabaseField
    private String username;

    /**
     * Const for username database column name.
     */
    public static final String USERNAME_COLUMN_NAME = "username";

    /**
     * Password hash field.
     */
    @DatabaseField(canBeNull = false)
    private String password;

    /**
     * User insert date.
     */
    @DatabaseField(columnName = "insert_date")
    private Date insertDate;

    /**
     * User last login date.
     */
    @DatabaseField(columnName = "last_login")
    private Date lastLogin;

    /**
     * User active flag.
     */
    @DatabaseField(columnName = "is_active")
    private Boolean isActive;

    /**
     * Auto login flag.
     */
    @DatabaseField(columnName = "is_default")
    private Boolean isDefault;

    /**
     * Const for is_default column name.
     */
    public static final String IS_DEFAULT_COLUMN_NAME = "is_default";

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the insertDate
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * @param insertDate the insertDate to set
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault the isDefault to set
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
