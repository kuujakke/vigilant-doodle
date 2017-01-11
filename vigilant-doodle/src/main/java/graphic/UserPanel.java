package graphic;

import config.DefaultSettings;
import org.mongodb.morphia.Datastore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a user panel view.
 */
public class UserPanel extends JPanel implements ActionListener {

    private final Datastore db;

    /**
     * Initializes the object with Datastore object.
     * Calls makeLayout()
     *
     * @param db Datastore object.
     */
    public UserPanel(Datastore db) {
        this.db = db;
        makeLayout();
    }

    /**
     * Places the layout components.
     */
    public void makeLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int width = 10;
        int gridy = 0;
        int gridx = 0;

        String[] columnLabels = {"Name", "Description", "Created", "Deadline", "Expected done"};
        Object[][] data = {
                {DefaultSettings.PROJECT_NAME.toString(),
                DefaultSettings.PROJECT_DESCRIPTION.toString(),
                "Sometime",
                "Yesterday",
                "Next quarter"}
        };

        JTable jTable = new JTable(data, columnLabels);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        add(jScrollPane);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
