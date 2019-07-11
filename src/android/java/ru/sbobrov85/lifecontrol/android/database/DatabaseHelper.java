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
