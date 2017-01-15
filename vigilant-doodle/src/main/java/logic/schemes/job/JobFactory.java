package logic.schemes.job;

import config.Configuration;
import logic.schemes.SchemeFactory;

/**
 * A factory to produce jobs with a configuration object to get default
 * values if needed.
 */
public class JobFactory implements SchemeFactory {

    private Configuration configuration;

    /**
     * Initializes with a configuration object for later use if some values are not declared.
     *
     * @param configuration Configuration containing the default values.
     */
    public JobFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a new job with the default name and description from
     * the Configuration class.
     *
     * @return Job containing default name and description.
     */
    public Job createScheme() {
        return createScheme(
                this.configuration.getJobName(),
                this.configuration.getJobDescription()
        );
    }

    /**
     * Creates a new job with the given name.
     * Sets the job description as the default value from the configuration.
     *
     * @param name String containing the job name
     *
     * @return Job containing the given name and default description.
     */
    public Job createScheme(String name) {
        Job job = new Job(name);
        job.setDescription(this.configuration.getJobDescription());
        return job;
    }

    /**
     * Creates a new job from the given name and description.
     *
     * @param name String containing job name.
     * @param description String containing job description.
     *
     * @return Job containing given name and description.
     */
    public Job createScheme(String name, String description) {
        Job job = new Job(name);
        job.setDescription(description);
        return job;
    }

}
