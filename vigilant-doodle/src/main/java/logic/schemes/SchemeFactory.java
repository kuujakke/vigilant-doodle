package logic.schemes;

/**
 * Interface describing a factory producing Schemes.
 */
public interface SchemeFactory {
    Scheme createScheme();
    Scheme createScheme(String name);
    Scheme createScheme(String name, String description);
}
