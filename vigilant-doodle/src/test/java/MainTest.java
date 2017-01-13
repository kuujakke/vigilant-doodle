import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import config.Configuration;
import graphic.Login;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Before;
import org.junit.Test;
import java.awt.Frame;
import java.util.LongSummaryStatistics;

import org.assertj.swing.core.GenericTypeMatcher;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 9.1.2017.
 */
public class MainTest extends AssertJSwingJUnitTestCase {

    FrameFixture window;
    private Configuration configuration;

    @Override
    protected void onSetUp() {
        try {
            this.configuration = new Configuration("test.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        application(Main.class).start();
        window = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            protected boolean isMatching(Frame frame) {
                return frame.isShowing();
            }
        }).using(robot());
    }

    @Test
    public void testProjectSaving() throws Exception {
        login();
        Thread.sleep(3000);
        assertThat(window.table()).isNotNull();
        Thread.sleep(30000);
    }

    public void login() throws Exception {
        window.textBox("db-user").enterText(this.configuration.getDBUser());
        Thread.sleep(1000);
        window.textBox("db-password").enterText(this.configuration.getDBpassword());
        Thread.sleep(1000);
        window.textBox("db-name").enterText(this.configuration.getDBName());
        Thread.sleep(1000);
        window.textBox("db-hostname").enterText(this.configuration.getDBHostname());
        Thread.sleep(1000);
        window.textBox("db-port").enterText(this.configuration.getDBPort());
        Thread.sleep(1000);
        window.button("OK").click();
        Thread.sleep(1000);
    }

}