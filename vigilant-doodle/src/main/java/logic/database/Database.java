package logic.database;

import com.mongodb.*;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Arrays;

import java.util.Properties;

/**
 * Class to connect the application logic to a MongoDB server.
 * Using Configuration to get credentials for database connection.
 */
public class Database {

    private Properties properties;
    final Morphia morphia = new Morphia();

    /**
     * Initializes the class variable with passed in Properties object.
     *
     * @param properties Properties to be loaded in the class variable.
     */
    public Database(Properties properties) {
        this.properties = properties;
        this.morphia.mapPackage("fi.jk.vigilant-doodle");
    }

    /**
     * Initializes the database connection by using the configurations
     * passed on to the constructor earlier.
     *
     * @return MongoClient database connection.
     */
    public MongoClient connection() {
        MongoCredential credentials = MongoCredential.createCredential(
                properties.getProperty("user-name"),
                properties.getProperty("db-name"),
                properties.getProperty("password").toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        try {
            return new MongoClient(new ServerAddress(properties.getProperty("db-hostname"), Integer.parseInt(properties.getProperty("db-port"))), Arrays.asList(credentials), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the database by name set in the properties by using a database connection
     * passed from connection() method.
     *
     * @return Datastore object to be used in database transactions.
     */
    public Datastore getDatabase() {
        final Datastore datastore = morphia.createDatastore(connection(), properties.getProperty("db-name"));
        datastore.ensureIndexes();
        return datastore;
    }

}
