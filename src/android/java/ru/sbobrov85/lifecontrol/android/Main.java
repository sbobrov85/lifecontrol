/* 
 * Copyright (C) 2019 sbobrov85
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
