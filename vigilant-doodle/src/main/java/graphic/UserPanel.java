package graphic;

import config.DefaultSettings;
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

    private final Datastore db;
    private JTable jTable;
    private JTextField newProjectName;

    /**
     * Initializes the object with Datastore object.
     * Calls makeLayout()
     *
     * @param db Datastore object.
     */
    public UserPanel(Datastore db) {
        this.db = db;
        this.jTable = createJTable();
        makeLayout();
    }

    /**
     * Places the layout components.
     */
    public void makeLayout() {

        Query<Project> projects = this.db.createQuery(Project.class);

        for (Project project : projects) {
            String timeCreated = project.getStatus().getStartTime().toString();
            addRow(project.getName(), project.getDescription(), timeCreated);
        }

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);

        setConstraints(c, 0, 0);

        add(jScrollPane, c);
        setVisible(true);

        int width = 10;
        int gridy = 0;
        int gridx = 0;

        JLabel newProjectNameLabel = new JLabel("Project name: ");
        setConstraints(c, gridx % 2, gridy);
        add(newProjectNameLabel, c);
        gridx++;

        this.newProjectName = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(this.newProjectName, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JTable createJTable() {
        JTable jTable = new JTable();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Time Created");
        return jTable;
    }

    private void addRow(String name, String description, String timeCreated) {
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        model.addRow(new Object[]{name, description, timeCreated});
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
