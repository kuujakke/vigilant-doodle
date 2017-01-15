import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import config.Configuration;
import graphic.Login;
import org.assertj.swing.core.MouseButton;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JMenuItemFixture;
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

import javax.swing.*;

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
        Thread.sleep(5000);
        //assertThat(window.table()).isNotNull();
        assertThat(window.tree().requireVisible());
        assertThat(window.tree().clickRow(0)).isNotNull();
        assertThat(window.splitPane().requireVisible());
        Thread.sleep(100000);
    }

    public void login() throws Exception {
        window.textBox("db-user").enterText(this.configuration.getDBUser());
        window.textBox("db-password").enterText(this.configuration.getDBpassword());
        window.textBox("db-name").enterText(this.configuration.getDBName());
        window.textBox("db-hostname").enterText(this.configuration.getDBHostname());
        window.textBox("db-port").enterText(this.configuration.getDBPort());
        window.button("OK").click();
    }

}