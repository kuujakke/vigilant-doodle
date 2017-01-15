package graphic;

import config.Configuration;
import config.DefaultSettings;
import logic.DefaultFactory;
import logic.roles.projectroles.Member;
import logic.schemes.Scheme;
import logic.schemes.project.Project;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Creates a user panel view.
 */
public class UserPanel extends JPanel implements ActionListener {

    private Login login;
    private Datastore db;
    private JTable jTable;
    private JTextField newProjectName;

    /**
     * Initializes the object with Login.
     * Afterwards calls makeLayout()
     *
     * @param login Login object.
     */
    public UserPanel(Login login) {
        this.login = login;
        try {
            this.db = this.login.getDatabase();
            this.jTable = createJTable();
            makeLayout();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getParent(), e.toString());
        }
    }

    /**
     * Places the layout components.
     */
    public void makeLayout() {

        updateView();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);

        setConstraints(c, 0, 0);

        add(jScrollPane, c);
        setVisible(true);

        JLabel newProjectNameLabel = new JLabel("Project name: ");
        setConstraints(c, 1, 0);
        c.fill = GridBagConstraints.EAST;
        add(newProjectNameLabel, c);

        this.newProjectName = new JTextField(20);
        setConstraints(c, 2, 0);
        add(this.newProjectName, c);

        JButton addProject = new JButton("Add Project");
        setConstraints(c, 3, 0);
        c.fill = GridBagConstraints.WEST;
        add(addProject, c);
        addProject.addActionListener(this);

        horisontalStrut(2, 1, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String projectName = this.newProjectName.getText();
        Project project = null;
        try {
            project = new DefaultFactory(new Configuration()).createProject(projectName);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this.getParent(), e1.toString());
        }
        db.save(project);
        addRow(project.getName(), project.getDescription(), project.getStatus().getStartTime().toString());
    }

    private JTable createJTable() {
        JTable jTable = new JTable();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Time Created");
        return jTable;
    }

    private void updateView() {
        Query<Project> projects = this.db.createQuery(Project.class);

        for (Project project : projects) {
            String timeCreated = project.getStatus().getStartTime().toString();
            addRow(project.getName(), project.getDescription(), timeCreated);
        }

    }

    private void addRow(String name, String description, String timeCreated) {
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        model.addRow(new Object[]{name, description, timeCreated});
        model.fireTableDataChanged();
    }

    private Object[] getArray(Scheme scheme) {
        Object[] object = new Object[2];
        object[0] = scheme.getName();
        object[1] = scheme.getDescription();
        return object;
    }

    private void setConstraints(GridBagConstraints c, int gridx, int gridy) {
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = gridx;
        c.gridy = gridy;
    }

    private void horisontalStrut(int width, int gridy, GridBagConstraints c) {
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = gridy;
        add(Box.createVerticalStrut(width), c);
    }

}
