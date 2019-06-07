package ru.sbobrov85.lifecontrol.android;

import ru.sbobrov85.lifecontrol.android.database.DatabaseHelperFactory;
import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;

public class Main extends ru.sbobrov85.lifecontrol.Main {
    @Override
    public DatabaseHelperFactoryInterface getDatabaseHelperFactory() {
        return new DatabaseHelperFactory();
    }
}
