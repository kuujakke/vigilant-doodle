package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import config.Configuration;

import java.util.Arrays;

/**
 * Created by kuujakke on 4.1.2017.
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
}
