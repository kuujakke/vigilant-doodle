import config.Configuration;
import graphic.Login;
import logic.DefaultFactory;
import logic.database.Database;
import logic.roles.projectroles.Member;
import logic.schemes.project.Project;
import org.mongodb.morphia.Datastore;

/**
 * Created by kuujakke on 11.1.2017.
 */
public class Testi {

    private Login login;
    private DefaultFactory defaultFactory;
    private Configuration configuration;
    private Datastore datastore;

    public Testi() throws Exception {
            this.configuration = new Configuration("test.properties");
            this.login = new Login(this.configuration.getProperties());
            this.datastore = this.login.getDatabase();
            this.defaultFactory = new DefaultFactory(new Configuration());
        saveMember();
    }

    private void saveMember() {
        Project project = this.defaultFactory.createProject();
        Member member = this.defaultFactory.createMember(project);
        if (this.datastore != null) {
            System.out.println("Saving member: " + member);
            this.datastore.save(member);
        }
    }
}
