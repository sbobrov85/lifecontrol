package ru.sbobrov85.lifecontrol.desktop.database;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryAbstract;

public class DatabaseHelperFactory extends DatabaseHelperFactoryAbstract {
    public static void setHelper() {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper();
        }
    }
}
