package logic.schemes;

/**
 * Created by kuujakke on 2.1.2017.
 */

public enum SchemeType {
    PROJECT, TASK, JOB;


    String defaultName(SchemeType type) {
        switch (type) {
            case PROJECT: return "New Project";
            case TASK: return "New Task";
            case JOB: return "New Job";
            default: return "Not a valid scheme!";
        }
    }

    String defaultDescription(SchemeType type) {
        switch (type) {
            case PROJECT: return "The projectroles has no description yet.";
            case TASK: return "The taskroles has no description yet.";
            case JOB: return "The job has no description yet.";
            default: return "Not a valid scheme!";
        }
    }
}
