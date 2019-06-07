package ru.sbobrov85.lifecontrol.desktop.database;

import java.io.File;
import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import ru.sbobrov85.lifecontrol.database.DatabaseHelperInterface;
import ru.sbobrov85.lifecontrol.database.HelperBase;
import ru.sbobrov85.lifecontrol.database.HelperInit;

/**
 *
 * DatabaseHelper desktop.
 */
public class DatabaseHelper
        extends HelperBase
        implements DatabaseHelperInterface {

    @Override
    public ConnectionSource getDatabaseConnection() {
       if (!(databaseConnection instanceof ConnectionSource)) {
            try {
                databaseConnection = new JdbcConnectionSource(
                    "jdbc:sqlite:" + getDatabaseFullName()
                );
            } catch (SQLException e) {
                System.out.println(e);
                databaseConnection = null;
            }
        }

        return databaseConnection;
    }

    public DatabaseHelper() {
        if (!exists()) {
			HelperInit.initDatabase(getDatabaseConnection());
        }
    }

    /**
     * Get full name for database file.
     * @return {String}
     */
     @Override
    public String getDatabaseFullName() {
        return System.getProperty("user.home") + File.separator + databaseName;
    }
}
