package logic.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import config.Configuration;

import java.util.Arrays;

/**
 * Class to connect the application logic to a MongoDB server.
 * Using Configuration to get credentials for database connection.
 */

public class Database {

    private Configuration configuration;

    public Database(Configuration configuration) {
        this.configuration = configuration;
    }

    public MongoClient connection() {
        MongoCredential credentials = MongoCredential.createCredential(configuration.getDBUser(), configuration.getDBName(), configuration.getDBpassword().toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        return new MongoClient(new ServerAddress(configuration.getDBHostname(), configuration.getDBPort()), Arrays.asList(credentials), options);
    }

    public MongoDatabase getDatabase() {
        return connection().getDatabase(this.configuration.getDBName());
    }

}
