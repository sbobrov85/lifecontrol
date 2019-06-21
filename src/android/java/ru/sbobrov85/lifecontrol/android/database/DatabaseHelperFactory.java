package ru.sbobrov85.lifecontrol.android.database;

import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;

public class DatabaseHelperFactory implements DatabaseHelperFactoryInterface {
    protected static DatabaseHelper databaseHelper = null;

    @Override
    public DatabaseHelperInterface getHelper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DatabaseHelperInterface setHelper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DatabaseHelperInterface setHelper(Context context) {
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
		return null;
    }

    @Override
    public void releaseHelper() {
        OpenHelperManager.releaseHelper();
       databaseHelper = null;
    }
}
