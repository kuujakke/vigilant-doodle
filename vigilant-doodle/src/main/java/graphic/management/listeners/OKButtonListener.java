package graphic.management.listeners;

import graphic.login.Login;
import graphic.management.nodes.NodeFactory;
import logic.DefaultFactory;
import logic.schemes.Scheme;
import logic.schemes.job.Job;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.mongodb.morphia.Datastore;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for Function panel OK Button.
 */
public class OKButtonListener implements ActionListener {

    private final JTree tree;
    private final Datastore db;
    private final Login login;
    private final JComboBox cellFunction;
    private final DefaultFactory defaultFactory;
    private NodeFactory nodeFactory;

    /**
     * Creates a new OKButtonListener with given parameters.
     *
     * @param nodeFactory    NodeFactory
     * @param tree           JTree
     * @param db             Datastore
     * @param login          Login
     * @param cellFunction   JComboBox
     * @param defaultFactory DefaultFactory
     */
    public OKButtonListener(NodeFactory nodeFactory,
                            JTree tree,
                            Datastore db,
                            Login login,
                            JComboBox cellFunction,
                            DefaultFactory defaultFactory
    ) {
        this.nodeFactory = nodeFactory;
        this.tree = tree;
        this.db = db;
        this.login = login;
        this.cellFunction = cellFunction;
        this.defaultFactory = defaultFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof DefaultMutableTreeNode) {
            TreePath selectionPath = tree.getSelectionModel().getSelectionPath();
            DefaultMutableTreeNode node = ((DefaultMutableTreeNode) tree.getLastSelectedPathComponent());
            Scheme scheme;
            if (node != null && node.getUserObject() instanceof Scheme) {
                cellFunctionScheme((Scheme) node.getUserObject(), (DefaultMutableTreeNode) node.getParent());
            } else if (node.getUserObject().equals(login.getLoginInformation().getProperty("db-name"))) {
                cellFunctionRoot(node);
            }
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            model.setRoot(nodeFactory.createNodes());
            tree.expandPath(selectionPath);
            tree.updateUI();
            tree.revalidate();
        }
    }

    private void cellFunctionRoot(DefaultMutableTreeNode node) {
        if (cellFunction.getSelectedItem().equals("Add")) {
            Scheme scheme = defaultFactory.createProject();
            db.save(scheme);
        } else if (cellFunction.getSelectedItem().equals("Delete")) {
            int answer = JOptionPane.showConfirmDialog(tree.getParent(), "Are you sure you want to delete everything in the database?");
            if (answer == JOptionPane.YES_OPTION) {
                while (node.children().hasMoreElements()) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.children().nextElement();
                    Scheme childObj = (Scheme) child.getUserObject();
                    db.delete(childObj);
                }

            }
        }
    }

    private void cellFunctionScheme(Scheme scheme, DefaultMutableTreeNode parent) {
        if (scheme instanceof Project) {
            cellFunctionProject((Project) scheme);
        } else if (scheme instanceof Task) {
            cellFunctionTask((Task) scheme, (Project) parent.getUserObject());
        } else if (scheme instanceof Job) {
            cellFunctionJob((Job) scheme, (Task) parent.getUserObject());
        }
    }

    private void cellFunctionJob(Job job, Task task) {
        if (cellFunction.getSelectedItem().equals("Delete")) {
            task.removeJob(job);
            db.delete(job);
            db.save(task);
        }
    }

    private void cellFunctionTask(Task task, Project project) {
        if (cellFunction.getSelectedItem().equals("Add")) {
            Job job = defaultFactory.createJob();
            task.addJob(job);
            db.save(job);
            db.save(task);
        } else if (cellFunction.getSelectedItem().equals("Delete")) {
            project.deleteTask(task);
            db.delete(task);
            db.save(project);
        }
    }

    private void cellFunctionProject(Project project) {
        if (cellFunction.getSelectedItem().equals("Add")) {
            Task task = defaultFactory.createTask();
            project.addTask(task);
            db.save(task);
            db.save(project);
        } else if (cellFunction.getSelectedItem().equals("Delete")) {
            db.delete(project);
        }
    }
}
