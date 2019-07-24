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
 * Manage transfers list.
 */
@DatabaseTable(tableName = "transfer")
public class Transfer {
    /**
     * Link to Payment.
     */
    @DatabaseField(columnName = "payment_id")
    private int paymentId;

    /**
     * Link from Account.
     */
    @DatabaseField(columnName = "from_account_id")
    private int fromAccountId;

    /**
     * Link to Account;
     */
    @DatabaseField(columnName = "to_account_id")
    private int toAccountId;

    /**
     * Transfer total summ.
     */
    @DatabaseField
    private int summ;

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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
}
