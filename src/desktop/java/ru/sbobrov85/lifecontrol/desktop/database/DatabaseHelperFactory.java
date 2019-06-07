package ru.sbobrov85.lifecontrol.desktop.database;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;

public class DatabaseHelperFactory implements DatabaseHelperFactoryInterface {
    protected static DatabaseHelperFactory instance = null;

    protected static DatabaseHelper databaseHelper = null;

    protected DatabaseHelperFactory() {
    }

    public static DatabaseHelperFactory getInstance()
    {
        if (instance == null) {
            instance = new DatabaseHelperFactory();
        }
        return instance;
    }

    @Override
    public DatabaseHelperInterface getHelper() {
        return setHelper();
    }

    @Override
    public DatabaseHelperInterface setHelper() {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper();
        }
        return databaseHelper;
    }

    @Override
    public void releaseHelper() {
        databaseHelper = null;
    }
}
