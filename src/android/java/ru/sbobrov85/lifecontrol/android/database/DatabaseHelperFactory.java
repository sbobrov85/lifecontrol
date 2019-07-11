package ru.sbobrov85.lifecontrol.android.database;

import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import javafxports.android.FXActivity;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;

public class DatabaseHelperFactory implements DatabaseHelperFactoryInterface {
    protected static DatabaseHelper databaseHelper = null;

    @Override
    public DatabaseHelperInterface getHelper() {
        return databaseHelper;
    }

    @Override
    public DatabaseHelperInterface setHelper() {
        return setOpenHelper((Context) FXActivity.getInstance());
    }

    public DatabaseHelperInterface setOpenHelper(Context context) {
        return databaseHelper = OpenHelperManager.getHelper(
            context,
            DatabaseHelper.class
        );
    }

    @Override
    public void releaseHelper() {
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
