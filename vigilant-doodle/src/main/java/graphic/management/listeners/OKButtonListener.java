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

    public OKButtonListener(NodeFactory nodeFactory,
                            JTree tree,
                            Datastore db,
                            Login login,
                            JComboBox cellFunction,
                            DefaultFactory defaultFactory,
                            DefaultMutableTreeNode top
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
                scheme = (Scheme) node.getUserObject();
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                if (scheme instanceof Project) {
                    if (cellFunction.getSelectedItem().equals("Add")) {
                        Task task = defaultFactory.createTask();
                        ((Project) scheme).addTask(task);
                        db.save(task);
                        db.save(scheme);
                    } else if (cellFunction.getSelectedItem().equals("Delete")) {
                        db.delete(scheme);
                    }
                } else if (scheme instanceof Task) {
                    if (cellFunction.getSelectedItem().equals("Add")) {
                        Job job = defaultFactory.createJob();
                        ((Task) scheme).addJob(job);
                        db.save(job);
                        db.save(scheme);
                    } else if (cellFunction.getSelectedItem().equals("Delete")) {
                        Project project = (Project) parent.getUserObject();
                        project.deleteTask((Task) scheme);
                        db.delete(scheme);
                        db.save(project);
                    }
                } else if (scheme instanceof Job) {
                    if (cellFunction.getSelectedItem().equals("Delete")) {
                        Task task = (Task) parent.getUserObject();
                        task.removeJob((Job) scheme);
                        db.delete(scheme);
                        db.save(task);
                    }
                }
            } else if (node.getUserObject().equals(login.getLoginInformation().getProperty("db-name"))) {
                if (cellFunction.getSelectedItem().equals("Add")) {
                    scheme = defaultFactory.createProject();
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
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                model.setRoot(nodeFactory.createNodes());
                tree.expandPath(selectionPath);
                tree.updateUI();
                tree.revalidate();
            }
        }
    }
}
