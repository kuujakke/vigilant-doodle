package config;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 4.1.2017.
 */

public class ConfigurationTest {

    Configuration config;

    @Before
    public void setUp() {
        this.config = new Configuration();
    }

    @Test
    public void loadWriteWorkingAsIntended() throws Exception {
        this.config.load();
        assertEquals("vigilant-doodle", config.getDBName());
        this.config.setDBName("Test");
        this.config.save();
        this.config.load();
        assertEquals("Test", config.getDBName());
        this.config.setDBName("vigilant-doodle");
        this.config.save();
        this.config.load();
        assertEquals("vigilant-doodle", config.getDBName());
    }
}