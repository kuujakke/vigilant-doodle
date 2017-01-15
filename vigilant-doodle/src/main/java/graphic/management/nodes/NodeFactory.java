package graphic.management.nodes;

import logic.schemes.job.Job;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Class for creating treenode structure from database.
 */
public class NodeFactory {

    private final Datastore db;
    private final String name;

    /**
     * Initializes object variables.
     *
     * @param db Datastore
     * @param name String
     */
    public NodeFactory(Datastore db, String name) {
        this.db = db;
        this.name = name;
    }

    /**
     * Returns new top tree node with database objects loaded under it.
     *
     * @return DefaultMutableTreeNode top.
     */
    public DefaultMutableTreeNode createNodes() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(name);
        Query<Project> projects = db.createQuery(Project.class);
        for (Project project : projects) {
            DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(project);
            for (Task task : project.getTasks()) {
                DefaultMutableTreeNode taskNode = new DefaultMutableTreeNode(task);
                for (Job job : task.getJobs()) {
                    DefaultMutableTreeNode jobNode = new DefaultMutableTreeNode(job);
                    taskNode.add(jobNode);
                }
                projectNode.add(taskNode);
            }
            top.add(projectNode);
        }
        return top;
    }
}
