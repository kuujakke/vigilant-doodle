package logic.schemes.job;

import config.Configuration;
import logic.schemes.Scheme;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 15.1.2017.
 */
public class JobFactoryTest {

    private JobFactory jobFactory;
    private Configuration config;

    @Before
    public void setUp() throws Exception {
        this.config = new Configuration();
        this.jobFactory = new JobFactory(this.config);
    }

    @Test
    public void createScheme() throws Exception {
        Scheme scheme = this.jobFactory.createScheme();
        assertThat(this.config.getJobName() + "\n" + this.config.getJobDescription()).isEqualTo(scheme.toString());
    }

    @Test
    public void createScheme1() throws Exception {
        Scheme scheme = this.jobFactory.createScheme("Test");
        assertThat("Test\n" + this.config.getJobDescription()).isEqualTo(scheme.toString());
    }

    @Test
    public void createScheme2() throws Exception {
        Scheme scheme = this.jobFactory.createScheme("Test", "TestDescription");
        assertThat("Test\nTestDescription").isEqualTo(scheme.toString());
    }

}