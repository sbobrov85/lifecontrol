package ru.sbobrov85.lifecontrol.database;

import java.io.File;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import ru.sbobrov85.lifecontrol.Main;
import ru.sbobrov85.lifecontrol.utils.Tools;

import org.apache.commons.lang3.StringUtils;

/**
 * Database init actions.
 */
public class HelperInit {
    /**
     * Contain chunks for tables path.
     */
    public static String[] tablesLocationChunks = {
        "ru",
        "sbobrov85",
        "lifecontrol",
        "database",
        "table"
    };

    /**
     * Init database, create tables.
     *
     * @return Boolean true on success, false otherwise.
     */
    public static Boolean initDatabase(ConnectionSource connection) {
        Boolean result = true;

        String packageName = getTablesPackageName();

        try {
            String[] files = Tools.getResourceListing(
                Main.class,
                getTablesLocation()
            );
            for (String tableClass: files) {
                try {
                    String classFileName = tableClass.split("\\.")[0];
                    Class className = Class
                        .forName(packageName + "." + classFileName);
                    TableUtils.createTable(connection, className);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }

        return result;
    }

    /**
     * Build relative path to tables classes directory.
     *
     * @return path to tables classes directory.
     */
    protected static String getTablesLocation() {
        return StringUtils.join(File.separator, tablesLocationChunks) +  File.separator;
    }

    /**
     * Build package name for database tables entities.
     *
     * @return package name
     */
    protected static String getTablesPackageName() {
        return StringUtils.join(".", tablesLocationChunks);
    }
}
