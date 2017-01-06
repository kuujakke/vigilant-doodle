package config;

/**
 * Holds the hard-coded default settings.
 * If the application root folder doesn't have a config.properties file
 * or if the file is incomplete it should use a value from here.
 */
public enum DefaultSettings {
    PROJECT_NAME {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "New Project";
        }
    },
    PROJECT_DESCRIPTION {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "No description yet.";
        }
    },
    TASK_NAME {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "New Task";
        }
    },
    TASK_DESCRIPTION {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "No description yet.";
        }
    },
    JOB_NAME {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "New Job";
        }
    },
    JOB_DESCRIPTION {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "No description yet.";
        }
    },
    USER_NAME {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "user";
        }
    },
    USER_PASSWORD {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "password";
        }
    },
    ROLE_DESCRIPTION {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "No role description yet.";
        }
    },
    UI_TITLE {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "Vigilant Doodle";
        }
    },
    UI_WIDTH {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "1200";
        }
    },
    UI_HEIGHT {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "600";
        }
    },
    CONFIG_FILE {
        /**
         * Returns the hard-coded property value.
         *
         * @return String default value for property
         */
        public String toString() {
            return "config.properties";
        }
    }
}
