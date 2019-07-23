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
import java.util.Date;

/**
 * Store log entities for any events.
 */
@DatabaseTable(tableName = "log")
public class Log {
    /**
     * Primary key.
     */
    @DatabaseField(columnName = "log_id", generatedId = true)
    private int logId;

    /**
     * Log insert date.
     */
    @DatabaseField(columnName = "insert_date")
    private Date insertDate;

    /**
     * Link to User.
     */
    @DatabaseField(columnName = "user_id")
    private int userId;

    /**
     * Link to UserPrivilege.
     */
    @DatabaseField(columnName = "user_privilege_id")
    private int userPrivilegeId;

    /**
     * Additional comment for log event.
     */
    @DatabaseField
    private String comment;

    /**
     * @return the logId
     */
    public int getLogId() {
        return logId;
    }

    /**
     * @param logId the logId to set
     */
    public void setLogId(int logId) {
        this.logId = logId;
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
