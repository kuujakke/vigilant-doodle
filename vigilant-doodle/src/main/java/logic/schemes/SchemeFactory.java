package logic.schemes;

/**
 * Interface describing a factory producing Schemes.
 */
public interface SchemeFactory {
    /**
     * Creates a new scheme with default settings.
     *
     * @return Scheme with default settings.
     */
    Scheme createScheme();

    /**
     * Creates a scheme with name and default description.
     *
     * @param name String containing name
     *
     * @return Scheme with name and default description set.
     */
    Scheme createScheme(String name);

    /**
     * Creates a scheme with specific name and description.
     *
     * @param name String containing name.
     * @param description String containing description.
     *
     * @return Scheme with name and description set.
     */
    Scheme createScheme(String name, String description);
}
