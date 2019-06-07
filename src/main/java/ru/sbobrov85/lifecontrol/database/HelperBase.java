package ru.sbobrov85.lifecontrol.database;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Base helper for database work.
 */
public abstract class HelperBase implements DatabaseHelperInterface {
    /**
     * Contain common database name with extension.
     */
    public static String databaseName = "lifecontrol.db";

    /**
     * Contain database connection.
     */
    public static ConnectionSource databaseConnection;

    /**
     * Hide default constructor.
     */
    public HelperBase() {
        // don't write code here!
    }

    /**
     * Return database connection, with create if not connected.
     *
     * @return {ConnectionSource}
     */
    public ConnectionSource getDatabaseConnection() throws Exception {
        throw new Exception("Not implemented!");
    }

    /**
     * Get full name for database file.
     *
     * @return {String}
     */
    public String getDatabaseFullName() {
        return databaseName;
    }

    /**
     * Check if database exists.
     *
     * @return {Boolean} true, if exists, false another.
     */
    public Boolean exists() {
        Path databasePath = FileSystems
            .getDefault()
            .getPath(getDatabaseFullName());

        return Files.exists(databasePath);
    }
}
