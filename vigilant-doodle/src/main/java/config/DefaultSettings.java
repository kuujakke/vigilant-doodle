package config;

/**
 * Holds the hard-coded default settings.
 * If the application root folder doesn't have a config.properties file
 * or if the file is incomplete it should use a value from here.
 */
public enum DefaultSettings {
    PROJECT_NAME {
        public String toString() {
            return "New Project";
        }
    },
    PROJECT_DESCRIPTION {
        public String toString() {
            return "No description yet.";
        }
    },
    TASK_NAME {
        public String toString() {
            return "New Task";
        }
    },
    TASK_DESCRIPTION {
        public String toString() {
            return "No description yet.";
        }
    },
    JOB_NAME {
        public String toString() {
            return "New Job";
        }
    },
    JOB_DESCRIPTION {
        public String toString() {
            return "No description yet.";
        }
    },
    USER_NAME {
        public String toString() {
            return "user";
        }
    },
    USER_PASSWORD {
        public String toString() {
            return "password";
        }
    },
    ROLE_DESCRIPTION {
        public String toString() {
            return "No role description yet.";
        }
    },
    UI_TITLE {
        public String toString() {
            return "Vigilant Doodle";
        }
    },
    UI_WIDTH {
        public String toString() {
            return "1200";
        }
    },
    UI_HEIGHT {
        public String toString() {
            return "600";
        }
    },
    LOGIN_WIDTH {
        public String toString() {
            return "350";
        }
    },
    LOGIN_HEIGHT {
        public String toString() {
            return "150";
        }
    }
}
