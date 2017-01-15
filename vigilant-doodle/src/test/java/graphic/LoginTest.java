package graphic;

import config.Configuration;
import graphic.login.Login;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kuujakke on 11.1.2017.
 */
public class LoginTest {

    private Login login;
    private Configuration configuration;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration("test.properties");
        this.login = new Login(this.configuration.getProperties());
    }
    @Test
    public void validateCredentials() throws Exception {
        assertThat(this.configuration.getProperties()).isNotEmpty();
        assertThat(this.login.validateCredentials(this.configuration.getProperties())).isTrue();
    }

    @Test
    public void getDatabase() throws Exception {
        Datastore datastore = this.login.getDatabase();
        assertThat(datastore).isNotNull();

    }

}