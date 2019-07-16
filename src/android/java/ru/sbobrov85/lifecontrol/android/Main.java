package ru.sbobrov85.lifecontrol.android;

import ru.sbobrov85.lifecontrol.android.database.DatabaseHelperFactory;

public class Main extends ru.sbobrov85.lifecontrol.Main {
    @Override
    public void init() throws Exception {
        super.init();
        DatabaseHelperFactory.setHelper();
    }

    @Override
    public void stop() throws Exception {
        DatabaseHelperFactory.releaseHelper();
        super.stop();
    }
}
