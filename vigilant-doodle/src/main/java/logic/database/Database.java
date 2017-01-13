package logic.database;

import com.mongodb.*;

import config.Configuration;
import config.DefaultSettings;
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
    private Morphia morphia = new Morphia();
    private Datastore datastore;

    /**
     * Initializes the class variable with passed in Properties object.
     *
     * @param properties Properties to be loaded in the class variable.
     *
     * @throws Exception if invalid properties.
     */
    public Database(Properties properties) throws Exception {
        if (properties != null) {
            this.properties = properties;
        } else {
            this.properties = new Configuration().getProperties();
        }
        this.morphia.mapPackage("fi.jk.vigilant-doodle");
    }

    /**
     * Initializes the database connection by using the configurations
     * passed on to the constructor earlier.
     *
     * @return MongoClient database connection.
     */
    public MongoClient connection() {
        if (!this.properties.isEmpty() && this.properties != null) {
            char[] pwd = this.properties.getProperty("db-password").toCharArray();
            MongoCredential credentials = MongoCredential.createCredential(
                    this.properties.getProperty("db-user"),
                    this.properties.getProperty("db-name"),
                    pwd);
            MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
            try {
                return new MongoClient(new ServerAddress(properties.getProperty("db-hostname"), Integer.parseInt(properties.getProperty("db-port"))), Arrays.asList(credentials), options);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        if (this.datastore == null) {
            this.datastore = this.morphia.createDatastore(connection(), this.properties.getProperty("db-name"));
            this.datastore.ensureIndexes();
        }
        return datastore;
    }

}
