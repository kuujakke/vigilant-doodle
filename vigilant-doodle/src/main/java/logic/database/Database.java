package logic.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import config.Configuration;

import java.util.Arrays;
import java.util.Properties;

/**
 * Class to connect the application logic to a MongoDB server.
 * Using Configuration to get credentials for database connection.
 */
public class Database {

    private Properties properties;

    /**
     * Initializes the class variable with passed in Properties object.
     *
     * @param properties Properties to be loaded in the class variable.
     */
    public Database(Properties properties) {
        this.properties = properties;
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
        return new MongoClient(new ServerAddress(properties.getProperty("db-hostname"), Integer.parseInt(properties.getProperty("db-port"))), Arrays.asList(credentials), options);
    }

    /**
     * Gets the database by name set in the properties by using a database connection
     * passed from connection() method.
     *
     * @return MongoDatabase object to be used in database transactions.
     */
    public MongoDatabase getDatabase() {
        return connection().getDatabase(this.properties.getProperty("db-name"));
    }

}
