package logic.database;

import com.mongodb.MongoClient;
import config.Configuration;
import config.DefaultSettings;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by kuujakke on 15.1.2017.
 */
public class DatabaseTest {

    private Database database;
    private Properties configuration;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration("test.properties").getProperties();
        this.database = new Database(this.configuration);
    }

    @Test
    public void propertiesNotNull() throws Exception {
        assertThat(new Database(null)).isNotNull();
        assertThat(new Database(new Properties())).isNotNull();
    }

    @Test
    public void connection() throws Exception {
        MongoClient client = this.database.connection();
        assertThat(client).isNotNull();
        assertThat(client.getCredentialsList().size()).isGreaterThan(0);
    }

    @Test
    public void getDatabase() throws Exception {
        Datastore db = this.database.getDatabase();
        assertThat(db).isNotNull();
        assertThat(db.getDB()).isNotNull();
    }

}