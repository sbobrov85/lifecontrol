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
 * Manage payments list.
 */
@DatabaseTable(tableName = "payment_item")
public class PaymentItem {
    /**
     * Primary key.
     */
    @DatabaseField(columnName = "payment_item_id")
    private int paymentItemId;

    /**
     * Link to Payment.
     */
    @DatabaseField
    private int paymentId;

    /**
     * Link to Category.
     */
    @DatabaseField
    private int categoryId;

    /**
     * Price for single item.
     */
    @DatabaseField
    private int price;

    /**
     * Quantity.
     */
    @DatabaseField
    private int quantity;

    /**
     * Total summ.
     */
    @DatabaseField
    private int summ;

    /**
     * @return the paymentItemId
     */
    public int getPaymentItemId() {
        return paymentItemId;
    }

    /**
     * @param paymentItemId the paymentItemId to set
     */
    public void setPaymentItemId(int paymentItemId) {
        this.paymentItemId = paymentItemId;
    }

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

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
