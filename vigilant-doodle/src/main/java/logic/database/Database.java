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

    public Database(Properties properties) {
        this.properties = properties;
    }

    public MongoClient connection() {
        MongoCredential credentials = MongoCredential.createCredential(
                properties.getProperty("user-name"),
                properties.getProperty("db-name"),
                properties.getProperty("password").toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        return new MongoClient(new ServerAddress(properties.getProperty("db-hostname"), Integer.parseInt(properties.getProperty("db-port"))), Arrays.asList(credentials), options);
    }

    public MongoDatabase getDatabase() {
        return connection().getDatabase(this.properties.getProperty("db-name"));
    }

}
