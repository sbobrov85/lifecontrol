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
package ru.sbobrov85.lifecontrol.android.database;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.support.ConnectionSource;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;
import ru.sbobrov85.lifecontrol.database.HelperBase;
import ru.sbobrov85.lifecontrol.database.HelperInit;

/**
 *
 * DatabaseHelper android.
 */
public class DatabaseHelper
    extends OrmLiteSqliteOpenHelper
    implements DatabaseHelperInterface {

    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, "lifecontrol.db", null, DATABASE_VERSION);
        HelperInit.initDatabase(getConnectionSource());
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
