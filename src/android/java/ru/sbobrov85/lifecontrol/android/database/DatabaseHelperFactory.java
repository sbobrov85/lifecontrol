package ru.sbobrov85.lifecontrol.android.database;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import android.content.Context;

import javafxports.android.FXActivity;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryAbstract;

public class DatabaseHelperFactory extends DatabaseHelperFactoryAbstract {
    public static void setHelper() {
        databaseHelper = OpenHelperManager.getHelper(
            (Context) FXActivity.getInstance(),
            DatabaseHelper.class
        );
    }

    public static void releaseHelper() {
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
