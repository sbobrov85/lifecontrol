package ru.sbobrov85.lifecontrol.desktop;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperFactoryInterface;
import ru.sbobrov85.lifecontrol.desktop.database.DatabaseHelperFactory;

public class Main extends ru.sbobrov85.lifecontrol.Main {

    @Override
    public DatabaseHelperFactoryInterface getDatabaseHelperFactory() {
        return DatabaseHelperFactory.getInstance();
    }

}
