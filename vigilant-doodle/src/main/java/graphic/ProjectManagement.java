package graphic;

import config.Configuration;
import jdk.nashorn.internal.scripts.JO;
import logic.DefaultFactory;
import logic.schemes.Scheme;
import logic.schemes.job.Job;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by kuujakke on 14.1.2017.
 */
public class ProjectManagement extends JPanel {
    private Configuration config;
    private Scheme scheme;
    private JTree tree;
    private JScrollPane treePanel;
    private JPanel jPanel;
    private JTextField nameText;
    private JTextField descriptionText;
    private JTextArea deadlineText;
    private JTextArea completedText;
    private JTextArea createdText;
    private JButton updateButton;
    private JPanel updatePanel;
    private JSplitPane splitPane;
    private JComboBox cellFunction;
    private JButton OKButton;
    private JPanel editPanel;
    private JPanel functionPanel;
    private Datastore db;
    private DefaultMutableTreeNode clickedNode;
    private TreePath clickedPath;
    private TreeCellEditor cellEditor;
    private DefaultFactory defaultFactory;
    private DefaultMutableTreeNode top;

    public ProjectManagement(Login login) {
        try {
            this.config = login.getConfig();
            this.db = login.getDatabase();
            this.defaultFactory = new DefaultFactory(this.config);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getParent(), e.toString());
            e.printStackTrace();
        }
        splitPane = new JSplitPane();
        splitPane.setResizeWeight(1);
        jPanel = new JPanel();
        jPanel.add(splitPane);
        $$$setupUI$$$();
        splitPane.setLeftComponent(treePanel);
        splitPane.setRightComponent(editPanel);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 1;
        splitPane.setSize(config.getUIWidth() - 50, config.getUIHeight() - 100);
        splitPane.setPreferredSize(new Dimension(config.getUIWidth() - 50, config.getUIHeight() - 100));
        splitPane.setDividerLocation(0.7);
        jPanel.setSize(config.getUIWidth(), config.getUIHeight());
        jPanel.setPreferredSize(new Dimension(config.getUIWidth(), config.getUIHeight()));
        jPanel.add(splitPane, c);
        this.add(jPanel, c);
        this.setVisible(true);
        tree.addTreeSelectionListener(e -> {
            if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node != null && node.getUserObject() instanceof Scheme) {
                    if (node.getUserObject() instanceof Scheme) {
                        scheme = (Scheme) node.getUserObject();
                        if (scheme.getName().isEmpty()) {
                            nameText.setText("");
                        } else {
                            nameText.setText(scheme.getName());
                        }
                        if (scheme.getDescription() == null) {
                            descriptionText.setText("");
                        } else {
                            descriptionText.setText(scheme.getDescription());
                        }
                        if (scheme.getStatus().getStartTime() == null) {
                            createdText.setText("");
                        } else {
                            createdText.setText(scheme.getStatus().getStartTime().toString());
                        }
                        if (scheme.getStatus().getCompleted() == null) {
                            completedText.setText("");
                        } else {
                            completedText.setText(scheme.getStatus().getCompleted().toString());
                        }
                        if (scheme.getStatus().getDeadline() == null) {
                            deadlineText.setText("");
                        } else {
                            deadlineText.setText(scheme.getStatus().getDeadline().toString());
                        }
                    }
                }
            }
        });
        updateButton.addActionListener(e -> {
            if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof  DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node != null && node.getUserObject() instanceof Scheme) {
                    scheme = (Scheme) node.getUserObject();
                    if (scheme.getName() == null) {
                        if (!nameText.getText().isEmpty()) {
                            scheme.setName(nameText.getText());
                        }
                    } else {
                        if (!nameText.getText().equals(scheme.getName())) {
                            scheme.setName(nameText.getText());
                        }
                    }

                    if (scheme.getDescription() == null) {
                        if (!descriptionText.getText().isEmpty()) {
                            scheme.setDescription(descriptionText.getText());
                        }
                    } else {
                        if (!scheme.getDescription().equals(scheme.getDescription())) {
                            scheme.setDescription(descriptionText.getText());
                        }
                    }

                    if (scheme.getStatus().getStartTime() == null) {
                        createdText.setText("");
                    } else {
                        createdText.setText(scheme.getStatus().getStartTime().toString());
                    }

                    if (scheme.getStatus().getCompleted() == null) {
                        completedText.setText("");
                    } else {
                        completedText.setText(scheme.getStatus().getCompleted().toString());
                    }

                    if (scheme.getStatus().getDeadline() == null) {
                        deadlineText.setText("");
                    } else {
                        deadlineText.setText(scheme.getStatus().getDeadline().toString());
                    }
                    db.save(scheme);
                    tree.repaint();
                    tree.updateUI();
                }
            }
        });
        OKButton.addActionListener(e -> {
            if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof DefaultMutableTreeNode) {
                System.out.println("Selected: " + tree.getLastSelectedPathComponent().toString());
                DefaultMutableTreeNode node = ((DefaultMutableTreeNode) tree.getLastSelectedPathComponent());
                if (node != null) {
                    System.out.println("Node: " + node.toString());
                    if (node.getUserObject() instanceof Scheme) {
                        System.out.println("Scheme: " + scheme.toString());
                        scheme = (Scheme) node.getUserObject();
                        if (cellFunction.getSelectedItem().equals("Delete")) {
                            db.delete(scheme);
                        } else {
                            if (scheme instanceof Project) {
                                if (cellFunction.getSelectedItem().equals("Add")) {
                                    Task task = defaultFactory.createTask();
                                    ((Project) scheme).addTask(task);
                                    db.save(task);
                                } else if (cellFunction.getSelectedItem().equals("Delete")) {
                                    db.delete(scheme);
                                }
                            } else if (scheme instanceof Task) {
                                if (cellFunction.getSelectedItem().equals("Add")) {
                                    Job job = defaultFactory.createJob();
                                    ((Task) scheme).addJob(job);
                                    db.save(job);
                                } else if (cellFunction.getSelectedItem().equals("Delete")) {
                                    db.delete(scheme);
                                }
                            } else if (scheme instanceof Job) {
                                if (cellFunction.getSelectedItem().equals("Delete")) {
                                    db.delete(scheme);
                                }
                            }
                            System.out.println("Saving: " + scheme.toString());
                            db.save(scheme);
                        }
                        top.removeAllChildren();
                        createNodes(top);
                        tree.updateUI();
                    } else if (node.toString().equals("Projects")) {
                        scheme = (defaultFactory.createProject());
                        db.save(scheme);
                        top.removeAllChildren();
                        createNodes(top);
                        tree.updateUI();
                    }
                    tree.revalidate();
                }
            }
        });
    }

    private void createUIComponents() {
        top = new DefaultMutableTreeNode("Projects");
        createNodes(top);
        tree = new JTree(top);
        DefaultTreeModel model = new DefaultTreeModel(top);
        tree.setModel(model);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setCellEditor(cellEditor);
        treePanel = new JScrollPane(tree);
        updatePanel = new JPanel();
        tree.repaint();
        tree.updateUI();
    }

    private JPopupMenu getPopUpMenu() {
        if (scheme != null) {
            JPopupMenu menu = new JPopupMenu();
            JMenuItem item = new JMenuItem("delete");
            item.setName("delete");
            item.addActionListener(e -> {
                db.delete(scheme);
                tree.removeSelectionPath(clickedPath);
                tree.repaint();
                tree.updateUI();
            });
            menu.add(item);

            JMenuItem item2 = new JMenuItem("add");
            item2.setName("add");
            item2.addActionListener(e -> {
                try {
                    if (scheme instanceof Project) {
                        System.out.println("Project right clicked!");
                        ((Project) scheme).addTask(defaultFactory.createTask());
                    } else if (scheme instanceof Task) {
                        System.out.println("Task right clicked!");
                        ((Task) scheme).addJob(defaultFactory.createJob());
                    }
                    db.save(scheme);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this.getParent(), "Error with default configuration!" + "\n" + e1.toString());
                }
            });
            menu.add(item2);

            return menu;
        }
        return null;
    }

    private void createNodes(DefaultMutableTreeNode top) {
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
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setBorder(BorderFactory.createTitledBorder(null, "Projects", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font(jPanel.getFont().getName(), jPanel.getFont().getStyle(), jPanel.getFont().getSize())));
        splitPane.setContinuousLayout(false);
        splitPane.setDividerLocation(296);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel.add(splitPane, gbc);
        splitPane.setLeftComponent(treePanel);
        tree.putClientProperty("JTree.lineStyle", "");
        tree.putClientProperty("html.disable", Boolean.FALSE);
        treePanel.setViewportView(tree);
        editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());
        splitPane.setRightComponent(editPanel);
        functionPanel = new JPanel();
        functionPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        editPanel.add(functionPanel, gbc);
        functionPanel.setBorder(BorderFactory.createTitledBorder(null, "Edit", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        OKButton = new JButton();
        OKButton.setText("OK");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 1;
        functionPanel.add(OKButton, gbc);
        cellFunction = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Add");
        defaultComboBoxModel1.addElement("Delete");
        cellFunction.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        functionPanel.add(cellFunction, gbc);
        updatePanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(updatePanel, gbc);
        updatePanel.setBorder(BorderFactory.createTitledBorder("Update"));
        final JLabel label1 = new JLabel();
        label1.setText("Deadline");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Time Completed");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Time Created");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Description");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(label5, gbc);
        nameText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(nameText, gbc);
        descriptionText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(descriptionText, gbc);
        deadlineText = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(deadlineText, gbc);
        completedText = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(completedText, gbc);
        createdText = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        updatePanel.add(createdText, gbc);
        updateButton = new JButton();
        updateButton.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        updatePanel.add(updateButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanel;
    }
}
