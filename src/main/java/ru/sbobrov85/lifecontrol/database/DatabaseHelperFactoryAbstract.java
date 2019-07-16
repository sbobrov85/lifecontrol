package ru.sbobrov85.lifecontrol.database;

abstract public class DatabaseHelperFactoryAbstract
{
    protected static DatabaseHelperInterface databaseHelper = null;

    /**
     * Set helper to instance.
     * @throws Exception if not implemented.
     */
    public static void setHelper() throws Exception {
        throw new Exception("Not implemented yet.");
    }

    /**
     * Get helper instance.
     */
    public static DatabaseHelperInterface getHelper() {
        return databaseHelper;
    }

    /**
     * Release resources.
     */
    public static void releaseHelper() {
        databaseHelper = null;
    }
}
