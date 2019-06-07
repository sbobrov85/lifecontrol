package ru.sbobrov85.lifecontrol.database;

/**
 * Database helper factory interface.
 */
public interface DatabaseHelperFactoryInterface {

    /**
     * Get helper instance.
     */
    public DatabaseHelperInterface getHelper();

    /**
     * Set helper to instance.
     */
    public DatabaseHelperInterface setHelper();

    /**
     * Release resources.
     */
    public void releaseHelper();
}
